package app.Controllers;


import app.Entities.ProductViewEntity;
import app.Service.ProductService;
import app.config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductsControl extends HttpServlet {

    ProductService productService;

    @Autowired
    public ProductsControl(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String productList(Model model) {
        List<ProductViewEntity> prodList = productService.productList();
        model.addAttribute("productList", prodList);
       return "products";
    }
}


