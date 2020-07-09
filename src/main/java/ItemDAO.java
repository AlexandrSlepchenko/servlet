import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class ItemDAO {
    public Item save(Item item) {
        try (Session session = createSessionFactory().openSession()) {
            Transaction tr = session.getTransaction();
            tr.begin();
            session.save(item);
            tr.commit();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return item;
    }

    public Item update(Item item) {
        try (Session session = createSessionFactory().openSession()) {
            Transaction tr = session.getTransaction();
            tr.begin();
            session.update(item);
            tr.commit();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return item;
    }

    public void delete(Long id) {

        try (Session session = createSessionFactory().openSession()) {
            Transaction tr = session.getTransaction();
            tr.begin();
            session.delete(session.get(Item.class, id));
            tr.commit();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
    }

    public Item findById(Long id) {
        try (Session session = createSessionFactory().openSession()) {

            return session.get(Item.class, id);

        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List getAllItems(){
        try (Session session = createSessionFactory().openSession()) {

            return session.createQuery("FROM Item").list();

        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private SessionFactory sessionFactory;

    private SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
