package com.example.catalogoFilm;
import java.util.ArrayList;
import java.util.List;

public class CatalogoFilm{
    private List<Film> CatalogoFilm = new ArrayList<>();
    private String nomeCatalogo;

    public CatalogoFilm(String nomeCatalogo){
        this.nomeCatalogo=nomeCatalogo;
    }

    public String getCatalogo(){
        return nomeCatalogo;
    }

    public void setNuovoCatalogo(String nuovoCatalogo){
        this.nomeCatalogo = nuovoCatalogo;
    }

}