package com.sjto.service.impl;

import com.sjto.config.Constance;
import com.sjto.domain.AdImgInfo;
import com.sjto.repository.AdImgInfoRepository;
import com.sjto.service.AdImgInfoService;
import com.sjto.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description: 广告位图片信息BLL层实现类
 * @Author: fanyongjiu
 * @Date: 18/5/11 16:09
 */
@Service("adImgInfoService")
public class AdImgInfoServiceImpl extends AbstractGenericServiceImpl<AdImgInfo, Long> implements AdImgInfoService {
    @Autowired
    private AdImgInfoRepository repository;

    @Override
    public JpaRepository<AdImgInfo, Long> getRepository() {
        return repository;
    }

    @Autowired
    private CommonUtil commonUtil;

    @Override
    public Map<String, Object> getImgInfo(Long id) {
        Optional<AdImgInfo> optional = super.findById(id);
        if (!optional.isPresent()) {
            return null;
        }
        Map<String, Object> result = new HashMap<>();
        AdImgInfo adImgInfo = optional.get();
        result.put("bgImgUrl", commonUtil.imageShortToUrl(adImgInfo.getBgImgUrl()));
        result.put("images", dealImages(adImgInfo.getImages()));
        result.put("type", adImgInfo.getType());
        result.put("title", adImgInfo.getTitle());
        result.put("status", adImgInfo.getStatus());
        result.put("url", adImgInfo.getUrl());
        return result;
    }

    @Override
    public List<Map<String, Object>> getList() {
        List<AdImgInfo> list = super.findAll();
        if (list == null) {
            return null;
        }
        List<Map<String, Object>> result = new ArrayList<>();
        for (AdImgInfo item : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("bgImgUrl", commonUtil.imageShortToUrl(item.getBgImgUrl()));
            map.put("images", dealImages(item.getImages()));
            map.put("type", item.getType());
            map.put("title", item.getTitle());
            map.put("status", item.getStatus());
            map.put("url", item.getUrl());
            result.add(map);
        }
        return result;
    }

    @Override
    public Boolean isExist(AdImgInfo entity) {
        Long id = entity.getId();
        String type = entity.getType();
        if (id == null) {
            //不存在
            AdImgInfo adImgInfo = repository.findByType(type);
            return adImgInfo != null;
        } else {
            //存在
            AdImgInfo adImgInfo = repository.findByTypeAndIdNot(type, id);
            return adImgInfo != null;
        }
    }

    private List<String> dealImages(String images) {
        if (images == null || images.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        String[] imagesArr = images.split(Constance.SEPARATOR_JAVA);
        for (String item : imagesArr) {
            list.add(commonUtil.imageShortToUrl(item));
        }
        return list;
    }
}
