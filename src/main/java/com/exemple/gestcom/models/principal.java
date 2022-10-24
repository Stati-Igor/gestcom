package com.exemple.gestcom.models;


import javax.persistence.*;



@Entity
@IdClass(princpalDubKeys.class)
public class principal {

    @Id
    public Long ID_COMANDA;
    @Id
    public Long ID_ARTICOL ;

    private Long Cantitatea,Cantitatea_de_produs;
    private String Statut_comanda;

    public Long getCantitatea(){return Cantitatea;}
    public void setCantitatea(Long Cantitatea){
        this.Cantitatea = Cantitatea;
    }
    public Long getCantitatea_de_produs(){return Cantitatea_de_produs;}
    public void setCantitatea_de_produs(Long Cantitatea_de_produs){
        this.Cantitatea_de_produs = Cantitatea_de_produs;
    }
    public String getStatut_comanda(){return Statut_comanda;}
    public void setStatut_comanda(String Statut_comanda){
        this.Statut_comanda = Statut_comanda;
    }

}
