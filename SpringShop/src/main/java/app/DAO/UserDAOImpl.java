package app.DAO;

import app.DAO.IDAO.UserDAO;
import app.Entities.UserEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
@Component
public class UserDAOImpl implements UserDAO {
    @Override
    public UserEntity getUserByLogin(String login) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from UserEntity where login = :login";
            Query query = session.createQuery(hql);
            query.setParameter("login", login);
            UserEntity res = (UserEntity) query.getSingleResult();
            session.getTransaction().commit();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
