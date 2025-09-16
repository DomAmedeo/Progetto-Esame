package com.example.catalogoFilm.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.catalogoFilm.Model.Film;

@Service
public class CatalogoFilm{
    // rimozione del nome del catalogo perchè non richiesto
    private List<Film> catalogoFilm = new ArrayList<>();

    //definiamo autoincrementale l'ID del Film
    private final AtomicLong sequenza = new AtomicLong(0);

    // Visualizzazione di tutti i film presenti nel catalogo.
    public List<Film> filmpresenti(){
        return new ArrayList<>(catalogoFilm);
    }

    // Inserimento di un nuovo film.
    public Film aggiungiFilm(Film nuovoFilm){
        long id = sequenza.incrementAndGet();
        nuovoFilm.setId(id);
        catalogoFilm.add(nuovoFilm);
        return nuovoFilm;
        } 
}