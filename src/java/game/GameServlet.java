/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AsraniA
 */
public class GameServlet extends HttpServlet {
    
    
    Game game;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session=request.getSession();
        String url="/playgame.jsp";
        String message = null;
        
        String action=request.getParameter("action");
        if (action == null){
            action = "new";
        }
        
        if (action.equals("play")){
           String guess = request.getParameter("guess");
           
           if(checkCase(guess)){
               char g = guess.charAt(0);
               
               int result = game.playGame(g);
               
               switch (result){
                   case 0: 
                       break;
                   case 1: 
                       break;
                   case 2: 
                       break;   
                   case 3: 
                       break; 
               }
           }else {
               message = "Invalid guess try again!";
           }
           session.setAttribute("gameState", game.getState());
           session.setAttribute("displayWord", game.getDisplayWord());
           session.setAttribute("gameMessage",message);
        }
        else if (action.equals("new")){
            if (game == null){
                game = new Game();
            }
            game.startNewGame();
            message = "Lets get started";
            session.setAttribute("gameState", game.getState());
           session.setAttribute("displayWord", game.getDisplayWord());
           session.setAttribute("gameMessage",message);
             
            }
        else if (action.equals("quit")){
            url = "/index.html";
        }
                    
        //session.setAttribute("gameState", 1);
        getServletContext().getRequestDispatcher(url).forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public boolean checkCase(String uri) {
        String input = uri;

        if (input.length() > 1 || input.isEmpty()) {
            return false;
        } else {
            char input2 = input.charAt(0);
            if (Character.isLetter(input2)) {
                return true;
            } else {
                return false;
            }
        }

    }

}
