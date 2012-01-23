/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author miguel
 */
@WebServlet(name = "Registrar", urlPatterns = {"/Registrar"})
public class Registrar extends HttpServlet {

    String directorioArchivos;		// Donde guardaré archivos

    /**
     * **********************************************************************************
     * Obtengo el directorio donde guardaré los archivos
     * **********************************************************************************
     */
    public void init(ServletConfig config) throws ServletException {
        ServletContext sc = config.getServletContext(); // Conseguimos un contexto

        directorioArchivos = sc.getRealPath("/");  // El directorio donde estarán los archivos

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(40960); // bytes

        File repositoryPath = new File("/temp");
        diskFileItemFactory.setRepository(repositoryPath);

        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setSizeMax(81920); // bytes
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            //// Inicio de pagina
            out.println("<html>");
            out.println("<head><title</title></head>");
            out.println("<body bgcolor=\"#FFFF9D\"><FONT color=\"#000080\" FACE=\"Arial,Helvetica,Times\" SIZE=2>"
                    + "<CENTER><H3>Carga de Blob</H3></CENTER><HR>");

            out.println("<p>Directorio de archivos: " + directorioArchivos + "</p>");

            //// Si la request es del tipo multipart ...
            if (ServletFileUpload.isMultipartContent(request)) {

                //// fileItemsList contendrá una lista de items de archivo que  son instancias de FileItem
                //// Un item de archivo puede contener un archivo para upload o un campo del formulario
                //// con la estructura simple nombre-valor (ejemplo: <input name="text_field" type="text" />)
                ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
                List fileItemsList = servletFileUpload.parseRequest(request);


                //// Itero para obtener todos los FileItem
                Iterator it = fileItemsList.iterator();
                while (it.hasNext()) {
                    FileItem fileItem = (FileItem) it.next();

                    //// El FileItem es un campo simple, del tipo nombre-valor
                    if (fileItem.isFormField()) {
                        String nombre = fileItem.getFieldName();
                        String valor = fileItem.getString();
                        out.println("<p>Parámetro:" + nombre + "   Valor:" + valor + "</p>");
                    } //// El FileItem contiene un archivo para upload
                    else {

                        //// Atributo "name" del elemento input type="file"
                        String nombreCampo = fileItem.getFieldName();

                        //// Tamaño de archivo en bytes
                        long tamanioArchivo = fileItem.getSize();

                        //// Nombre del archivo en el cliente. Algunos navegadores (por ej. IE 6)
                        //// incluyen el path completo, lo que puede implicar separar path
                        //// de nombre.
                        String nombreArchivo = fileItem.getName();

                        //// Content type (tipo MIME) del archivo.
                        //// Esta información la proporciona el navegador del cliente.
                        //// Algunos ejemplos: .jpg = image/jpeg, .txt = text/plain
                        String contentType = fileItem.getContentType();

                        //// Obtengo caracteristicas de campo y archivo
                        out.println("<p>--> Name:" + nombreCampo + "</p>");
                        out.println("<p>--> Tamaño archivo:" + tamanioArchivo + "</p>");
                        out.println("<p>--> Nombre archivo del cliente:" + nombreArchivo + "</p>");
                        out.println("<p>--> contentType:" + contentType + "</p>");

                        //// Obtengo extensión del archivo de cliente
                        String extension = nombreArchivo.substring(nombreArchivo.indexOf("."));
                        out.println("<p>--> Extensión del archivo:" + extension + "</p>");

                        //// Guardo archivo del cliente en servidor, con un nombre 'fijo' y la
                        //// extensión que me manda el cliente
                        File archivo = new File(directorioArchivos + "/cv" + extension);
                        
                        fileItem.write(archivo);
                        if (archivo.exists()) {
                            out.println("<p>--> GUARDADO " + archivo.getAbsolutePath() + "</p>");
                        } else {
                            out.println("<p>--> FALLO AL GUARDAR. NO EXISTE " + archivo.getAbsolutePath() + "</p>");
                        }

                    }	//// FIN: es un archivo para upload
                }	//// FIN: iteración de FileItems
            }	//// FIN: la request es del tipo multipart
        } catch (Exception e) {
            //e.printStackTrace(out);
            e.printStackTrace();
        }

        out.println("</body></html>");
    }

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
