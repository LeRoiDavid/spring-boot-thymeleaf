package com.lrd.webspringthymeleaf.mappers;

import com.lrd.webspringthymeleaf.dto.ProfesseurDto;
import com.lrd.webspringthymeleaf.entities.Professeur;

import org.mapstruct.Mapper;

@Mapper
public interface ProfesseurMapper {
    ProfesseurDto toAppRoles(Professeur professeur);

    Professeur fromRoleDto(ProfesseurDto professeurDto);
}
