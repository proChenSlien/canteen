package com.sjto.service.impl;

import com.sjto.domain.SysButtonInfo;
import com.sjto.repository.SysButtonInfoRepository;
import com.sjto.service.SysButtonInfoService;
import com.sjto.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @Description: 按钮信息BLL层实现类
 * @Author: fanyongjiu
 * @Date: 18/5/11 11:35
 */
@Service("sysButtonInfoService")
public class SysButtonInfoServiceImpl extends AbstractGenericServiceImpl<SysButtonInfo, Long> implements SysButtonInfoService {

    @Autowired
    private SysButtonInfoRepository repository;

    @Autowired
    private CommonUtil commonUtil;

    @Override
    public JpaRepository<SysButtonInfo, Long> getRepository() {
        return repository;
    }

    @Override
    public SysButtonInfo getOneByType(String type) {
        SysButtonInfo sysButtonInfo = repository.findByType(type);
        if (sysButtonInfo == null) {
            return null;
        }
        sysButtonInfo.setImage(commonUtil.imageShortToUrl(sysButtonInfo.getImage()));
        return sysButtonInfo;
    }

    @Override
    public Boolean isExist(SysButtonInfo entity) {
        Long id = entity.getId();
        String type = entity.getType();
        if (id == null) {
            //不存在
            SysButtonInfo sysButtonInfo = repository.findByType(type);
            return sysButtonInfo != null;
        } else {
            //存在
            SysButtonInfo sysButtonInfo = repository.findByTypeAndIdNot(type, id);
            return sysButtonInfo != null;
        }
    }
}
