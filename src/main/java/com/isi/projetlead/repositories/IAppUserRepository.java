package com.isi.projetlead.repositories;

import com.isi.projetlead.entities.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUserEntity, Integer> {
    AppUserEntity findEmail(String email);
}
