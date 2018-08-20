package bitcamp.assignment.service;

import java.util.List;

import bitcamp.assignment.domain.BusinessCard;

public interface BusinessCardService {

    List<BusinessCard> list(int no);

    BusinessCard get(int cardNo, int memberNo);

    int add(BusinessCard bizcard);

    int update(BusinessCard bizcard);

    int delete(int no, int no2);
    
}
