package br.furb.bcc.bancosangue.controller;

import java.util.ArrayList;

import br.furb.bcc.bancosangue.dao.AbstractDAO;
import br.furb.bcc.bancosangue.dao.TipoSanguineoDAO;
import br.furb.bcc.bancosangue.model.TipoSanguineo;

public class QuantidadePorReceptorController {
    AbstractDAO<TipoSanguineo> dao = TipoSanguineoDAO.getInstance();
    
    //A+ pode receber de : A+, A-, O+ e O-
    public void quantidadeDisponivelAPositivo(Integer id) {
    	TipoSanguineo tipoReceptor = dao.find(id);
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		if (tipoDoador.getTipo().equals("A+") ||
    			tipoDoador.getTipo().equals("A-") ||
    			tipoDoador.getTipo().equals("O+") ||
    			tipoDoador.getTipo().equals("O-")) {
    			qtdDisponivel+=tipoDoador.getQtdDisponivel();
    		}
    	tipoReceptor.setQtdDisponivel(qtdDisponivel);
    	}
    }
    
  //A- pode receber de : A- e O-
    public void quantidadeDisponivelANegativo(Integer id) {
    	TipoSanguineo tipoReceptor = dao.find(id);
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		if (tipoDoador.getTipo().equals("A-") ||
    			tipoDoador.getTipo().equals("O-")) {
    			qtdDisponivel+=tipoDoador.getQtdDisponivel();
    		}
    	tipoReceptor.setQtdDisponivel(qtdDisponivel);
    	}
    }
    
  //B+ pode receber de : B+, B-, O+ e O-
    public void quantidadeDisponivelBPositivo(Integer id) {
    	TipoSanguineo tipoReceptor = dao.find(id);
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		if (tipoDoador.getTipo().equals("B+") ||
    			tipoDoador.getTipo().equals("B-") ||
    			tipoDoador.getTipo().equals("O+") ||
    			tipoDoador.getTipo().equals("O-")) {
    			qtdDisponivel+=tipoDoador.getQtdDisponivel();
    		}
    	tipoReceptor.setQtdDisponivel(qtdDisponivel);
    	}
    }
    
    //B- pode receber de : B- e O-
    public void quantidadeDisponivelBNegativo(Integer id) {
    	TipoSanguineo tipoReceptor = dao.find(id);
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		if (tipoDoador.getTipo().equals("B-") ||
    			tipoDoador.getTipo().equals("O-")) {
    			qtdDisponivel+=tipoDoador.getQtdDisponivel();
    		}
    	tipoReceptor.setQtdDisponivel(qtdDisponivel);
    	}
    }
    
  //AB+ pode receber de : todos
    public void quantidadeDisponivelABPositivo(Integer id) {
    	TipoSanguineo tipoReceptor = dao.find(id);
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		qtdDisponivel+=tipoDoador.getQtdDisponivel();
    	tipoReceptor.setQtdDisponivel(qtdDisponivel);
    	}
    }
    
  //AB- pode receber de : A-, B-, O- e AB-
    public void quantidadeDisponivelABNegativo(Integer id) {
    	TipoSanguineo tipoReceptor = dao.find(id);
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
    	tipoReceptor.setQtdDisponivel(qtdDisponivel);
    	}
    }
    
  //O+ pode receber de : O+ e O-
    public void quantidadeDisponivelOPositivo(Integer id) {
    	TipoSanguineo tipoReceptor = dao.find(id);
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		if (tipoDoador.getTipo().equals("O+") ||
    			tipoDoador.getTipo().equals("O-"))  {
    			qtdDisponivel+=tipoDoador.getQtdDisponivel();
    		}
    	tipoReceptor.setQtdDisponivel(qtdDisponivel);
    	}
    }
    
  //O- pode receber de : A-, B-, O- e AB-
    public void quantidadeDisponivelONegativo(Integer id) {
    	TipoSanguineo tipoReceptor = dao.find(id);
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos)  {
    		if (tipoDoador.getTipo().equals("O-")) {
    			qtdDisponivel+=tipoDoador.getQtdDisponivel();
    		}
    	tipoReceptor.setQtdDisponivel(qtdDisponivel);
    	}
    }
}
