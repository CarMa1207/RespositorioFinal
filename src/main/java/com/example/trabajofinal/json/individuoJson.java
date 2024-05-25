package com.example.trabajofinal.json;

import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Individuo.Individuo2;
import com.example.trabajofinal.Individuo.Individuo3;
import com.google.gson.*;
import javafx.fxml.FXML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

public class individuoJson implements JsonDeserializer<Individuo>, JsonSerializer<Individuo> {
    private static Logger log = LogManager.getLogger(individuoJson.class);
    @Override
    public Individuo deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        log.info("Deserializadno json a individuo");
        JsonObject individuoNuevo = jsonElement.getAsJsonObject();
        if (individuoNuevo.get("Tipo").getAsString().contains("Lcom/example/trabajofinal/Individuo/Individuo1;")) {
            return jsonDeserializationContext.deserialize(individuoNuevo.get("Data"), Individuo1.class);
        } else if (individuoNuevo.get("Tipo").getAsString().contains("Lcom/example/trabajofinal/Individuo/Individuo2;")) {
            return jsonDeserializationContext.deserialize(individuoNuevo.get("Data"), Individuo2.class);
        } else if (individuoNuevo.get("Tipo").getAsString().contains("Lcom/example/trabajofinal/Individuo/Individuo3;")) {
            return jsonDeserializationContext.deserialize(individuoNuevo.get("Data"), Individuo3.class);
        }else{
            log.fatal("error al encontrar el tipo de individuo");
            throw new JsonParseException("El tipo de individuo no ha encontrado la deserializacion");
        }

    }
    @Override
    public JsonElement serialize(Individuo individuo , Type type , JsonSerializationContext jsonSerializationContext){
        log.info("serializando individuo a json");
        JsonObject individuoNuevo = new JsonObject();
        individuoNuevo.addProperty("Tipo",individuo.getClass().descriptorString());
        individuoNuevo.add("Data",jsonSerializationContext.serialize(individuo));
        log.info("individuo a json ");
        return individuoNuevo;
    }

}
//*
