package com.eis.service.dmdversion;

import com.eis.dto.dmdversion.DmdVersionDto;
import com.eis.mapper.dmdversion.DmdVersionMapper;
import com.eis.model.customer.Product;
import com.eis.model.dmdversion.DmdVersion;
import com.eis.repo.SearchCriteria;
import com.eis.repo.customer.ProductRepo;
import com.eis.repo.dmdversion.DmdVersionRepo;
import com.eis.repo.dmdversion.DmdVersionSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<DmdVersionDto> findAllByProduct(Long productId) {
        ArrayList<DmdVersionDto> result = new ArrayList<>();
        if (productId != null) {

            DmdVersionSpecification spec = new DmdVersionSpecification(new SearchCriteria("productId", ":", productId));

            List<DmdVersion> versions = dmdVersionRepo.findAll(spec) ;
            result.addAll(versions.stream().map(DmdVersionMapper::toDto).collect(Collectors.toList()));
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
