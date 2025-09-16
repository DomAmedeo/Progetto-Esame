package com.example.catalogoFilm.Web;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.catalogoFilm.Model.Film;
import com.example.catalogoFilm.Service.CatalogoFilm;

@RestController
@RequestMapping("/Film")

public class CatalogoFilmController {
    private final CatalogoFilm service;

    public CatalogoFilmController(CatalogoFilm service){
        this.service= service;
    }   

    //Get lista di tutti  i film
    @GetMapping
    public  List<Film> visualizzaFilm(){
        return service.filmpresenti();        
    }

    @PostMapping
    public ResponseEntity<Film> creaFilm(@RequestBody Film body){
        Film nuovoFilm = service.aggiungiFilm(body);
        return ResponseEntity.created(URI.create("/Film"+nuovoFilm.getId()))
                             .body(nuovoFilm);
    }



}
