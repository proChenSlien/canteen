package com.sjto.service.impl;

import com.sjto.domain.Card;
import com.sjto.repository.CardReponsitory;
import com.sjto.service.CardService;
import com.sjto.utils.Result;
import com.sjto.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service("cardService")
public class CardServiceImpl extends AbstractGenericServiceImpl<Card, Long> implements CardService{

    @Autowired
    private CardReponsitory reponsitory;

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


}
