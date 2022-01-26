/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.paises.controller;

import com.apirest.paises.models.Pais;
import com.apirest.paises.repository.PaisRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eltonn Julio
 */

@RestController
@RequestMapping(value="/pais")
@Api(value="API REST Paises")
@CrossOrigin(origins = "*")
public class PaisController {
    
    @Autowired
    private PaisRepository pr;
    
   
     
    @PostMapping()
    @ApiOperation(value="Cadastra um país")
    public Pais store(@RequestBody @Valid Pais pais){
        return pr.save(pais);
    }
    
    @DeleteMapping()
    @ApiOperation(value="Elimina o cadastro de um país")
    public Pais delete(@RequestBody Pais pais){
        pr.delete(pais);
        return pais;
    }
    
    @PutMapping()
    @ApiOperation(value="Actualiza os dados de um país")
    public Pais update(@RequestBody Pais pais){
        return pr.save(pais);
    }
    
      @GetMapping(produces = "application/json")
    @ApiOperation(value="Retorna uma lista de países")
    public Iterable<Pais> list(){
        Iterable<Pais> listPaises = pr.findAll();
        return  listPaises;
    } 
    
     @GetMapping("/{chave}")
     @ApiOperation(value="Retorna uma lista ordenada segundo o atributo escolhido  ")
     public Iterable<Pais> listOrdenada( @PathVariable(value="chave") String chave){
          
        Iterable<Pais> listPaises = null;
         
          chave.toLowerCase();
        
          switch(chave) {
                case "nome":
                  listPaises = pr.findAllByOrderByNomeAsc();
                  break;
                case "capital":
                  listPaises = pr.findAllByOrderByCapitalAsc();
                  break;

                   case "regiao":
                  listPaises = pr.findAllByOrderByRegiaoAsc();
                  break;

                   case "subregiao":
                  listPaises = pr.findAllByOrderBySubRegiaoAsc();
                  break;

                   case "area":
                  listPaises = pr.findAllByOrderByAreaAsc();
                  break;

                default:listPaises = pr.findAll();
    
                }
  
        return  listPaises;
    }
}
