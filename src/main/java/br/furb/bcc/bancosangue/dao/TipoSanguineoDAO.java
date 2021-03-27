package br.furb.bcc.bancosangue.dao;

import br.furb.bcc.bancosangue.model.TipoSanguineo;

public class TipoSanguineoDAO extends AbstractDAO<TipoSanguineo> {

    private static TipoSanguineoDAO instance;

    public static TipoSanguineoDAO getInstance(){
        if (instance == null)
            instance = new TipoSanguineoDAO();
        return instance;
    }

    @Override
    protected Class<TipoSanguineo> getClazz() {
        return TipoSanguineo.class;
    }
}
