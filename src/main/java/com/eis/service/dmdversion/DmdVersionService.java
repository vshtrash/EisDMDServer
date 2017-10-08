package com.eis.service.dmdversion;

import com.eis.dto.dmdversion.DmdVersionDto;
import com.eis.mapper.dmdversion.DmdVersionMapper;
import com.eis.model.customer.Product;
import com.eis.model.dmdversion.DmdVersion;
import com.eis.repo.customer.ProductRepo;
import com.eis.repo.dmdversion.DmdVersionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("dmdVersionService")
public class DmdVersionService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    DmdVersionRepo dmdVersionRepo;

    @Transactional
    public DmdVersionDto getByProductIdAndId(Long productId, Long id) {
        DmdVersionDto result = null;
        if (productId != null) {
            Product product = productRepo.findOne(productId);
            if (product != null) {
                DmdVersion dmdVersion = dmdVersionRepo.findOne(id);
                if (dmdVersion != null) {
                    if (dmdVersion.getProductId() == productId) {
                        result = DmdVersionMapper.toDto(dmdVersion);
                    }
                }
            }
        }
        return result;
    }


    @Transactional
    public ArrayList<DmdVersionDto> getAll(Long productId) {
        ArrayList<DmdVersionDto> result = new ArrayList<>();

        if (productId != null) {
            Product product = productRepo.findOne(productId);
//            if (product != null) {
//                DmdVersion dmdVersion = dmdVersionRepo.findAllByProduct() ;
//                if (dmdVersion != null) {
//                    if (dmdVersion.getProductId() == productId) {
//                        result = DmdVersionMapper.toDto(dmdVersion);
//                    }
//                }
//            }
        }
        return result;
    }

//
//    @Transactional
//    public CustomerDto createCustomer(CustomerDto customerDto) {
//        Customer customer = CustomerMapper.toEntity(customerDto);
//        customer = customerRepo.save(customer);
//        customerDto = CustomerMapper.toDto(customer);
//        return customerDto;
//    }
//
//    @Transactional
//    public CustomerDto updateCustomer(CustomerDto customerDto) {
//        Customer customer = CustomerMapper.toEntity(customerDto);
//        customer = customerRepo.save(customer);
//        customerDto = CustomerMapper.toDto(customer);
//        return customerDto;
//    }

}
