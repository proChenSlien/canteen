package com.sjto.service.impl;

import com.sjto.domain.Card;
import com.sjto.domain.VipChildCardInfo;
import com.sjto.dto.ro.VipChildCardInfoRo;
import com.sjto.dto.vo.VipChildCardInfoVo;
import com.sjto.enums.AuthState;
import com.sjto.enums.UseState;
import com.sjto.repository.CardReponsitory;
import com.sjto.repository.VipChildCardInfoRepository;
import com.sjto.repository.VipSingleGymcardInfoReponsitory;
import com.sjto.service.VipChildCardInfoService;
import com.sjto.utils.BeanMapper;
import com.sjto.utils.CommonUtil;
import com.sjto.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName VipChildCardInfoServiceImpl
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 17:55
 **/
@Service("vipChildCardInfoService")
public class VipChildCardInfoServiceImpl extends AbstractGenericServiceImpl<VipChildCardInfo, Long> implements VipChildCardInfoService {

    @Autowired
    private VipChildCardInfoRepository repository;

    @Autowired
    private VipSingleGymcardInfoReponsitory vipSingleGymcardInfoReponsitory;

    @Autowired
    private CardReponsitory cardReponsitory;

    @Autowired
    private CommonUtil commonUtil;

    @Override
    public JpaRepository<VipChildCardInfo, Long> getRepository() {
        return repository;
    }

    @Override
    public Result<List<VipChildCardInfoRo>> queryByUserId(Long userId) {

        if(!vipSingleGymcardInfoReponsitory.existsByUserId(userId)){
            return Result.createByErrorMessage("用户不存在");
        }

        List<VipChildCardInfo> vipChildCardInfoList = repository.queryByUserId(userId);

        List<VipChildCardInfoRo> vipChildCardInfoRoList = Lists.newArrayList();

        for (VipChildCardInfo vipChildCardInfo: vipChildCardInfoList) {
            vipChildCardInfoRoList.add(renderVipChildCardInfoRo(vipChildCardInfo));
        }

        return Result.createBySuccess(vipChildCardInfoRoList);
    }

    @Override
    public Result<VipChildCardInfoRo> queryVipCardInfo(Long userId, Long id) {

        VipChildCardInfo vipChildCardInfo = repository.queryByUserIdAndId(userId, id);

        if(vipChildCardInfo == null){
            return Result.createByErrorMessage("没有找到该用户的亲密卡信息");
        }

        return Result.createBySuccess(renderVipChildCardInfoRo(vipChildCardInfo));
    }

    @Override
    public Result<Map> getAuthState(Long id) {
        Optional<VipChildCardInfo> optional = findById(id);
        if (!optional.isPresent()){
            return Result.createBySuccess(AuthState.NO_AUTHED.toMap());
        }
        // 获取认证状态
        AuthState authState = AuthState.getEnumByCode(optional.get().getAuthState());
        if (authState == null) {
            authState = AuthState.NO_AUTHED;
        }
        return Result.createBySuccess(authState.toMap());
    }

    @Override
    public Result<VipChildCardInfoRo> add(Long userId, VipChildCardInfoVo info) {

        if(!vipSingleGymcardInfoReponsitory.existsByUserId(userId)){
            return Result.createByErrorMessage("用户不存在无法添加信息");
        }
        if(StringUtils.isAllEmpty(info.getBabyName())){
            return Result.createByErrorMessage("宝贝姓名不能为空");
        }
        if(info.getBabySex() == null){
            return Result.createByErrorMessage("用户不存在无法添加信息");
        }
        VipChildCardInfo vipChildCardInfo = new VipChildCardInfo();
        vipChildCardInfo.setBabyName(info.getBabyName());
        vipChildCardInfo.setBabySex(info.getBabySex());

        if(StringUtils.isAllEmpty(info.getAuthImgUrl())){

        }

        return null;
    }


    private VipChildCardInfoRo renderVipChildCardInfoRo(VipChildCardInfo vipChildCardInfo){
        if (vipChildCardInfo == null) {
            return null;
        }

        VipChildCardInfoRo vipChildCardInfoRo = new VipChildCardInfoRo();

        vipChildCardInfoRo.setBabyName(vipChildCardInfo.getBabyName());

        vipChildCardInfoRo.setId(vipChildCardInfo.getId());

        vipChildCardInfoRo.setBabySex(vipChildCardInfo.getBabySex());

        vipChildCardInfoRo.setMainUserId(vipChildCardInfo.getMainUserId());

        // 获取认证状态
        AuthState authState = AuthState.getEnumByCode(vipChildCardInfo.getAuthState());

        if (authState == null) {
            authState = AuthState.NO_AUTHED;
        }

        if (authState.getCode() != AuthState.NO_AUTHED.getCode()) {
            vipChildCardInfoRo.setAuthImgUrl(commonUtil.imageShortToUrl(vipChildCardInfo.getAuthImgUrl()));
        }

        vipChildCardInfoRo.setAuthState(authState.toMap());

        // 判断是否在有效期
        Date date = vipChildCardInfo.getEndDate();

        if (date == null) {
            vipChildCardInfoRo.setUseState(UseState.UN_USE.toMap());
        } else {
            vipChildCardInfoRo.setEndDate(date);
            vipChildCardInfoRo.setActiveTime(vipChildCardInfo.getActiveTime());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Integer queryDate = Integer.valueOf(sdf.format(date));
            Integer nowDate = Integer.valueOf(sdf.format(new Date()));
            if (queryDate < nowDate) {
                vipChildCardInfoRo.setUseState(UseState.NO_USE.toMap());
            } else {
                vipChildCardInfoRo.setUseState(UseState.IN_USE.toMap());
            }
        }

        // 设置卡的背景色和名称
        Optional<Card> optional = cardReponsitory.findById(vipChildCardInfo.getCid());
        if (optional.isPresent()) {
            vipChildCardInfoRo.setBgImgUrl(commonUtil.imageShortToUrl(optional.get().getBgImgUrl()));
            vipChildCardInfoRo.setCardName(optional.get().getName());
        }

        return vipChildCardInfoRo;
    }
}
