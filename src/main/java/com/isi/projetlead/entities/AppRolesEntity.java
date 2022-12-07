package com.isi.projetlead.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class AppRolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, length = 100, nullable = false)
    private String nom;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppUserEntity> appUserEntities = new ArrayList<AppUserEntity>();


}
