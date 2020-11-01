package main.java.app.Controllers;



import main.java.app.Entities.ProductViewEntity;
import main.java.app.Service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/viewProduct"})
public class ProductServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductService();

        List<ProductViewEntity> prodList = productService.productList();
        request.setAttribute("productList", prodList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/addOrder.jsp");

        requestDispatcher.forward(request, response);
    }

}


