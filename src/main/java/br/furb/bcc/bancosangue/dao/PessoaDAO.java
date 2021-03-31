package br.furb.bcc.bancosangue.dao;

import br.furb.bcc.bancosangue.DBConnection;
import br.furb.bcc.bancosangue.model.Pessoa;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PessoaDAO extends AbstractDAO<Pessoa> {

	private static PessoaDAO instance;

    public static PessoaDAO getInstance(){
        if (instance == null)
            instance = new PessoaDAO();
        return instance;
    }

    public Pessoa findByNome(String nome) {
        Session session = DBConnection.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Pessoa> criteria = builder.createQuery(getClazz());
        Root<Pessoa> rootDepartment = criteria.from(getClazz());
        criteria.select(rootDepartment).where(builder.like(rootDepartment.get("nome"), nome));

        List<Pessoa> pessoas = session.createQuery(criteria).getResultList();
        if (pessoas.size() != 0)
            return pessoas.get(0);

        return null;
    }

    @Override
    protected Class<Pessoa> getClazz() {
        return Pessoa.class;
    }
}
