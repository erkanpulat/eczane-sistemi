
package util;

import controller.ilacBean;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "FileServlet", urlPatterns = {"/file/*"})
public class FileServlet extends HttpServlet{

    @Inject
    private ilacBean ic;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String file=request.getPathInfo();
        File f = new File(ic.getUploadTo()+file);
        Files.copy(f.toPath() , response.getOutputStream());     
    }

    

}
