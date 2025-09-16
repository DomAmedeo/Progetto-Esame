package com.example.catalogoFilm;

public class Film {
     private int id;
    private String titolo;
    private String regista;
    private int anno;
    private String genere;

    public Film (int id, String titolo, String regista, int anno, String genere){
        this.id = id;
        this.titolo = titolo;
        this.regista = regista;
        this.anno= anno;
        this.genere= genere;
    }
    
    public int getId(){
        return id;
    }    
    public void setId(int nuovoId){
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
