package com.example.trabajofinal.Estructuras;

import com.example.trabajofinal.Individuo.Individuo;

public class Generacion {
    public Individuo getPadre() {
        return padre;
    }

    public void setPadre(Individuo padre) {
        this.padre = padre;
    }

    public Individuo getMadre() {
        return madre;
    }

    public void setMadre(Individuo madre) {
        this.madre = madre;
    }

    public Individuo padre;
    public Individuo madre;

}
