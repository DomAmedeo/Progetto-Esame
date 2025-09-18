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
public List<Film> visualizzaFilm(@RequestParam(required = false) String titolo) {
    if (titolo != null && !titolo.isEmpty()) {
        return service.ricercaFilm(titolo);
    }
    return service.filmpresenti();
}
//crea film
    @PostMapping
    public ResponseEntity<Film> creaFilm(@RequestBody Film body){
        Film nuovoFilm = service.aggiungiFilm(body);
        return ResponseEntity.created(URI.create("/Film"+nuovoFilm.getId()))
                             .body(nuovoFilm);
    }

// Metodo Put
    @PutMapping("/{id}")
    public ResponseEntity<Film> aggiornaFilm(@PathVariable Long id, @RequestBody Film body) {
        Film filmAggiornato= service.aggiorna(id, body);
        return ResponseEntity.ok().body(filmAggiornato);
        
    }

//ricerca con filtro
@GetMapping("/ricerca/{titolo}")
public ResponseEntity<List<Film>> ricercaFilm(@PathVariable String titolo) {
    List<Film> risultati = service.ricercaFilm(titolo);
    if (risultati.isEmpty()) {
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(risultati);
}


//delete
@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminaFilm(@PathVariable Long id) {
    service.eliminaFilm(id);
    return ResponseEntity.ok().build();
}




}
