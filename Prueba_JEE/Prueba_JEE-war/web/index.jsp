<%-- 
    Document   : index
    Created on : 22-ene-2012, 17:27:00
    Author     : miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css"  href="Estilos.css" media="screen" />
    </head>
    <body>
        <form id="formulario_registro" method="POST" action="Login">
            <table border="0" width="50%">
                <tr>
                    <td> <b>Nombre</b></td>
                    <td> <input type="text" name="usuario" size="20" maxlength="20"></td>
                </tr>
                <tr>
                    <td> <b> Contrase&ntilde;a:</b></td>
                    <td> <input type="password" name="password"> </td>
                </tr>
                <tr>
                    <td> <input type="submit" value="Entrar"> </td>
                    <td> <input type="button" value="Resgistrarse" onclick="javascript:window.location='Registro.jsp';"> </td>
                </tr>
            </table>
        </form>
    </body>
</html>
