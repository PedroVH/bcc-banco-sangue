package br.furb.bcc.bancosangue.dao;

import br.furb.bcc.bancosangue.DBConnection;
import br.furb.bcc.bancosangue.model.TipoSanguineo;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TipoSanguineoDAO extends AbstractDAO<TipoSanguineo> {

    private static TipoSanguineoDAO instance;

    public static TipoSanguineoDAO getInstance(){
        if (instance == null)
            instance = new TipoSanguineoDAO();
        return instance;
    }

    public TipoSanguineo findByTipo(String tipo) {
        Session session = DBConnection.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TipoSanguineo> criteria = builder.createQuery(getClazz());
        Root<TipoSanguineo> rootDepartment = criteria.from(getClazz());
        criteria.select(rootDepartment).where(builder.like(rootDepartment.get("tipo"), tipo));

        List<TipoSanguineo> tipos = session.createQuery(criteria).getResultList();
        if (tipos.size() != 0)
            return tipos.get(0);

        return null;
    }

    @Override
    protected Class<TipoSanguineo> getClazz() {
        return TipoSanguineo.class;
    }
}
