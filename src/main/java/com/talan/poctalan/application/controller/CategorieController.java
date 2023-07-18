package com.talan.poctalan.application.controller;


import com.talan.poctalan.application.response.ApiResponse;
import com.talan.poctalan.domaine.modeles.Categorie;
import com.talan.poctalan.infrastructure.services.CategorieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/categorie")
public class CategorieController {

    @Autowired
    CategorieServiceImpl categorieService;

    @GetMapping("/{categorie_id}")
    public ApiResponse<Categorie> getCategorieById(Long categorie_id){
        return  new ApiResponse<>(true, "SUCCESS", categorieService.getCategorie(categorie_id));
    }

    @GetMapping("/all")
    public ApiResponse<List<Categorie>> getAllCategories(){
        return  new ApiResponse<>(true, "SUCCESS", categorieService.getAllCategories());
    }

    @PostMapping("/create-categorie")
    public ApiResponse<Categorie> createCategorie(String nom_categorie,
                                                  String desc_categorie,
                                                  @RequestParam(name = "produit_id") String produits){

        List<String> params = Arrays.asList(produits.split(","));

        Categorie c = new Categorie();
        c.setNomCat(nom_categorie);
        c.setDescriptionCate(desc_categorie);

        categorieService.createCategorieProduit(c, params);

        return new ApiResponse<>(true, "SUCCESS", c);


    }

}
