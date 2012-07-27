/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package products.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import products.music.business.Product;
import products.music.data.ProductDB;
import products.music.data.ProductIO;

/**
 *
 * @author juliantais
 */
public class ProductsEdit extends HttpServlet {
    private String sku = "";
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
            out.println("<title>Servlet ProductsEdit</title>");            
            out.println("</head>");
            out.println("<body>");
            String url = "/admin/products.jsp";
            
            sku = request.getParameter("sku");
            Product prod = ProductDB.getOne(sku);
            
            String includeUrl = "/products/edit-items.jsp";
            
            
            request.setAttribute("product", prod);
            request.setAttribute("includeUrl", includeUrl );
            
            RequestDispatcher dis = getServletContext().getRequestDispatcher(url);
            dis.forward(request,response);
            out.println("<h1>Servlet ProductsEdit at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(ProductsEdit.class.getName()).log(Level.SEVERE, null, ex);
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
        //processRequest(request, response);
        
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        
        Product prod = new Product(sku, description, price);
        //validate
        
        String message = "";
        String url = "/admin/products.jsp";
        String includeUrl = "";
        
        
        if (sku.length() == 0 || description.length() == 0 ||
                price.length() == 0) {
            message = "Please fill out all the boxes before continuing";
            
           
            includeUrl = "/products/edit-items.jsp";
            
            // store user object in request object
            request.setAttribute("includeUrl", includeUrl );
            request.setAttribute("product", prod);
            request.setAttribute("message", message);
            request.setAttribute("productList", ProductDB.getProducts());
            //forward request to JSP
            //url = "/products/display-items.jsp";
            RequestDispatcher dis = getServletContext().getRequestDispatcher(url);
            dis.forward(request,response);
            
        } else {
            message = "";
            try {
                products.music.data.ProductDB.update(prod);
            } catch (NamingException ex) {
                Logger.getLogger(ProductsEdit.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProductsEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("/musicStore/admin/products");
            includeUrl = "/products/view-items.jsp";
            
        }
        
        
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
