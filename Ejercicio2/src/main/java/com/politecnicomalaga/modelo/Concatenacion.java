package com.politecnicomalaga.modelo;

import java.util.List;

public class Concatenacion {

    public String concatenar(List<String> palabras) {
        String concatenacion = "";
        for (String palabra: palabras) {
            concatenacion += palabra;
        }
            return concatenacion;
    }
}
