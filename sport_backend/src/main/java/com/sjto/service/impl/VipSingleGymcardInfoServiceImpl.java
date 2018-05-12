package com.sjto.service.impl;

import com.sjto.domain.Card;
import com.sjto.domain.VipSingleGymcardInfo;
import com.sjto.dto.ro.VipSingleGymcardInfoRo;
import com.sjto.enums.AuthState;
import com.sjto.enums.CardKind;
import com.sjto.enums.UseState;
import com.sjto.repository.CardReponsitory;
import com.sjto.repository.VipSingleGymcardInfoReponsitory;
import com.sjto.service.VipSingleGymcardInfoService;
import com.sjto.utils.CommonUtil;
import com.sjto.utils.Result;
import com.sjto.utils.ResultCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName VipSingleGymcardInfoServiceImpl
 * @Description
 * @Author wangsai
 * @Date 2018/5/11 15:32
 **/
@Service("vipSingleGymcardInfoService")
public class VipSingleGymcardInfoServiceImpl extends AbstractGenericServiceImpl<VipSingleGymcardInfo, Long> implements VipSingleGymcardInfoService {

    @Autowired
    private VipSingleGymcardInfoReponsitory reponsitory;
    @Autowired
    private CardReponsitory cardReponsitory;
    @Autowired
    private CommonUtil commonUtil;

    @Override
    public Result<Map> getAuthState(Long userId) {
        VipSingleGymcardInfo vipSingleGymcardInfo = reponsitory.findByUserId(userId);

        if (vipSingleGymcardInfo == null) {
            return Result.createBySuccess(AuthState.NO_AUTHED.toMap());
        }
        // 获取认证状态
        AuthState authState = AuthState.getEnumByCode(vipSingleGymcardInfo.getAuthState());
        if (authState == null) {
            authState = AuthState.NO_AUTHED;
        }

        return Result.createBySuccess(authState.toMap());
    }


    @Override
    public Result<VipSingleGymcardInfoRo> queryVipCardInfo(Long userId) {
        if (userId == null) {
            return Result.createByErrorCodeMessage(ResultCode.ILLEGAL_ARGUMENT.getCode(), ResultCode.ILLEGAL_ARGUMENT.getDesc());
        }

        VipSingleGymcardInfo vipSingleGymcardInfo = null;
        // 根据用户ID查询信息
        if (!reponsitory.existsByUserId(userId)) {
            // 如果会员信息不存在
            vipSingleGymcardInfo = initCardInfo(userId);
        } else {
            vipSingleGymcardInfo = reponsitory.findByUserId(userId);
        }
        VipSingleGymcardInfoRo vipSingleGymcardInfoRo = getVipSingleGymcardInfoRo(vipSingleGymcardInfo);

        if (vipSingleGymcardInfoRo != null) {
            return Result.createBySuccess(vipSingleGymcardInfoRo);
        }

        return Result.createByErrorMessage("没有找到该会员信息");
    }

    @Override
    public Result<VipSingleGymcardInfoRo> auth(String authImgUrl, Long userId) {
        if (userId == null || StringUtils.isAllEmpty(authImgUrl)) {
            return Result.createByErrorCodeMessage(ResultCode.ILLEGAL_ARGUMENT.getCode(), ResultCode.ILLEGAL_ARGUMENT.getDesc());
        }
        if (!reponsitory.existsByUserId(userId)) {
            // 如果用户不存在
            return Result.createByErrorMessage("认证用户不存在");
        }
        VipSingleGymcardInfo vipSingleGymcardInfo = reponsitory.findByUserId(userId);

        vipSingleGymcardInfo.setAuthImgUrl(commonUtil.imageShortToUrl(authImgUrl));

        vipSingleGymcardInfo.setAuthState(AuthState.IN_AUTHING.getCode());

        save(vipSingleGymcardInfo);

        return this.queryVipCardInfo(userId);
    }

    @Override
    public Result<VipSingleGymcardInfoRo> recharge(Integer days, Long userId) {

        if (days <= 0) {
            return Result.createByErrorMessage("请添加充值天数");
        }

        if (!reponsitory.existsByUserId(userId)) {
            // 如果用户不存在
            return Result.createByErrorMessage("充值用户不存在");
        }

        try {

            VipSingleGymcardInfo vipSingleGymcardInfo = reponsitory.findByUserId(userId);

            Date endDate = vipSingleGymcardInfo.getEndDate();
            if (endDate == null) {
                endDate = new Date();
            }

            Calendar cal = Calendar.getInstance();

            cal.setTime(endDate);

            // 计算并累加日期
            cal.add(Calendar.DATE, days);

            vipSingleGymcardInfo.setEndDate(cal.getTime());

            vipSingleGymcardInfo.setUpdateTime(new Date());

            save(vipSingleGymcardInfo);
        }catch (Exception e){
            return Result.createByErrorCodeMessage(ResultCode.EXCEPTION.getCode(),ResultCode.EXCEPTION.getDesc());
        }
        return this.queryVipCardInfo(userId);
    }


    /**
     * 视图对象返回封装处理
     *
     * @param vipSingleGymcardInfo
     * @return
     */
    private VipSingleGymcardInfoRo getVipSingleGymcardInfoRo(VipSingleGymcardInfo vipSingleGymcardInfo) {

        if (vipSingleGymcardInfo == null) {
            return null;
        }

        VipSingleGymcardInfoRo vipSingleGymcardInfoRo = new VipSingleGymcardInfoRo();

        vipSingleGymcardInfoRo.setId(vipSingleGymcardInfo.getId());

        vipSingleGymcardInfoRo.setUserId(vipSingleGymcardInfo.getUserId());

        vipSingleGymcardInfoRo.setActiveTime(vipSingleGymcardInfo.getActiveTime());

        // 获取认证状态
        AuthState authState = AuthState.getEnumByCode(vipSingleGymcardInfo.getAuthState());

        if (authState == null) {
            authState = AuthState.NO_AUTHED;
        }

        if (authState.getCode() != AuthState.NO_AUTHED.getCode()) {
            vipSingleGymcardInfoRo.setAuthImgUrl(commonUtil.imageShortToUrl(vipSingleGymcardInfo.getAuthImgUrl()));
        }

        vipSingleGymcardInfoRo.setAuthState(authState.toMap());


        // 判断是否在有效期
        Date date = vipSingleGymcardInfo.getEndDate();

        if (date == null) {
            vipSingleGymcardInfoRo.setUseState(UseState.UN_USE.toMap());
        } else {
            vipSingleGymcardInfoRo.setEndDate(date);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Integer queryDate = Integer.valueOf(sdf.format(date));
            Integer nowDate = Integer.valueOf(sdf.format(new Date()));
            if (queryDate < nowDate) {
                vipSingleGymcardInfoRo.setUseState(UseState.NO_USE.toMap());
            } else {
                vipSingleGymcardInfoRo.setUseState(UseState.IN_USE.toMap());
            }
        }
        // 设置卡的背景色和名称
        Optional<Card> optional = cardReponsitory.findById(vipSingleGymcardInfo.getCid());
        if (optional.isPresent()) {
            vipSingleGymcardInfoRo.setBgImgUrl(commonUtil.imageShortToUrl(optional.get().getBgImgUrl()));
            vipSingleGymcardInfoRo.setCardName(optional.get().getName());
        }

        return vipSingleGymcardInfoRo;
    }


    /**
     * 初始化一个单人会员健身卡信息
     *
     * @param userId
     * @return
     */
    private VipSingleGymcardInfo initCardInfo(Long userId) {
        VipSingleGymcardInfo vipSingleGymcardInfo = new VipSingleGymcardInfo();
        vipSingleGymcardInfo.setUpdateTime(new Date());
        vipSingleGymcardInfo.setCreateTime(new Date());
        vipSingleGymcardInfo.setUserId(userId);
        vipSingleGymcardInfo.setCid(CardKind.VIP_SINGLR_GYM.getCode());
        vipSingleGymcardInfo.setAuthState(AuthState.NO_AUTHED.getCode());
        return save(vipSingleGymcardInfo);
    }

    @Override
    public JpaRepository<VipSingleGymcardInfo, Long> getRepository() {
        return reponsitory;
    }
}
