package app.Service;

import app.DAO.IDAO.UserOrderDAO;
import app.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserOrderService {
    private final UserOrderDAO userOrderDAO;

    @Autowired
    public UserOrderService(UserOrderDAO userOrderDAO) {
        this.userOrderDAO = userOrderDAO;
    }

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
