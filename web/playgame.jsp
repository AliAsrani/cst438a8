<%-- 
    Document   : playgame
    Created on : Jun 10, 2017, 10:56:57 AM
    Author     : AsraniA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>Hangman</h2>
        <img src="images/h${gameState}.gif"/>
        <h2 style="font-family:'Lucida Console', monospace">${displayWord}</h2>
        <s:if test="${gameMessage != null}">
            <h2 style="font-family:'Lucida Console', monospace; color:red;">${gameMessage}</h2>
        </s:if>

        <form action="" method="get">
            Guess a character <input type= "text" name="guess"><br>
            <s:choose>
                <s:when test="${gameState < 7}">
                    <input type="hidden" name ="action" value="play">
                </s:when>
                <s:otherwise>
                    <input type="hidden" name ="action" value="new">
                </s:otherwise>

            </s:choose>
            <input type="submit" value="Submit">
            <br /><br /><a href="hangman">New Game</a>
            <br /><a href="hangman?action=quit">Quit</a>

        </form>
    </body>
</html>
