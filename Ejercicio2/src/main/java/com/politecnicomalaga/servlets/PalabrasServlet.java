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
import java.io.PrintWriter;
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
        List<String> palabras = new ArrayList<>();
        String cadenaJsonResultado = "";
        try{
            JSONObject jsonRecibido = (JSONObject) parser.parse(json);
            palabras.add((String) jsonRecibido.get("palabra1"));
            palabras.add((String) jsonRecibido.get("palabra2"));
            palabras.add((String) jsonRecibido.get("palabra3"));
            Concatenacion concatenador = new Concatenacion();
            String concatenacion = concatenador.concatenar(palabras);
            cadenaJsonResultado = "{\"status\":\"ok\",\"palabra1\":\"" + palabras.get(0) + "\",\"palabra2\":\"" + palabras.get(1) + "\",\"palabra3\":\"" + palabras.get(2) + "\",\"concatenacion\":\"" + concatenacion + "\"}";
        } catch(Exception e){
            cadenaJsonResultado = "{\"status\":\"ko\"}";
            e.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        out.print(cadenaJsonResultado);
    }
}