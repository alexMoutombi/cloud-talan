package com.talan.poctalan.domaine.modeles;


import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomCat;
    private String descriptionCate;

    @OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
    private List<Produit> produits;

    private Date dateCreation;

    public Categorie(String nomCat, String descriptionCate, Date dateCreation) {
        this.nomCat = nomCat;
        this.descriptionCate = descriptionCate;
        this.dateCreation = dateCreation;
    }

    public void addProduitCategorie(Produit p){
        produits.add(p);
    }

    public void removeProduitCategorie(Produit p){
        produits.remove(p);
    }
}
