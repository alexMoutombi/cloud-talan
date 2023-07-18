package com.talan.poctalan.infrastructure.repository;


import com.talan.poctalan.domaine.modeles.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
