package com.sjto.service.impl;

import com.sjto.domain.ContentInfo;
import com.sjto.repository.ContentInfoRepository;
import com.sjto.service.ContentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @Description: 内容说明信息BLL层实现类
 * @Author: fanyongjiu
 * @Date: 18/5/11 18:00
 */
@Service("contentInfoService")
public class ContentInfoServiceImpl extends AbstractGenericServiceImpl<ContentInfo, Long> implements ContentInfoService {
    @Autowired
    private ContentInfoRepository repository;

    @Override
    public JpaRepository<ContentInfo, Long> getRepository() {
        return repository;
    }

    @Override
    public ContentInfo getByType(String type) {
        return repository.findByType(type);
    }

    @Override
    public Boolean isExist(ContentInfo entity) {
        Long id = entity.getId();
        String type = entity.getType();
        if (id == null) {
            //不存在
            ContentInfo contentInfo = repository.findByType(type);
            return contentInfo != null;
        } else {
            //存在
            ContentInfo contentInfo = repository.findByTypeAndIdNot(type, id);
            return contentInfo != null;
        }
    }
}
