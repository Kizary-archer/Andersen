package main.java.app.DAO.IDAO;


import main.java.app.Entities.*;

import java.util.List;

public interface UserOrderDAO extends IDAO<UserOrderEntity> {

    List<UserOrderViewEntity> getUserOrderViewList(UserEntity userEntity);
    List<ManufactureEntity> getManufactureList();
    List<ProdTypeEntity> getProdTypeList();
    boolean delById(Integer id);


}
