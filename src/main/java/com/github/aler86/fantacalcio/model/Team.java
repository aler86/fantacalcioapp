package com.github.aler86.fantacalcio.model;

import javax.persistence.*;

import java.util.Set;

/**
 * Created by ADMIN on 30/10/2014.
 */

@Entity
public class Team extends JsonObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;


   /* @Column(nullable = false)
    private User utente;
    */
    @ManyToOne (fetch = FetchType.EAGER) //relazione 1 a 1
    @JoinColumn(nullable=false)
     private User utente;//relazione 1 a 1

   @ManyToMany(mappedBy = "team",fetch = FetchType.EAGER) //relazione 1 a molti
    private transient Set<League> league;//relazione 1 a molti

    @OneToMany(mappedBy = "team",fetch = FetchType.EAGER) //relazione 1 a molti
    private transient Set<Player> player;//relazione 1 a molti

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public User getUtente() {
        return utente;
    }

    public void setUtente(User utente) {
        this.utente = utente;
    }



   public Set<League> getLeague() {
        return league;
    }

    public void setLeague(Set<League> league) {
        this.league = league;
    }

    public Set<Player> getPlayer() {
        return player;
    }

    public void setPlayer(Set<Player> player) {
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
