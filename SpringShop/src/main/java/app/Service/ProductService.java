package main.java.app.Service;

import main.java.app.DAO.IDAO.ProductDAO;
import main.java.app.DAO.ProductDAOImpl;
import main.java.app.Entities.ProductViewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<ProductViewEntity> productList() {
        return productDAO.getProductViewList();
    }
}
