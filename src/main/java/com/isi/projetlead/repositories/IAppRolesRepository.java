package com.isi.projetlead.repositories;


import com.isi.projetlead.entities.AppRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRolesRepository extends JpaRepository<AppRolesEntity, Integer> {
}
