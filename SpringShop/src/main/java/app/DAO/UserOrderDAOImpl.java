package app.DAO;


import app.DAO.IDAO.UserOrderDAO;
import app.Entities.ManufactureEntity;
import app.Entities.ProdTypeEntity;
import app.Entities.UserEntity;
import app.Entities.UserOrderViewEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class UserOrderDAOImpl implements UserOrderDAO {

    @Override
    public List<UserOrderViewEntity> getUserOrderViewList(UserEntity userEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  uov " +
                    "from UserOrderViewEntity uov " +
                    "where uov.user = :idUser";
            Query query = session.createQuery(hql);
            query.setParameter("idUser", userEntity.getIduser());
            List<UserOrderViewEntity> res = query.getResultList();
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

    @Override
    public List<ManufactureEntity> getManufactureList() {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  m " +
                    "from ManufactureEntity m ";
            Query query = session.createQuery(hql);
            List<ManufactureEntity> res = (List<ManufactureEntity>) query.getResultList();
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

    @Override
    public List<ProdTypeEntity> getProdTypeList() {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  p " +
                    "from ProdTypeEntity p ";
            Query query = session.createQuery(hql);
            List<ProdTypeEntity> res = (List<ProdTypeEntity>) query.getResultList();
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

    @Override
    public boolean delById(Integer id) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "delete from UserOrderEntity where idorder = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id",id);
            query.executeUpdate();
            session.getTransaction().commit();
            return true ;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
