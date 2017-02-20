package com.softdesign.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by malek on 27/01/17.
 */
@Entity
@Table(name = "user")
public class User {

    private long id;
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    private String email;
    private String numeroTelFixe;
    private String numeroTelMobile;

    public User() {
    }

    public User(long id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "nom", length = 50)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name = "prenom", length = 100)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Column(name = "login", length = 100)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email", length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "numero_tel_fixe", length = 15)
    public String getNumeroTelFixe() {
        return numeroTelFixe;
    }

    public void setNumeroTelFixe(String numeroTelFixe) {
        this.numeroTelFixe = numeroTelFixe;
    }

    @Column(name = "numero_tel_mobile", length = 15)
    public String getNumeroTelMobile() {
        return numeroTelMobile;
    }

    public void setNumeroTelMobile(String numeroTelMobile) {
        this.numeroTelMobile = numeroTelMobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (!getLogin().equals(user.getLogin())) return false;
        return getEmail().equals(user.getEmail());

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getLogin().hashCode();
        result = 31 * result + getEmail().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", numeroTelFixe='" + numeroTelFixe + '\'' +
                ", numeroTelMobile='" + numeroTelMobile + '\'' +
                '}';
    }
}
