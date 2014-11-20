package com.github.aler86.fantacalcio.model;

import javax.persistence.*;

/**
 * Created by ADMIN on 30/10/2014.
 */
@Entity
public class Player extends JsonObject{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Integer costo;

    @Column(nullable = false)
    private String ruolo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @OneToOne(fetch = FetchType.EAGER) //relazione 1 a 1
    private Team team;//relazione 1 a 1



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
}
