package app.Service;



import app.DAO.IDAO.UserDAO;
import app.Entities.UserEntity;
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

    public UserEntity authorization(UserEntity user) {
        try {
            if (!user.getLogin().equals("") && !user.getPassword().equals("")) {
                UserEntity authUser = userDAO.getUserByLogin(user.getLogin());
                if (authUser != null && BCrypt.checkpw(user.getPassword(), authUser.getPassword()))
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
