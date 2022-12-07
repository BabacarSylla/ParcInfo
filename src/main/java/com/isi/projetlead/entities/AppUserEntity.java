package com.isi.projetlead.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class AppUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 80, nullable = false)
    private String nom;
    @Column(length = 100, nullable = false)
    private String prenom;
    @Column(length = 100, nullable = false, unique = true)
    private String email;
    @Column(length = 150, nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRolesEntity> appRoleEntities = new ArrayList<AppRolesEntity>();
}
