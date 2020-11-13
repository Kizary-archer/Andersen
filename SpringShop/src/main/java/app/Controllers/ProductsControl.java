package app.Controllers;


import app.Entities.ProductViewEntity;
import app.Service.ProductService;
import app.config.SpringConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/viewProduct"})
public class ProductsControl extends HttpServlet {


//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        ProductService productService = SpringConfig.getContext().getBean("productService",ProductService.class);
//
//        List<ProductViewEntity> prodList = productService.productList();
//        request.setAttribute("productList", prodList);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/addOrder.jsp");
//
//        requestDispatcher.forward(request, response);
//    }

}


