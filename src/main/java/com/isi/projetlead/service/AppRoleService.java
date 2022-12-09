package com.isi.projetlead.service;

import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service

public class AppRoleService {
    IAppRolesRepository iAppRolesRepository;
    IAppRolesRepository iAppUserRepository;
    AppRolesMapper appRolesMapper;
    MessageSource messageSource;

    @Transactional(readOnly = true)
    public Page<AppRoles> getAppRoles(Pageable pageable) {
        return iAppRolesRepository.findAll(pageable).map(appRolesMapper::toAppRoles);
    }

    @Transactional(readOnly = true)
    public AppRoles getAppRole(int id) {
        return appRolesMapper.toAppRoles(iAppRolesRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public AppRoles createAppRoles(AppRoles appRoles) {
        iAppRolesRepository.findById(appRoles.getId())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("role.exists", new Object[]{appRoles.getId()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        return appRolesMapper.toAppRoles(iAppRolesRepository.save(appRolesMapper.fromAppRoles(appRoles)));
    }

    @Transactional
    public AppRoles updateAppRoles(int id, AppRoles appRoles){
        return iAppRolesRepository.findById(id)
                .map(entity -> {
                    appRoles.setId(id);
                    return appRolesMapper.toAppRoles(iAppRolesRepository.save(appRolesMapper.fromAppRoles(appRoles)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound",
                        new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteAppRoles(int id) {
        try {
            iAppRolesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("role.error-deletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatusatus.CONFLICT);
        }
    }
}
