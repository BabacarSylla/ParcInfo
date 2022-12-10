package com.isi.projetlead.domaine;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data

public class AppRoles {

    private int id;
    @NotNull(message = "le nom ne doit pas etre null")
    private String nom;



}
