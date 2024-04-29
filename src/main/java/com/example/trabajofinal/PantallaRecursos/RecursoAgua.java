package com.example.trabajofinal.PantallaRecursos;

public class RecursoAgua extends Recurso{
    private int probabilidadAgua;

    public RecursoAgua(int tiempoAparicion, int probabilidadAparicion, int probabilidadRecurso, int probabilidadAgua) {
        super(tiempoAparicion, probabilidadAparicion, probabilidadRecurso);
        this.probabilidadAgua = probabilidadAgua;
    }

    public int getProbabilidadAgua() {
        return probabilidadAgua;
    }

    public void setProbabilidadAgua(int probabilidadAgua) {
        this.probabilidadAgua = probabilidadAgua;
    }
}
