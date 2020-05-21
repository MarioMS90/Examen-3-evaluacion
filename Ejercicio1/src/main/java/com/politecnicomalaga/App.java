package com.politecnicomalaga;

import com.politecnicomalaga.factory.PizzaFactory;
import com.politecnicomalaga.modelo.*;

import java.util.Scanner;

public class App {

    private static Scanner lectorTeclado = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args){

        System.out.println("Introduce el tipo de pizza que quieres:\n" +
                "1. 4 Estaciones\n" +
                "2. Margarita\n" +
                "3. Prosciutto\n" +
                "4. Vegana\n" +
                "Opción: ");

        Pizza pizza = PizzaFactory.entregarPizza(lectorTeclado.nextInt());

        System.out.println("Pasos a seguir:");
        System.out.println(pizza.preparar());
        System.out.println(pizza.hornear());
        System.out.println(pizza.cortar());
        System.out.println(pizza.empaquetar());
    }
}
