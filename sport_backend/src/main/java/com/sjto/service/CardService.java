package com.sjto.service;

import com.sjto.domain.Card;
import com.sjto.utils.Result;

/**
 * @ClassName CardService
 * @Author wangsai
 * @Date 2018/5/11 13:09
 **/
public interface CardService extends BaseService<Card, Long>{

    Result saveOrUpdate(Card card);
}
