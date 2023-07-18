package com.talan.poctalan.application.controller;


import com.talan.poctalan.application.response.ApiResponse;
import com.talan.poctalan.domaine.modeles.Produit;
import com.talan.poctalan.infrastructure.services.ProduitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/produit")
public class ProduitController {

    @Autowired
    ProduitServiceImpl produitService;

    @GetMapping("/{produit_id}")
    public ApiResponse<Produit> getProduitById(@PathVariable Long produit_id){
        return new ApiResponse<>(true, "SUCCESS", produitService.getProduit(produit_id));
    }

    @GetMapping("/all")
    public ApiResponse<List<Produit>> getAllProduits(){
        return new ApiResponse<>(true, "SUCCESS", produitService.getAllProduits());
    }

    @PostMapping("create-produit")
    public ApiResponse<Produit> createProduit(
            String nomProduit,
            Double prixProduit
    ){
        Produit p = new Produit();
        p.setNomProduit(nomProduit);
        p.setPrixProduit(prixProduit);
        p.setDateCreation(new Date());

        return new ApiResponse<>(true, "SUCCESS", produitService.saveProduit(p));
    }
}
