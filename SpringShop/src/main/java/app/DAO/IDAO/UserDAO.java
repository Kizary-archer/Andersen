package app.DAO.IDAO;


import app.Entities.UserEntity;

public interface UserDAO extends IDAO<UserEntity> {
    UserEntity getUserByLogin(String login);

}
