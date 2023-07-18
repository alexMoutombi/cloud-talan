package com.talan.poctalan.domaine.modeles;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomProduit;
    private Double prixProduit;
    private Date dateCreation;

    @ToString.Exclude
    @ManyToOne
    private Categorie categorie;

    public Produit(String nomProduit, Double prixProduit, Date dateCreation) {
        super();
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
    }
}
