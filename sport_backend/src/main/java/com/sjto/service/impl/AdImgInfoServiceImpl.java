package com.sjto.service.impl;

import com.sjto.config.Constance;
import com.sjto.domain.AdImgInfo;
import com.sjto.domain.SysDictionary;
import com.sjto.repository.AdImgInfoRepository;
import com.sjto.repository.SysDictionaryRepository;
import com.sjto.service.AdImgInfoService;
import com.sjto.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @Autowired
    private SysDictionaryRepository sysDictionaryRepository;

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
        result.put("urlXCX", adImgInfo.getUrlXCX());
        result.put("urlH5", adImgInfo.getUrlH5());
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
            map.put("urlXCX", item.getUrlXCX());
            map.put("urlH5", item.getUrlH5());
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

    @Override
    public Page<AdImgInfo> getAll(int page, int size, AdImgInfo entity) {
        Page<AdImgInfo> current = this.findAll(page - 1, size, entity);
        if (current.getContent().size() > 0) {
            this.getDictionaryRemark(current);
        }
        return current;
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

    private Map<Long, List<SysDictionary>> getDictionaryList() {
        List<SysDictionary> list = sysDictionaryRepository.findAll();
        Map<Long, List<SysDictionary>> map = new HashMap<>();
        if (list == null) {
            return map;
        }
        for (SysDictionary item : list) {
            if (map.containsKey(item.getGroupId())) {
                List<SysDictionary> tempList = map.get(item.getGroupId());
                tempList.add(item);
                map.put(item.getGroupId(), tempList);
            } else {
                List<SysDictionary> tempList = new ArrayList<>();
                tempList.add(item);
                map.put(item.getGroupId(), tempList);
            }
        }
        return map;
    }

    private void getDictionaryRemark(Page<AdImgInfo> current) {
        Map<Long, List<SysDictionary>> map = this.getDictionaryList();

        List<AdImgInfo> adImgInfoList = current.getContent();
        for (AdImgInfo item : adImgInfoList) {
            String type = item.getType();
            Long groupId = Long.parseLong(type.split(Constance.SEPARATOR_JAVA)[0]);
            Integer val = Integer.parseInt(type.split(Constance.SEPARATOR_JAVA)[1]);
            String remark = "未知";
            if (map.containsKey(groupId)) {
                List<SysDictionary> list = map.get(groupId);
                for (SysDictionary model : list) {
                    if (model.getVal().intValue() == val) {
                        remark = model.getRemark();
                        break;
                    }
                }
            }
            item.setType(remark);
        }
    }


}
