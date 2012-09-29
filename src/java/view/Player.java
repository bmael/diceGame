/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Game;
import model.Highscore;

/**
 *
 * @author mael
 */
@WebServlet(name = "Player", urlPatterns = {"/Player"})
public class Player extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Game g = null;
        Highscore score = null;
        session.setAttribute("game", g = new Game(request.getParameter("name")));
        session.setAttribute("score",score = new Highscore());
        g.setHscore(score);
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<HTML><head><title>Informations</title></head><body>");
        out.println("Player : ");
        out.println(g.getName());
        out.println("&nbsp&nbsp&nbsp&nbsp");
        out.println("Turn : ");
        out.println(g.getTurn());
        out.println("&nbsp&nbsp&nbsp&nbsp");
        out.println("Score : ");
        out.println(g.getScore());
        out.println("<form action=\"Play\" method=\"GET\">");
        out.println("<input type=\"submit\" name=\"roll\" value=\"Start\"/>");
        out.println("</form>");
        out.println("</body></html>");
        
    }

    
}
