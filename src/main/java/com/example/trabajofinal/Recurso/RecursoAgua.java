package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;

public class RecursoAgua extends Recurso{



    public RecursoAgua( Celdas celda, String tipo)  {
        super(celda,"Agua");

    }



    @Override
    public void Propiedad(Individuo individuo){

        individuo.getDatos().setVida(individuo.getDatos().getVida()+2);



    }

}
