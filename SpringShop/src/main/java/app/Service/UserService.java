package main.java.app.Service;


import main.java.app.DAO.IDAO.UserDAO;
import main.java.app.DAO.UserDAOImpl;
import main.java.app.Entities.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserEntity authorization(String login, String pass) {
        try {
            if (!login.equals("") && !pass.equals("")) {
                UserEntity user = userDAO.getUserByLogin(login);
                if (user != null && BCrypt.checkpw(pass, user.getPassword()))
                    return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean registration(String login, String pass) {
        try {
            if (!login.equals("") && !pass.equals("")) {
                UserEntity userEntity = new UserEntity();
                userEntity.setLogin(login);
                userEntity.setPassword(BCrypt.hashpw(pass, BCrypt.gensalt(12)));//кодирование пароля
                return userDAO.add(userEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
