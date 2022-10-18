
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              int contador = 0;
        String mensaje="";
        //arreglo de cookies del cliente
        Cookie cukis[] = request.getCookies();
       
        if(cukis != null){
            //si hay cokies que el cliente no es nuevo
            for (Cookie cuki : cukis) {
                if(cuki.getName().equals("visitas")){
                    contador = Integer.parseInt(cuki.getValue());
                    
                }
            }
            mensaje = "GRACIAS POR VISITARNOS NUEVAMENTE !!!!";
        }else{
            mensaje = "¡¡¡¡BIENVENIDO A NUESTRO SITIO WEB MT";
        }
        
        contador++;
        //creamos la cooki
        Cookie  c = new Cookie("visitas", Integer.toString(contador));
        //tiempo de vida de la cooki
        c.setMaxAge(50);
        //almacenamos dentro de las cookies
        response.addCookie(c);
        //generar contenido a partir del servlet
        response.setContentType("text/html");
        
        /* response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(mensaje);*/
        
        PrintWriter out = response.getWriter();
        out.println("<DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Visita</title>");
        out.println("</head>");
        out.println("<center>");
        out.println("<body bgcolor=\"#B0C4DE\">");
        out.println("<h1><MARQUEE><FONT COLOR=\"gray\">"+ mensaje +"</FONT></MARQUEE></h1>");
        out.println("</body>");
        out.println(" </center>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }
}
