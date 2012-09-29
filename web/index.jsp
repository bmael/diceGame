<%-- 
    Document   : index
    Created on : 28 sept. 2012, 14:24:36
    Author     : mael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dice Game</title>
    </head>
    <body>
        <h1>Dice Game</h1>
        
        <form action="Start" method="POST" style="float:left">
            <input type="submit" name="play" value="Play"/>
        </form>
        
        <form action="HighscoreView" method="POST" style="float:left">
            <input type="submit" name="highscore" value="HighscoreView "/>
        </form>
        
        <form action="view/demarrage" method="POST" style="float:left">
            <input type="submit" name="exit" value="Exit"/>
        </form>
        
    </body>
</html>
