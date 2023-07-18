package com.talan.poctalan.domaine.services;


import com.talan.poctalan.domaine.modeles.Categorie;
import com.talan.poctalan.domaine.modeles.Produit;

import java.util.List;

public interface CategorieService {

    Categorie saveCategori(Categorie c);
    Categorie updateCategorie(Categorie c);
    void deleteCategorie(Categorie c);
    void deleteCategorieById(Long id);
    Categorie getCategorie(Long id);
    List<Categorie> getAllCategories();
    void addProduitCategorie(Categorie c, Produit p);
    void removeProduitCategorie(Categorie c, Produit p);

}
