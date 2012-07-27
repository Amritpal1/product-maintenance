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
public class ProductsDelete extends HttpServlet {
    //private String sku = "";
    private String delete = "no";
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
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductsDelete</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            
            String url = "/admin/products.jsp";
            //ServletContext context = getServletContext();
            //String path = context.getRealPath("/WEB-INF/items.txt");
            String includeUrl = "";
            String sku = request.getParameter("sku");
            delete = request.getParameter("delete");
               
           Product prod = ProductDB.getOne(sku);
           
           includeUrl = "/products/delete-items.jsp";
           request.setAttribute("product", prod);
           
           if ("yes".equals(delete)) {
               
                //prod.setSKU(sku);
                ProductDB.delete(sku);
                //ProductIO.delete(prod, path);
                includeUrl = "/products/view-items.jsp";
                //request.setAttribute("message", message);
                response.sendRedirect("/musicStore/admin/products");
                request.setAttribute("productList", ProductDB.getProducts());
            }
           if (delete == null) { 
            request.setAttribute("includeUrl", includeUrl );
            RequestDispatcher dis = getServletContext().getRequestDispatcher(url);
            dis.forward(request,response);
           }
            out.println("<h1>Servlet ProductsDelete at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(ProductsDelete.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ProductsDelete.class.getName()).log(Level.SEVERE, null, ex);
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
