package main.java.app.Service;

import main.java.app.DAO.IDAO.ProductDAO;
import main.java.app.DAO.ProductDAOImpl;
import main.java.app.Entities.ProductViewEntity;

import java.util.List;

public class ProductService {
    ProductDAO productDAO = new ProductDAOImpl();
    public List<ProductViewEntity> productList(){
        return productDAO.getProductViewList();
    }
}
