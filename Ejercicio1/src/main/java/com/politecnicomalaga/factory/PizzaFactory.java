package com.politecnicomalaga.factory;

import com.politecnicomalaga.modelo.*;

public class PizzaFactory {

    public static Pizza entregarPizza(int tipoPizza){

        switch (tipoPizza) {
            case Pizza.ESTACIONES:
                return new Pizza4Estaciones();
            case Pizza.MARGARITA:
                return new PizzaMargarita();
            case Pizza.PROSCIUTTO:
                return new PizzaProsciutto();
            case Pizza.VEGANA:
                return new PizzaVegana();
            default:
                return new PizzaMargarita();
        }
    }
}
