package com.eis.repo.dmdversion;


import com.eis.model.dmdversion.DmdVersion;
import com.eis.repo.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


//http://www.baeldung.com/rest-api-search-language-spring-data-specifications
public class DmdVersionSpecification implements Specification<DmdVersion> {

    private SearchCriteria criteria;

    public DmdVersionSpecification(SearchCriteria searchCriteria) {
        this.criteria = searchCriteria;
    }


    @Override
    public Predicate toPredicate
            (Root<DmdVersion> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(
                    root.<String>get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
                    root.<String>get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(
                        root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        return null;
    }
}