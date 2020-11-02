package app.DAO.IDAO;



import app.Entities.ProductEntity;
import app.Entities.ProductViewEntity;

import java.util.List;

public interface ProductDAO extends IDAO<ProductEntity> {

    List<ProductViewEntity> getProductViewList();

}
