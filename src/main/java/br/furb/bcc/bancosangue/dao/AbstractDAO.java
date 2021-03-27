package br.furb.bcc.bancosangue.dao;

import br.furb.bcc.bancosangue.DBConnection;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;

public abstract class AbstractDAO<T> {

    public boolean add(T obj) {
        try {
            Session session = DBConnection.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public T find(int id) {
        Session session = DBConnection.getSessionFactory().openSession();
        T obj = session.find(getClazz(), id);
        session.close();
        return obj;
    }

    public boolean update(int id, T obj) {
        Session session = DBConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(obj);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public boolean delete(int id) {
        Session session = DBConnection.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.remove(session.find(getClazz(), id));
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<T> getAll() {
        Session session = DBConnection.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(getClazz());
        criteria.from(getClazz());
        return (ArrayList<T>) session.createQuery(criteria).getResultList();
    }

    protected abstract Class<T> getClazz();
}
