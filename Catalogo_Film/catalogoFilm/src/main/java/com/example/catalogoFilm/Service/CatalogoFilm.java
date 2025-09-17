package com.example.catalogoFilm.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.catalogoFilm.Model.Film;

@Service
public class CatalogoFilm {
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
           //ricerca con filtro
    public List<Film> ricercaFilm(String titolo){
    List<Film> risultati = new ArrayList<>();
        risultati = catalogoFilm.stream()
                    .filter(film -> film.getTitolo().equalsIgnoreCase(titolo))
                    .collect(Collectors.toList());//colleziona i risultati nella lista filtrata
            return risultati;

    }

    //eliminazione film
    public void eliminaFilm(Long id){
        catalogoFilm.removeIf(film -> film.getId().equals(id)); 
    }

     // Metodo per aggiornare (PUT)
    public Film aggiorna(Long id, Film filmAggiornato) {
        return catalogoFilm.stream()
            .filter(film -> film.getId().equals(id))
            .findFirst()
            .map(filmDaAggiornare -> {
                filmDaAggiornare.setTitolo(filmAggiornato.getTitolo());
                filmDaAggiornare.setRegista(filmAggiornato.getRegista());
                filmDaAggiornare.setAnno(filmAggiornato.getAnno());
                filmDaAggiornare.setGenere(filmAggiornato.getGenere());
                return filmDaAggiornare;
            })
            .orElseThrow(() -> new NoSuchElementException("Film con id " + id + " non trovato"));
    }
}