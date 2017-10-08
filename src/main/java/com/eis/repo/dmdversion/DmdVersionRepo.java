package com.eis.repo.dmdversion;

import com.eis.dto.dmdversion.DmdVersionDto;
import com.eis.model.dmdversion.DmdVersion;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DmdVersionRepo extends JpaRepository<DmdVersion, Long>, JpaSpecificationExecutor {
    List<DmdVersionDto> findAllByProduct(Specification <DmdVersion> specification);
}
