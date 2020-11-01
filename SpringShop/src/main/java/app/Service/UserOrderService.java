package main.java.app.Service;

import main.java.app.DAO.IDAO.UserOrderDAO;
import main.java.app.DAO.UserOrderDAOImpl;
import main.java.app.Entities.*;

import java.util.List;

public class UserOrderService {
    UserOrderDAO userOrderDAO = new UserOrderDAOImpl();

    public List<UserOrderViewEntity> getUserOrderViewList(UserEntity userEntity) {
        return userOrderDAO.getUserOrderViewList(userEntity);
    }

    public List<ManufactureEntity> getManufactureList() {
        return userOrderDAO.getManufactureList();
    }

    public List<ProdTypeEntity> getProdTypeList() {
        return userOrderDAO.getProdTypeList();
    }

    public boolean addOrder(UserOrderEntity userOrderEntity) {
        return userOrderDAO.add(userOrderEntity);
    }
    public boolean delOrder(Integer id) {
              return userOrderDAO.delById(id);
    }
}
