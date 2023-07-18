package com.talan.poctalan.infrastructure.services;


import com.talan.poctalan.domaine.modeles.Categorie;
import com.talan.poctalan.domaine.modeles.Produit;
import com.talan.poctalan.domaine.services.CategorieService;
import com.talan.poctalan.infrastructure.repository.CategorieRepository;
import com.talan.poctalan.infrastructure.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public Categorie saveCategori(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public Categorie updateCategorie(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public void deleteCategorie(Categorie c) {
        categorieRepository.delete(c);
    }

    @Override
    public void deleteCategorieById(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categorie getCategorie(Long id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public void addProduitCategorie(Categorie c, Produit p) {
        c.addProduitCategorie(p);
        categorieRepository.save(c);
    }

    @Override
    public void removeProduitCategorie(Categorie c, Produit p) {
        c.removeProduitCategorie(p);
        categorieRepository.save(c);
    }

    public void createCategorieProduit(Categorie c, List<String> params){

        List<Long> id_produits = new ArrayList<>();

        for(int i = 0; i<params.size(); i++){
            id_produits.add(Long.parseLong(params.get(i)));
        }

        List<Produit> produitList = produitRepository.findAll().stream()
                .filter(p -> id_produits.contains(p.getId()))
                .collect(Collectors.toList());

        c.setProduits(produitList);

        categorieRepository.save(c);

    }
}
