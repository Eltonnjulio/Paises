/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.paises.repository;

import com.apirest.paises.models.Pais;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Eltonn Julio 
 */
public interface PaisRepository extends JpaRepository<Pais, String> {
       
 public List<Pais> findAllByOrderByIdAsc();
 public List<Pais> findAllByOrderByNomeAsc();
 public List<Pais> findAllByOrderByCapitalAsc();
 public List<Pais> findAllByOrderByRegiaoAsc();
 public List<Pais> findAllByOrderBySubRegiaoAsc();
 public List<Pais> findAllByOrderByAreaAsc();
    
}
