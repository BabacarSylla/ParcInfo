package com.isi.projetlead.domaine;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppUser {
    private int id;
    @NotNull(message = "le nom ne doit pas etre null")
    private String nom;
    @NotNull(message = "le prenom ne doit pas etre null")
    private String prenom;
    @NotNull(message = "l'email ne doit pas etre null")
    private String email;
    @NotNull(message = "le mot de passe ne doit pas etre null")
    private String password;
}
