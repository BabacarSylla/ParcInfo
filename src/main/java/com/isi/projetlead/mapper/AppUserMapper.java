package com.isi.projetlead.mapper;

import com.isi.projetlead.domaine.AppRoles;
import com.isi.projetlead.domaine.AppUser;
import com.isi.projetlead.entities.AppRolesEntity;
import com.isi.projetlead.entities.AppUserEntity;
import org.mapstruct.Mapper;

@Mapper

public interface AppUserMapper {
    AppUser toAppUsers(AppUserEntity appUsersEntity);
    AppUser fromAppUsers(AppUser appUsersEntity);
}
