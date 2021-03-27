package br.furb.bcc.bancosangue.controller;

import java.util.ArrayList;

import br.furb.bcc.bancosangue.dao.AbstractDAO;
import br.furb.bcc.bancosangue.dao.TipoSanguineoDAO;
import br.furb.bcc.bancosangue.model.TipoSanguineo;

public class QuantidadePorReceptorController {
    AbstractDAO<TipoSanguineo> dao = TipoSanguineoDAO.getInstance();
    
    //A+ pode receber de : A+, A-, O+ e O-
    public long quantidadeDisponivelAPositivo(Integer id) {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		if (tipoDoador.getTipo().equals("A+") ||
    			tipoDoador.getTipo().equals("A-") ||
    			tipoDoador.getTipo().equals("O+") ||
    			tipoDoador.getTipo().equals("O-")) {
    			qtdDisponivel+=tipoDoador.getQtdDisponivel();
    		}
    	}
		return qtdDisponivel;
    }
    
  //A- pode receber de : A- e O-
    public long quantidadeDisponivelANegativo() {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		if (tipoDoador.getTipo().equals("A-") ||
    			tipoDoador.getTipo().equals("O-")) {
    			qtdDisponivel+=tipoDoador.getQtdDisponivel();
    		}
    	}
    	return qtdDisponivel;
    }
    
  //B+ pode receber de : B+, B-, O+ e O-
    public long quantidadeDisponivelBPositivo(Integer id) {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		if (tipoDoador.getTipo().equals("B+") ||
    			tipoDoador.getTipo().equals("B-") ||
    			tipoDoador.getTipo().equals("O+") ||
    			tipoDoador.getTipo().equals("O-")) {
    			qtdDisponivel+=tipoDoador.getQtdDisponivel();
    		}
    	}
    	return qtdDisponivel;
    }
    
    //B- pode receber de : B- e O-
    public long quantidadeDisponivelBNegativo(Integer id) {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		if (tipoDoador.getTipo().equals("B-") ||
    			tipoDoador.getTipo().equals("O-")) {
    			qtdDisponivel+=tipoDoador.getQtdDisponivel();
    		}
    	}
    	return qtdDisponivel;
    }
    
  //AB+ pode receber de : todos
    public long quantidadeDisponivelABPositivo(Integer id) {
    	TipoSanguineo tipoReceptor = dao.find(id);
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		qtdDisponivel+=tipoDoador.getQtdDisponivel();
    	tipoReceptor.setQtdDisponivel(qtdDisponivel);
    	}
    	return qtdDisponivel;
    }
    
  //AB- pode receber de : A-, B-, O- e AB-
    public long quantidadeDisponivelABNegativo(Integer id) {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		if (tipoDoador.getTipo().equals("A-") ||
    			tipoDoador.getTipo().equals("B-") ||
    			tipoDoador.getTipo().equals("O-") ||
    			tipoDoador.getTipo().equals("B-") ||
    			tipoDoador.getTipo().equals("AB-")) {
    			qtdDisponivel+=tipoDoador.getQtdDisponivel();
    		}
    	}
    	return qtdDisponivel;
    }
    
  //O+ pode receber de : O+ e O-
    public long quantidadeDisponivelOPositivo(Integer id) {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		if (tipoDoador.getTipo().equals("O+") ||
    			tipoDoador.getTipo().equals("O-"))  {
    			qtdDisponivel+=tipoDoador.getQtdDisponivel();
    		}
    	}
    	return qtdDisponivel;
    }
    
  //O- pode receber de : A-, B-, O- e AB-
    public long quantidadeDisponivelONegativo(Integer id) {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		if (tipoDoador.getTipo().equals("O-")) {
    			qtdDisponivel+=tipoDoador.getQtdDisponivel();
    		}
    	}
    	return qtdDisponivel;
    }
}
