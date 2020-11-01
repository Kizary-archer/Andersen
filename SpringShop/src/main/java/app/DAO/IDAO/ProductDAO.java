package main.java.app.DAO.IDAO;


import main.java.app.Entities.ProductEntity;
import main.java.app.Entities.ProductViewEntity;

import java.util.List;

public interface ProductDAO extends IDAO<ProductEntity> {

    List<ProductViewEntity> getProductViewList();

}
