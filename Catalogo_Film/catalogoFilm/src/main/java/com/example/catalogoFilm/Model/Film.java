package com.example.catalogoFilm.Model;

public class Film {
    //inserisco un ID autoincrementale e lo tolgo dal costruttore

    private Long id;
    private String titolo;
    private String regista;
    private int anno;
    private String genere;

    public Film (String titolo, String regista, int anno, String genere){
        this.titolo = titolo;
        this.regista = regista;
        this.anno= anno;
        this.genere= genere;
    }
    
    public Long getId(){
        return id;
    }    
    public void setId(Long nuovoId){
        this.id= nuovoId;
    }

    public String getTitolo(){
        return titolo;
    }
    public void setTitolo(String nuovoTitolo){
        this.titolo = nuovoTitolo;
    }

    public String getRegista(){
        return regista;
    }
    public void setRegista(String nuovoRegista){
        this.regista= nuovoRegista;
    }

    public int getAnno(){
        return anno;
    }
    public void setAnno(int nuovoAnno){
        this.anno = nuovoAnno;
    }

    public String getGenere(){
        return genere;
    }
    public void setGenere(String nuovoGenere){
        this.genere = nuovoGenere;
    }

    
}
