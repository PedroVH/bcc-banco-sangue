package br.furb.bcc.bancosangue.dao;

import br.furb.bcc.bancosangue.model.Pessoa;

public class PessoaDAO extends AbstractDAO<Pessoa> {

	private static PessoaDAO instance;

    public static PessoaDAO getInstance(){
        if (instance == null)
            instance = new PessoaDAO();
        return instance;
    }
    
    @Override
    protected Class<Pessoa> getClazz() {
        return Pessoa.class;
    }
}
