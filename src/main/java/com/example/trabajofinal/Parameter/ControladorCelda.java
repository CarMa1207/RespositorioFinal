
package com.example.trabajofinal.Parameter;


import com.example.trabajofinal.Estructuras.*;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Individuo.Individuo2;
import com.example.trabajofinal.Individuo.Individuo3;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import com.example.trabajofinal.Parameter.TableroDataModel;
import com.example.trabajofinal.Recurso.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControladorCelda implements Initializable {


    private Celdas celdaControlador;


        private   RecursoAgua agua ;
        private  RecursoBiblioteca biblioteca;
        private  RecursoComida comida ;
        private  RecursoMontaña montaña;
        private  RecursoPozo pozo;
        private   RecursoTesoro tesoro;
    private Stage sceneCelda;
        @FXML
        private Button BotonIndividuo1;
        @FXML
        private Button BotonIndividuo2;
        @FXML
        private Button BotonIndividuo3;
        @FXML
        private Button BotonAgua;
        @FXML
        private Button BotonBiblioteca;
        @FXML
        private Button BotonComida;
        @FXML
        private Button BotonMontaña;
        @FXML
        private Button BotonPozo;
        @FXML
        private Button BotonTesoro;
        @FXML
        private Label labelCantidadAgua;
        @FXML
        private Label labelCantidadComida;
        @FXML
        private Label labelCantidadBiblioteca;
        @FXML
        private Label labelCantidadTesoro;
        @FXML
        private Label labelCantidadPozo;
        @FXML
        private Label labelCantidadMontaña;
        @FXML
        private Label labelCantidadIndividuos1;
        @FXML
        private Label labelCantidadIndividuos2;
        @FXML
        private Label labelCantidadIndividuos3;
        @FXML
        private Label labelInformacion;
        @FXML
        private Button delIndividuo1;
        @FXML
        private Button delIndividuo2;
        @FXML
        private Button delIndividuo3;
       @FXML
        private Button delRecursoAgua;
    @FXML
    private Button delRecursoComida;
    @FXML
    private Button delRecursoPozo;
    @FXML
    private Button delRecursoBiblioteca;
    @FXML
    private Button delRecursoTesoro;
    @FXML
    private Button delRecursoMontaña;



        @FXML
        private Label titulo;
        private static  TableroDataModel tablero;
        private  ParameterDataModel individuosc;
        private  ParameterDataModelRecursos recursosd;
        private   static Celdas celda;
        public ListaEnlazed<Celdas> celdasListaEnlazed;

    public void setCeldasListaEnlazed(ListaEnlazed<Celdas> celdasListaEnlazed) {
        this.celdasListaEnlazed = celdasListaEnlazed;
    }

    public void setCelda(TableroDataModel tablero, Celdas celda, ParameterDataModel individuos , ParameterDataModelRecursos recursos, ListaEnlazed<Celdas>celdasListaEnlazed) {
        this.tablero = tablero;
        this.individuosc=individuos;
        this.recursosd=recursos;
        this.celda=celda;
        this.celdasListaEnlazed=celdasListaEnlazed;
    }


    private Stage sceneCeldita;


    public void delIndividuo(Class clase){
        int pos =0;
        for (int i = 0 ; i<celdasListaEnlazed.getNumeroElementos();i++) {
            if (celdasListaEnlazed.getElemento(i).getData().getX()== celda.getX() && celdasListaEnlazed.getElemento(i).getData().getY()== celda.getY()){
                pos=i;
            }
        }
        Celdas celda = celdasListaEnlazed.getElemento(pos).getData();
        boolean borrado = false;
        if (!celda.getIndividuoListaEnlazed().isVacia()){
            if (Objects.equals(clase.descriptorString(), "Lcom/example/trabajofinal/Individuo/Individuo1;")){
                int i = 0;
                while(!borrado){

                    if(i == celda.getIndividuoListaEnlazed().getNumeroElementos()-1){borrado = true;}
                    if (Objects.equals(celda.getIndividuoListaEnlazed().getElemento(i).getData().getClass().descriptorString(), "Lcom/example/trabajofinal/Individuo/Individuo1;")){
                        labelInformacion.setText("Individuo1 borrado");
                        celda.getIndividuoListaEnlazed().del(i);
                        borrado = true;

                    }
                    i++;
                }


            } else if (Objects.equals(clase.descriptorString(), "Lcom/example/trabajofinal/Individuo/Individuo2;")) {
                int i = 0;
                while(!borrado) {
                    if(i == celda.getIndividuoListaEnlazed().getNumeroElementos()-1){borrado = true;}

                    if (Objects.equals(celda.getIndividuoListaEnlazed().getElemento(i).getData().getClass().descriptorString(), "Lcom/example/trabajofinal/Individuo/Individuo2;")) {
                        celda.getIndividuoListaEnlazed().del(i);
                        labelInformacion.setText("Individuo2 borrado");
                        borrado = true;
                    }
                    i++;

                }

            } else if (Objects.equals(clase.descriptorString(),"Lcom/example/trabajofinal/Individuo/Individuo3;")) {
                int i = 0;
                while(!borrado){
                    if(i == celda.getIndividuoListaEnlazed().getNumeroElementos()-1){borrado = true;}

                    if (Objects.equals(celda.getIndividuoListaEnlazed().getElemento(i).getData().getClass().descriptorString(), "Lcom/example/trabajofinal/Individuo/Individuo3;")){
                        celda.getIndividuoListaEnlazed().del(i);
                        borrado = true;
                    }
                    i++;
                }
                labelInformacion.setText("Individuo3 borrado");
            }
        }
        else {
            labelInformacion.setText("No hay Individuos ");
        }
        Informacion();



    }
    public void delRecursos(Class clase){
        int pos =0;
        for (int i = 0 ; i<celdasListaEnlazed.getNumeroElementos();i++) {
            if (celdasListaEnlazed.getElemento(i).getData().getX()== celda.getX() && celdasListaEnlazed.getElemento(i).getData().getY()== celda.getY()){
                pos=i;
            }
        }
        Celdas celda = celdasListaEnlazed.getElemento(pos).getData();
        boolean borrado = false;
        if (!celda.getRecursoListaEnlazed().isVacia()){
            if (Objects.equals(clase.descriptorString(), "Lcom/example/trabajofinal/Recurso/RecursoAgua;")){
                int i = 0;
                while(!borrado){



                    if (Objects.equals(celda.getRecursoListaEnlazed().getElemento(i).getData().getClass().descriptorString(), "Lcom/example/trabajofinal/Recurso/RecursoAgua;")){
                        System.out.println(i);
                        celda.getRecursoListaEnlazed().del(i);
                        borrado = true;
                        labelInformacion.setText("Agua borrado");
                    }if(i == celda.getRecursoListaEnlazed().getNumeroElementos()-1){borrado = true;}
                    i++;
                }

            } else if (Objects.equals(clase.descriptorString(), "Lcom/example/trabajofinal/Recurso/RecursoBiblioteca;")) {
                int i = 0;
                while(!borrado){
                    if(i == celda.getRecursoListaEnlazed().getNumeroElementos()-1){borrado = true;}

                    if (Objects.equals(celda.getRecursoListaEnlazed().getElemento(i).getData().getClass().descriptorString(), "Lcom/example/trabajofinal/Recurso/RecursoBiblioteca;")){
                        celda.getRecursoListaEnlazed().del(i);
                        borrado = true;
                        labelInformacion.setText("Biblioteca borrado");
                    }
                    i++;
                }

            } else if (Objects.equals(clase.descriptorString(), "Lcom/example/trabajofinal/Recurso/RecursoPozo;")) {
                int i = 0;
                while(!borrado){
                    if(i == celda.getRecursoListaEnlazed().getNumeroElementos()-1){borrado = true;}

                    if (Objects.equals(celda.getRecursoListaEnlazed().getElemento(i).getData().getClass().descriptorString(), "Lcom/example/trabajofinal/Recurso/RecursoPozo;")){
                        celda.getRecursoListaEnlazed().del(i);
                        borrado = true;
                        labelInformacion.setText("Pozo borrado");
                    }
                    i++;
                }

            }else if (Objects.equals(clase.descriptorString(), "Lcom/example/trabajofinal/Recurso/RecursoComida;")) {
                int i = 0;
                while(!borrado){
                    if(i == celda.getRecursoListaEnlazed().getNumeroElementos()-1){borrado = true;}

                    if (Objects.equals(celda.getRecursoListaEnlazed().getElemento(i).getData().getClass().descriptorString(), "Lcom/example/trabajofinal/Recurso/RecursoComida;")){
                        celda.getRecursoListaEnlazed().del(i);
                        borrado = true;
                        labelInformacion.setText("Comida borrado");
                    }
                    i++;
                }

            }else if (Objects.equals(clase.descriptorString(), "Lcom/example/trabajofinal/Recurso/RecursoTesoro;")) {
                int i = 0;
                while(!borrado){
                    if(i == celda.getRecursoListaEnlazed().getNumeroElementos()-1){borrado = true;}

                    if (Objects.equals(celda.getRecursoListaEnlazed().getElemento(i).getData().getClass().descriptorString(), "Lcom/example/trabajofinal/Recurso/RecursoTesoro;")){
                        celda.getRecursoListaEnlazed().del(i);
                        borrado = true;
                        labelInformacion.setText("Tesoro borrado");
                    }
                    i++;
                }

            }else if (Objects.equals(clase.descriptorString(), "Lcom/example/trabajofinal/Recurso/RecursoMontaña;")) {
                int i = 0;
                while(!borrado){
                    if(i == celda.getRecursoListaEnlazed().getNumeroElementos()-1){borrado = true;}


                    if (Objects.equals(celda.getRecursoListaEnlazed().getElemento(i).getData().getClass().descriptorString(), "Lcom/example/trabajofinal/Recurso/RecursoMontaña;")){
                        celda.getRecursoListaEnlazed().del(i);
                        borrado = true;
                        labelInformacion.setText("Montaña borrado");
                    }
                    i++;
                }

            }

        }else{
            labelInformacion.setText("No hay recursos que borrar");
        }
        Informacion();
    }
    @FXML
        protected void onBotonCerrarClick() {
            sceneCelda.close();
        }

        @FXML
        protected void onBotonIndividuo1() {
            ParameterDataModel datos= new ParameterDataModel(individuosc.getVida(),individuosc.getPorcentajereproduccion(),individuosc.getPorcentajeclonacion(),individuosc.getPorcentajetipohijo(), individuosc.getID());
            if(celda.getIndividuoListaEnlazed().getNumeroElementos()<3){
                Generacion arbol= new Generacion();

                Cola<String> mov= new Cola<>();
                Historial historial= new Historial(0,mov);
                ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();


                Individuo individuo1= new Individuo1(celda,1,arbol,historial,ruta,datos) ;
                arbol.setMadre(null);
                arbol.setPadre(null);
                celda.getIndividuoListaEnlazed().add(individuo1);
                Informacion();
                log.info(" se añade");
            }
            else{
                log.info("Se ha excedido el limite de individuos por casilla");
            }



        }

        @FXML
        protected void onBotonIndividuo2() {
            ParameterDataModel datos= new ParameterDataModel(individuosc.getVida(),individuosc.getPorcentajereproduccion(),individuosc.getPorcentajeclonacion(),individuosc.getPorcentajetipohijo(), individuosc.getID());
            if(celda.getIndividuoListaEnlazed().getNumeroElementos()<3){
                Generacion arbol= new Generacion();
                Cola<String>mov= new Cola<>();
                Historial historial= new Historial(0,mov);
                ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();


                Individuo individuo2= new Individuo2(celda,2,arbol,historial,ruta,datos) ;
                arbol.setMadre(null);
                arbol.setPadre(null);
                celda.getIndividuoListaEnlazed().add(individuo2);
                Informacion();
                log.info(" se añade");
            }
            else{
                log.info("Se ha excedido el limite de individuos por casilla");
            }


        }



        @FXML
        protected void onBotonIndividuo3() {
            ParameterDataModel datos= new ParameterDataModel(individuosc.getVida(),individuosc.getPorcentajereproduccion(),individuosc.getPorcentajeclonacion(),individuosc.getPorcentajetipohijo(), individuosc.getID());
            if(celda.getIndividuoListaEnlazed().getNumeroElementos()<3){
                Generacion arbol= new Generacion();
                Cola<String>mov= new Cola<>();
                Historial historial= new Historial(0,mov);
                ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();


                Individuo individuo3= new Individuo3(celda,3,arbol,historial,ruta,datos) ;
                arbol.setMadre(null);
                arbol.setPadre(null);
                celda.getIndividuoListaEnlazed().add(individuo3);
                Informacion();
                log.info(" se añade");
            }
            else{
                log.info("Se ha excedido el limite de individuos por casilla");
            }


        }
        @FXML
        protected void onBotonAgua() {
            ParameterDataModelRecursos datos= new ParameterDataModelRecursos(recursosd.getTiempoAparicion(),recursosd.getProbabilidadAparicion(),recursosd.getProbabilidadAgua(),recursosd.getProbabilidadComida(),recursosd.getProbabilidadBiblioteca(),recursosd.getProbabilidadMontaña(),recursosd.getProbabilidadPozo(),recursosd.getProbabilidadTesoro());
            if(celda.getRecursoListaEnlazed().getNumeroElementos()<3){


                Recurso recursoAgua= new RecursoAgua(celda,"Agua",datos);
                celda.getRecursoListaEnlazed().add(recursoAgua);
                Informacion();
                log.info(" se añade");
            }
            else{
                log.info("Se ha excedido el limite de recursos por casilla");
            }



        }
        @FXML
        protected void onBotonBiblioteca () {
            ParameterDataModelRecursos datos= new ParameterDataModelRecursos(recursosd.getTiempoAparicion(),recursosd.getProbabilidadAparicion(),recursosd.getProbabilidadAgua(),recursosd.getProbabilidadComida(),recursosd.getProbabilidadBiblioteca(),recursosd.getProbabilidadMontaña(),recursosd.getProbabilidadPozo(),recursosd.getProbabilidadTesoro());

            if(celda.getRecursoListaEnlazed().getNumeroElementos()<3){


                Recurso recursoBiblioteca= new RecursoBiblioteca(celda,"Biblioteca",datos);
                celda.getRecursoListaEnlazed().add(recursoBiblioteca);
                Informacion();
                log.info(" se añade");
            }
            else{
                log.info("Se ha excedido el limite de recursos por casilla");
            }


        }
        @FXML
        protected void onBotonComida() {
            ParameterDataModelRecursos datos= new ParameterDataModelRecursos(recursosd.getTiempoAparicion(),recursosd.getProbabilidadAparicion(),recursosd.getProbabilidadAgua(),recursosd.getProbabilidadComida(),recursosd.getProbabilidadBiblioteca(),recursosd.getProbabilidadMontaña(),recursosd.getProbabilidadPozo(),recursosd.getProbabilidadTesoro());

            if(celda.getRecursoListaEnlazed().getNumeroElementos()<3){


                Recurso recursoComida= new RecursoComida(celda,"Comida",datos);
                celda.getRecursoListaEnlazed().add(recursoComida);
                Informacion();
                log.info(" se añade");
            }
            else{
                log.info("Se ha excedido el limite de recursos por casilla");
            }


        }

        @FXML
        protected void onBotonMontaña () {
            ParameterDataModelRecursos datos= new ParameterDataModelRecursos(recursosd.getTiempoAparicion(),recursosd.getProbabilidadAparicion(),recursosd.getProbabilidadAgua(),recursosd.getProbabilidadComida(),recursosd.getProbabilidadBiblioteca(),recursosd.getProbabilidadMontaña(),recursosd.getProbabilidadPozo(),recursosd.getProbabilidadTesoro());

            if(celda.getRecursoListaEnlazed().getNumeroElementos()<3){


                Recurso recursoMontaña= new RecursoMontaña(celda,"Montaña",datos);
                celda.getRecursoListaEnlazed().add(recursoMontaña);
                Informacion();
                log.info(" se añade");
            }
            else{
                log.info("Se ha excedido el limite de recursos por casilla");
            }

        }
        @FXML
        protected void onBotonTesoro() {
            ParameterDataModelRecursos datos = new ParameterDataModelRecursos(recursosd.getTiempoAparicion(), recursosd.getProbabilidadAparicion(), recursosd.getProbabilidadAgua(), recursosd.getProbabilidadComida(), recursosd.getProbabilidadBiblioteca(), recursosd.getProbabilidadMontaña(), recursosd.getProbabilidadPozo(), recursosd.getProbabilidadTesoro());

            if (celda.getRecursoListaEnlazed().getNumeroElementos() < 3) {


                Recurso recursoTesoro= new RecursoTesoro(celda,"Tesoro",datos);
                celda.getRecursoListaEnlazed().add(recursoTesoro);
                Informacion();
                log.info(" se añade");
            }
            else{
                log.info("Se ha excedido el limite de recursos por casilla");
            }


        }
    @FXML
    protected void eliminarIndividuo1(){
        delIndividuo(Individuo1.class);
    }
    @FXML
    protected void eliminarIndividuo2(){
        delIndividuo(Individuo2.class);
    }
    @FXML
    protected void eliminarIndividuo3(){
        delIndividuo(Individuo3.class);
    }
    @FXML
    protected void eliminarRecursoAgua() {
        delRecursos(RecursoAgua.class);
    }
    @FXML
    protected void eliminarRecursoTesoro() {
        delRecursos(RecursoTesoro.class);
    }
    @FXML
    protected void eliminarRecursoMontaña() {
        delRecursos(RecursoMontaña.class);
    }
    @FXML
    protected void eliminarRecursoBiblioteca() {
        delRecursos(RecursoBiblioteca.class);
    }
    @FXML
    protected void eliminarRecursoComida() {
        delRecursos(RecursoComida.class);
    }
    @FXML
    protected void eliminarRecursoPozo() {
        delRecursos(RecursoPozo.class);
    }
    public void setSceneCeldita(Stage sceneCeldita) {
        this.sceneCeldita = sceneCeldita;
    }
    public  Celdas getCeldaControlador() {
        return celdaControlador;
    }

    public  void setCeldaControlador(Celdas celdaControlador) {
        this.celdaControlador = celdaControlador;
    }

    private static Logger log = LogManager.getLogger(ControladorCelda.class);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Inicialización en ejecución del controlador\n");

    }
    @FXML
    protected void OnBotonPozo() {
        ParameterDataModelRecursos datos= new ParameterDataModelRecursos(recursosd.getTiempoAparicion(),recursosd.getProbabilidadAparicion(),recursosd.getProbabilidadAgua(),recursosd.getProbabilidadComida(),recursosd.getProbabilidadBiblioteca(),recursosd.getProbabilidadMontaña(),recursosd.getProbabilidadPozo(),recursosd.getProbabilidadTesoro());

        if(celda.getRecursoListaEnlazed().getNumeroElementos()<3){


            Recurso recursoPozo= new RecursoPozo(celda,"Agua",datos);
            celda.getRecursoListaEnlazed().add(recursoPozo);
            log.info(" se añade");
        }
        else{
            log.info("Se ha excedido el limite de recursos por casilla");
        }
    }
    protected void Informacion(){
         int cantidadAgua=0;
         int cantidadComida=0;
         int cantidadMonataña=0;
         int cantidadBiblioteca=0;
         int cantidadMontaña=0;
         int cantidadTesoro=0;
         int cantidadPozo=0;
         int cantidadindividuos1=0;
         int cantidadindividuos2=0;
         int cantidadindividuos3=0;
        for (int i=0 ; i<celda.getRecursoListaEnlazed().getNumeroElementos();i++){
             if(celda.getRecursoListaEnlazed().getElemento(i).getData().getClass()==RecursoAgua.class){
                cantidadAgua++;
                 labelInformacion.setText("Agua Añadido");
             } else if (celda.getRecursoListaEnlazed().getElemento(i).getData().getClass()==RecursoComida.class) {
                 cantidadComida++;
                 labelInformacion.setText("Comida Añadido");
             }else if (celda.getRecursoListaEnlazed().getElemento(i).getData().getClass()==RecursoBiblioteca.class){
                 cantidadBiblioteca++;
                 labelInformacion.setText("Biblioteca añadido");
             }else if (celda.getRecursoListaEnlazed().getElemento(i).getData().getClass()==RecursoMontaña.class){
                 cantidadMontaña++;
                 labelInformacion.setText("Montaña añadido");
             }else if (celda.getRecursoListaEnlazed().getElemento(i).getData().getClass()==RecursoTesoro.class){
                 cantidadTesoro++;
                 labelInformacion.setText("Tesoro añadido");
             }else if (celda.getRecursoListaEnlazed().getElemento(i).getData().getClass()==RecursoPozo.class){
                 cantidadPozo++;
                 labelInformacion.setText("Pozo añadido");
             }
         }
         for(int j =0; j<celda.getIndividuoListaEnlazed().getNumeroElementos();j++) {
             if (Objects.equals(celda.getIndividuoListaEnlazed().getElemento(j).getData().getClass().descriptorString(), "Lcom/example/trabajofinal/Individuo/Individuo1;")) {
                 cantidadindividuos1++;
                 labelInformacion.setText("Individuo1 añadido");
             } else if (Objects.equals(celda.getIndividuoListaEnlazed().getElemento(j).getData().getClass().descriptorString(), "Lcom/example/trabajofinal/Individuo/Individuo2;")) {
                 cantidadindividuos2++;
                 labelInformacion.setText("Individuo2 añadido");

             } else if (Objects.equals(celda.getIndividuoListaEnlazed().getElemento(j).getData().getClass().descriptorString(), "Lcom/example/trabajofinal/Individuo/Individuo3;")) {
                 cantidadindividuos3++;
                 labelInformacion.setText("Individuo3 añadido");

             }
         }

         labelCantidadAgua.setText(String.valueOf(cantidadAgua));
        labelCantidadComida.setText(String.valueOf(cantidadComida));
        labelCantidadBiblioteca.setText(String.valueOf(cantidadBiblioteca));
        labelCantidadTesoro.setText(String.valueOf(cantidadTesoro));
        labelCantidadPozo.setText(String.valueOf(cantidadPozo));
        labelCantidadMontaña.setText(String.valueOf(cantidadMontaña));
        labelCantidadIndividuos1.setText(String.valueOf(cantidadindividuos1));
        labelCantidadIndividuos2.setText(String.valueOf(cantidadindividuos2));
        labelCantidadIndividuos3.setText(String.valueOf(cantidadindividuos3));
    }
}



