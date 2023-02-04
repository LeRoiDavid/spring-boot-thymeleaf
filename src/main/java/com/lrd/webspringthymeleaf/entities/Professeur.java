package com.lrd.webspringthymeleaf.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "professeurs")
public class Professeur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 80)
    @Column(length = 80)
    private String prenom;

    @Size(max = 80)
    @Column(length = 80)
    private String nom;

    @Size(max = 100)
    @NotBlank
    @Email
    @Column(length = 100)
    private String email;

    @Column(length = 150)
    @NotBlank
    private String password;

    @Column(columnDefinition = "boolean default true")
    private boolean etat;

    public boolean getEtat() {
        return etat;
    }

    public boolean setEtat(boolean etat) {
        return this.etat = etat;
    }

}
