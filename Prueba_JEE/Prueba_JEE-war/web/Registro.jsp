<%-- 
    Document   : Registro
    Created on : 22-ene-2012, 18:16:48
    Author     : miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Registrar" method="POST" enctype="multipart/form-data">
            <table border="0" width="50%">
                <tr>
                    <td> <b>Nombre</b></td>
                    <td> <input type="text" name="usuario" size="20" maxlength="20"></td>
                </tr>
                <tr>
                    <td> <b> telefono:</b></td>
                    <td> <input type="text" name="telefono" size="20" maxlength="20"> </td>
                </tr>
                <tr>
                    <td> <b> Imagen:</b></td>
                    <td> <input type="file" name="imagen" accept="image/jpeg"> </td>
                </tr>
                <tr>
                    <td> <input type="submit" name="enviar" value="Registrar"> </td>
                    
                </tr>
            </table>
        </form>
    </body>
</html>
