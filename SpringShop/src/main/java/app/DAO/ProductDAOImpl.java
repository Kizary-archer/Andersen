package app.DAO;

import app.DAO.IDAO.ProductDAO;
import app.Entities.ProductViewEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;
@Component
public class ProductDAOImpl implements ProductDAO {
    @Override
    public List<ProductViewEntity> getProductViewList() {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  p " +
                    "from ProductViewEntity p ";
            Query query = session.createQuery(hql);
            List<ProductViewEntity> res = (List<ProductViewEntity>) query.getResultList();
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
