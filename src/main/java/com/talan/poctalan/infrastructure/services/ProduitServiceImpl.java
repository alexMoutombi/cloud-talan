package com.talan.poctalan.infrastructure.services;


import com.talan.poctalan.domaine.modeles.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.talan.poctalan.infrastructure.repository.ProduitRepository;
import com.talan.poctalan.domaine.services.ProduitService;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public Produit saveProduit(Produit p) {
        produitRepository.save(p);
        return p;
    }

    @Override
    public Produit updateProduit(Produit p) {
        produitRepository.save(p);
        return p;
    }

    @Override
    public void deleteProduit(Produit p) {
        produitRepository.delete(p);
    }

    @Override
    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit getProduit(Long id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public List<Produit> getAllProduits() {
        List<Produit> produitList = produitRepository.findAll();
        return produitList;
    }
}
