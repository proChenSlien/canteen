package com.sjto.service.impl;

import com.sjto.domain.Card;
import com.sjto.repository.CardReponsitory;
import com.sjto.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("cardService")
public class CardServiceImpl extends AbstractGenericServiceImpl<Card, Long> implements CardService{

    @Autowired
    private CardReponsitory reponsitory;

    @Override
    public JpaRepository<Card, Long> getRepository() {
        return reponsitory;
    }

}
