package main.java.app.DAO.IDAO;

import main.java.app.Entities.UserEntity;

public interface UserDAO extends IDAO<UserEntity> {
    UserEntity getUserByLogin(String login);

}
