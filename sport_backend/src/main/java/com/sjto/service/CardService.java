package com.sjto.service;

import com.sjto.domain.Card;
import com.sjto.utils.Result;

import java.util.Map;

/**
 * @ClassName CardService
 * @Author wangsai
 * @Date 2018/5/11 13:09
 **/
public interface CardService extends BaseService<Card, Long>{

    Result saveOrUpdate(Card card);

    Result<Map> queryList(int size, int page, Card entity);
}
