package com.sjto.repository;

import com.sjto.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardReponsitory extends JpaRepository<Card, Long> {

}
