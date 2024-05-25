package com.example.trabajofinal.json;




import com.example.trabajofinal.Recurso.*;
import com.google.gson.*;

import java.lang.reflect.Type;

    public class gsonAdapterRecurso<Recursos> implements JsonDeserializer<Recursos>, JsonSerializer<Recursos> {
        @Override
        public Recursos deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {

            JsonObject recursoNuevo = jsonElement.getAsJsonObject();
            if (recursoNuevo.get("Tipo").getAsString().contains("Lcom/example/trabajofinal/Recurso/RecursoAgua;")) {
                return jsonDeserializationContext.deserialize(recursoNuevo.get("Data"), RecursoAgua.class);
            } else if (recursoNuevo.get("Tipo").getAsString().contains("Lcom/example/trabajofinal/Recurso/RecursoMontaña;")) {
                return jsonDeserializationContext.deserialize(recursoNuevo.get("Data"), RecursoMontaña.class);
            } else if (recursoNuevo.get("Tipo").getAsString().contains("Lcom/example/trabajofinal/Recurso/RecursoTesoro;")) {
                return jsonDeserializationContext.deserialize(recursoNuevo.get("Data"), RecursoTesoro.class);
            }
            else if (recursoNuevo.get("Tipo").getAsString().contains("Lcom/example/trabajofinal/Recurso/RecursoBiblioteca;")) {
                return jsonDeserializationContext.deserialize(recursoNuevo.get("Data"), RecursoBiblioteca.class);
            }
            else if (recursoNuevo.get("Tipo").getAsString().contains("Lcom/example/trabajofinal/Recurso/RecursoPozo;")) {
                return jsonDeserializationContext.deserialize(recursoNuevo.get("Data"), RecursoPozo.class);
            }
            else if (recursoNuevo.get("Tipo").getAsString().contains("Lcom/example/trabajofinal/Recurso/RecursoComida;")) {
                return jsonDeserializationContext.deserialize(recursoNuevo.get("Data"),RecursoComida.class);
            }else{
                // log.fatal("error al encontrar el tipo de individuo");
                throw new JsonParseException("El tipo de individuo no ha encontrado la deserializacion");
            }

        }
        @Override
        public JsonElement serialize(Recursos recurso , Type type , JsonSerializationContext jsonSerializationContext){
            // log.info("serializando individuo a json");
            JsonObject recursoNuevo = new JsonObject();
            recursoNuevo.addProperty("Tipo",recurso.getClass().descriptorString());
            recursoNuevo.add("Data",jsonSerializationContext.serialize(recurso));
            //log.info("individuo a json ");
            return recursoNuevo;}

    }

