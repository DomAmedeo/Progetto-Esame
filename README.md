nella cartella Model è presente la classe Film con i metodi get e set, nella cartella service è presente la classe CatalogoFilm dove sono presenti tutte le funzionalità dell applicazione (la nostra Business Logic) e nella cartella Web è presente il nostro Controller dove sono prensenti tutti i possibili punti di accesso dell'applicazione.

Elenco delle funzionalità implementate:
1) aggiungi film: permette di inserire un nuovo film, con la possibilità di autoincrementare l'Id e successivamente inserirlo nella lista catalogofilm persente nella classe Catalogofilm che funge appunto da database.
2) filmpresenti: permette semplicemente di ritornare l'array catalogofilm per visualizzare tutti i film presenti nella lista.

per quanto riguarda parte della logica di business e del controller, ho implementato due metodi, la ricerca per filtro e il delete. 

ricercaFilm(String titolo):
Questo metodo cerca tutti i film nel catalogoFilm il cui titolo corrisponde a quello passato come parametro. Usa la tecnologia Stream di Java, che ti permette di scorrere gli elementi di una collezione in modo pi� efficiente.

eliminaFilm(Long id):
Questo metodo rimuove un film specifico dalla lista catalogoFilm basandosi sul suo ID.
catalogoFilm.removeIf(...): Questo metodo, introdotto in Java 8, scorre la lista e, per ogni elemento, esegue il codice fornito tra parentesi.

film -> film.getId().equals(id): Se l'ID del film corrente � uguale all'ID passato come parametro, il metodo removeIf lo rimuove dalla lista. � un modo molto conciso e pulito per eliminare elementi da una collezione senza dover scrivere un ciclo for esplicito.

Per quanto concerne la parte del controller e quindi della traduzione della business logic delle due funzioni da me implementate la situazione �:

il metodo del controller ricercaFilmPerTitolo riceve il parametro titolo dalla query string dell'URL (es. /api/film/ricerca?titolo=Inception). Chiama il metodo ricercaFilm del servizio e restituisce il risultato, che verr� convertito in formato JSON e inviato al client.


 il metodo eliminaFilm del controller riceve l'ID del film dall'URL (es. /api/film/123). Chiama il metodo eliminaFilm del servizio, che gestisce la logica di rimozione. Infine, restituisce un codice di stato HTTP 204 (No Content) per indicare che l'operazione � andata a buon fine.

 Riguardo al progetto mi sono occupato di fare l'Update tramite il metodo PUT.

Questo è il codice situato nel Controller

 @PutMapping("/{id}")
    public ResponseEntity<Film> aggiornaFilm(@PathVariable Long id, @RequestBody Film body) {
        Film filmAggiornato= service.aggiorna(id, body);
        return ResponseEntity.ok().body(filmAggiornato);
        
    } 

Prende l'Id dall'URL(@PathVariable Long id) e il JSON del film dal body(@RequestBody Film body) e passa tutto al service che aggiorna i dati sul DB(Film filmAggiornato = service.aggiorna(id,body);) e restituisce al client il film aggiornato con una risposta 200 Ok


Questo è il codice situato nel Service

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

Cerca nel catalogoFilm il film corrispondente ad un determinato Id, se lo trova aggiorna tutti i campi(Titolo,Regista,Anno,Genere) oppure se non lo trova, restituisce un eccezione dicendo che il film con quell'id non è stato trovato


(



IN QUESTO PROGETTO HANNO PARTECIPATO I SEGUENTI SOGGETTI:
DOMENICO PIO AMEDEO SABLONE
FEDERICO PAVONE 
DOMENICO DI GIACOMO 
MARCO BUCCINI 
ALESSIO POLLICE 
