package com.example.trabajofinal;

import javafx.beans.property.*;

public class ParameterDataModelProperties {
        //Modelo de datos original
        protected ParameterDataModel original;

        private IntegerProperty porcentajereproduccion = new SimpleIntegerProperty();
        private IntegerProperty vida = new SimpleIntegerProperty();
        private IntegerProperty porcentajeclonacion = new SimpleIntegerProperty();
        private IntegerProperty porcentajetipohijo = new SimpleIntegerProperty();


        public ParameterDataModelProperties(ParameterDataModel original){
            setOriginal(original);
        }

        public void commit(){
            original.setPorcentajereproduccion(porcentajereproduccion.get());
            original.setVida(vida.get());
            original.setPorcentajeclonacion(porcentajeclonacion.get());
            original.setPorcentajetipohijo(porcentajetipohijo.get());
        }

        public void rollback(){
            porcentajereproduccion.set(original.getPorcentajereproduccion());
            vida.set(original.getVida());
            porcentajeclonacion.set(original.getPorcentajeclonacion());
            porcentajetipohijo.set(original.getPorcentajetipohijo());
        }

        public ParameterDataModel getOriginal(){
            return original;
        }

        public void setOriginal(ParameterDataModel original){
            this.original = original;
            rollback(); //Se inicializan los properties.

        }

        public Property<Number> porcentajereproduccionProperty() {
            return porcentajereproduccion;
        }

        public Property<Number> vidaProperty() {
            return vida;
        }

        public Property<Number> porcentajeclonacionProperty() {
            return porcentajeclonacion;
        }
    public Property<Number> porcentajetipohijoProperty() {
        return porcentajetipohijo;
    }

    }
