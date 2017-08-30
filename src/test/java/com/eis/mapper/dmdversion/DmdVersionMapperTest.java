package com.eis.mapper.dmdversion;

import com.eis.dto.dmdversion.DmdVersionDto;
import com.eis.model.dmdversion.DmdVersion;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DmdVersionMapperTest {
    @Test
    public void toDtoTest() {
        DmdVersion dmdVersion = new DmdVersion(1, "Name", true);
        DmdVersionDto dmdVersionDto = DmdVersionMapper.toDto(dmdVersion);

        assertThat(dmdVersion.getName()).as("check name: %s", dmdVersion.getName()).isEqualTo(dmdVersionDto.getName());
        assertThat(dmdVersion.getEnabled()).as("check enabled: %s", dmdVersion.getEnabled()).isEqualTo(dmdVersionDto.getEnabled());
        assertThat(dmdVersion.getProductId()).as("check of productId: %s", dmdVersion.getProductId()).isEqualTo(dmdVersionDto.getProductId());
    }

    @Test
    public void toEntityTest() {
        DmdVersionDto dmdVersionDto = new DmdVersionDto(1, 1, "Name", true);
        DmdVersion dmdVersion = DmdVersionMapper.toEntity(dmdVersionDto);

        assertThat(dmdVersionDto.getName()).as("check name: %s", dmdVersionDto.getName()).isEqualTo(dmdVersion.getName());
        assertThat(dmdVersionDto.getEnabled()).as("check enabled: %s", dmdVersionDto.getEnabled()).isEqualTo(dmdVersionDto.getEnabled());
        assertThat(dmdVersionDto.getProductId()).as("check of productId: %s", dmdVersionDto.getProductId()).isEqualTo(dmdVersion.getProductId());

    }
}





