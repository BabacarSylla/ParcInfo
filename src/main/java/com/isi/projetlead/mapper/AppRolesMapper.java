package com.isi.projetlead.mapper;


import com.isi.projetlead.domaine.AppRoles;
import com.isi.projetlead.entities.AppRolesEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AppRolesMapper {
    AppRoles toAppRoles(AppRolesEntity appRolesEntity);
    AppRolesEntity fromAppRoles(AppRoles appRoles);
}

