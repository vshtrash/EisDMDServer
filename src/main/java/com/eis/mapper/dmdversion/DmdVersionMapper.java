package com.eis.mapper.dmdversion;


import com.eis.dto.dmdversion.DmdVersionDto;
import com.eis.model.dmdversion.DmdVersion;
import org.modelmapper.ModelMapper;

public class DmdVersionMapper {
    public static DmdVersionDto toDto(DmdVersion dmdVersion) {
        if (dmdVersion == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        DmdVersionDto dmdVersionDto = modelMapper.map(dmdVersion, DmdVersionDto.class);
        return dmdVersionDto;
    }

    public static DmdVersion toEntity(DmdVersionDto dmdVersionDto) {
        if (dmdVersionDto == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        DmdVersion dmdVersion = modelMapper.map(dmdVersionDto, DmdVersion.class);
        return dmdVersion;
    }


}
