package products.shop;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;
import products.music.business.Product;
import products.music.data.ProductDB;
import products.music.data.ProductIO;

/**
 *
 * @author juliantais
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class ProductServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
        
            String url = "/admin/products.jsp";
            
            
            String includeUrl = "/products/view-items.jsp";
            ServletContext sc = getServletContext();
            sc.setAttribute("productList", ProductDB.getProducts());
            
            request.setAttribute("includeUrl", includeUrl );
            request.setAttribute("productList", ProductDB.getProducts());
            
            RequestDispatcher dis = getServletContext().getRequestDispatcher(url);
            dis.forward(request,response);
        
        
        
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        
        /*
        String sku = request.getParameter("sku");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        
        
        
        Product prod = new Product(sku, description, price);
        //validate
        
        String message = "";
        String url = "/";
        String includeUrl = "";
        
        if (sku.length() == 0 || description.length() == 0 ||
                price.length() == 0) {
            message = "Please fill out all the boxes before continuing";
            
           
            includeUrl = "/products/add-item.jsp";
            
            
        } else {
            message = "";
        
            ServletContext context = getServletContext();
            String path = context.getRealPath("/WEB-INF/items.txt");
            ProductIO.add(prod, path);
            
            includeUrl = "/products/display-items.jsp";
            
        }
        
        // store user object in request object
        request.setAttribute("includeUrl", includeUrl );
        request.setAttribute("product", prod);
        request.setAttribute("message", message);

        //forward request to JSP
        //url = "/products/display-items.jsp";
        RequestDispatcher dis = getServletContext().getRequestDispatcher(url);
        dis.forward(request,response);
        */
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
