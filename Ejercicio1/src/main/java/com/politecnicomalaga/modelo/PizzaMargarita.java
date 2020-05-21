package com.politecnicomalaga.modelo;

public class PizzaMargarita extends Pizza{
    @Override
    public String preparar() {
        return "Extender masa\n" +
                "Agregar salsa de tomate\n" +
                "Agregar mozzarella";
    }
}
