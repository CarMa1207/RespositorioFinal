package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;

public class RecursoComida extends Recurso{


    public RecursoComida( Celdas celda, String tipo)  {
        super(celda,"Comida");

    }




    @Override
    public void Propiedad(Individuo individuo)
    {

        individuo.getDatos().setVida(individuo.getDatos().getVida()+10);

    }

}
