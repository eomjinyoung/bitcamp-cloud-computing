package bitcamp.assignment.repository;

import java.util.List;

import bitcamp.assignment.domain.BusinessCard;

public interface BusinessCardRepository {

    List<BusinessCard> findByMemberNo(int no);

}
