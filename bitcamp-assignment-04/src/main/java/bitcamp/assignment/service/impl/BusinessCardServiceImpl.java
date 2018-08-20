package bitcamp.assignment.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.assignment.domain.BusinessCard;
import bitcamp.assignment.repository.BusinessCardRepository;
import bitcamp.assignment.service.BusinessCardService;

@Service
public class BusinessCardServiceImpl 
    implements BusinessCardService {
    
    BusinessCardRepository bizcardRepository;
    
    public BusinessCardServiceImpl(
            BusinessCardRepository bizcardRepository) {
        this.bizcardRepository = bizcardRepository;
    }
    
    @Override
    public List<BusinessCard> list(int no) {
        return bizcardRepository.findByMemberNo(no);
    }
}






