package bitcamp.assignment.repository;

import java.util.HashMap;
import java.util.List;

import bitcamp.assignment.domain.BusinessCard;

public interface BusinessCardRepository {

    List<BusinessCard> findByMemberNo(int no);

    BusinessCard findByCardNoAndMemberNo(HashMap<String, Object> params);

    int insert(BusinessCard bizcard);

    int update(BusinessCard bizcard);

    int delete(HashMap<String, Object> params);

}
