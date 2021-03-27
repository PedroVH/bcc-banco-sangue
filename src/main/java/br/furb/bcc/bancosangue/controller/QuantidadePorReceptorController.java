package br.furb.bcc.bancosangue.controller;

import br.furb.bcc.bancosangue.dao.AbstractDAO;
import br.furb.bcc.bancosangue.dao.TipoSanguineoDAO;
import br.furb.bcc.bancosangue.model.TipoSanguineo;

public class QuantidadePorReceptorController {

    AbstractDAO<TipoSanguineo> dao = TipoSanguineoDAO.getInstance();

}
