package com.sjto.service.impl;

import com.google.common.collect.Maps;
import com.sjto.domain.Card;
import com.sjto.repository.CardReponsitory;
import com.sjto.service.CardService;
import com.sjto.utils.CommonUtil;
import com.sjto.utils.Result;
import com.sjto.utils.ResultCode;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service("cardService")
public class CardServiceImpl extends AbstractGenericServiceImpl<Card, Long> implements CardService{

    @Autowired
    private CardReponsitory reponsitory;

    @Autowired
    private CommonUtil commonUtil;

    @Override
    public JpaRepository<Card, Long> getRepository() {
        return reponsitory;
    }

    @Override
    @Transactional
    public Result<Card> saveOrUpdate(Card card) {
        card.setUpdateTime(new Date());
        Long id = card.getId();
        try {
            if((id != null && !findById(id).isPresent()) || id == null){// 如果ID为空 或者数据不存在
                card.setCreateTime(new Date());
                return Result.createBySuccess(reponsitory.save(card));
            }
            reponsitory.update(card.getName(),card.getType(),card.getStatus(), card.getBgImgUrl(),card.getUpdateTime(),card.getId());
        }catch (Exception e){
            e.printStackTrace();
            return Result.createByErrorCodeMessage(ResultCode.EXCEPTION.getCode(),ResultCode.EXCEPTION.getDesc());
        }
        return Result.createBySuccess(card);
    }

    @Override
    public Result<Map> queryList(int size, int page, Card entity) {
        Page<Card> current = findAll(page -1 ,size,entity);
        List<Card> list = Lists.newArrayList();
        Iterator<Card> iterator = current.iterator();
        while (iterator.hasNext()){
            Card card = iterator.next();
            card.setBgImgUrl(commonUtil.imageShortToUrlWithOutSuffix(card.getBgImgUrl()));
            list.add(card);
        }
        PageImpl resultPage = new PageImpl(list, current.getPageable(), current.getTotalPages());
        Map map = Maps.newHashMap();
        map.put("page",resultPage);
        return Result.createBySuccess(map);
    }


}
