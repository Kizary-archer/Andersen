package main.java.app.Service;


import main.java.app.DAO.IDAO.UserDAO;
import main.java.app.DAO.UserDAOImpl;
import main.java.app.Entities.UserEntity;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {
    UserDAO userDAO = new UserDAOImpl();

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
