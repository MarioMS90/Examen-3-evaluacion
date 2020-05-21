package com.politecnicomalaga.servlets;
import com.politecnicomalaga.modelo.Concatenacion;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@WebServlet(
        name="PalabrasServlet",
        urlPatterns = {"/PalabrasServlet"}
)

public class PalabrasServlet extends HttpServlet {
    private RequestDispatcher dispatcher = null;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = req.getReader().lines().collect(Collectors.joining());
        JSONParser parser = new JSONParser();
        try{
            JSONObject jsonRecibido = (JSONObject) parser.parse(json);
            String nombre = (String) jsonRecibido.get("nombre");
            int edad = Integer.parseInt((String) jsonRecibido.get("edad"));
            listaPersonas.add(new Persona(nombre,edad));
        } catch(Exception e){
            listaPersonas.add(new Persona("Nombre desconocido",0));
        }
        Concatenacion concatenador = new Concatenacion();
        List<String> palabras = new ArrayList<>();
        palabras.add(req.getParameter("palabra1"));
        palabras.add(req.getParameter("palabra2"));
        palabras.add(req.getParameter("palabra3"));
        String concatenacion = concatenador.concatenar(palabras);
        for (String palabra: palabras) {
            req.setAttribute("palabra1", palabra);
        }
        req.setAttribute("concatenacion", concatenacion);
        RequestDispatcher view = req.getRequestDispatcher("resultCerveza.jsp");
        view.forward(req, resp);
    }
}