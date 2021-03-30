package br.furb.bcc.bancosangue.controller;

import java.util.ArrayList;

import br.furb.bcc.bancosangue.dao.AbstractDAO;
import br.furb.bcc.bancosangue.dao.TipoSanguineoDAO;
import br.furb.bcc.bancosangue.model.TipoSanguineo;

public class QuantidadePorReceptorController {
    AbstractDAO<TipoSanguineo> dao = TipoSanguineoDAO.getInstance();
    
    //A+ pode receber de : A+, A-, O+ e O-
    public long getQuantidadeDisponivelAPositivo() {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos) {
			switch (tipoDoador.getTipo()) {
				case "A+", "A-", "O+", "O-" -> qtdDisponivel += tipoDoador.getQtdDisponivel();
			}
    	}
		return qtdDisponivel;
    }
    
  //A- pode receber de : A- e O-
    public long getQuantidadeDisponivelANegativo() {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos) {
			switch (tipoDoador.getTipo()) {
				case "A-", "O-" -> qtdDisponivel += tipoDoador.getQtdDisponivel();
			}
    	}
    	return qtdDisponivel;
    }
    
  //B+ pode receber de : B+, B-, O+ e O-
    public long getQuantidadeDisponivelBPositivo() {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos) {
			switch (tipoDoador.getTipo()) {
				case "B+", "B-", "O+", "O-" -> qtdDisponivel += tipoDoador.getQtdDisponivel();
			}
    	}
    	return qtdDisponivel;
    }
    
    //B- pode receber de : B- e O-
    public long getQuantidadeDisponivelBNegativo() {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos) {
			switch (tipoDoador.getTipo()) {
				case "B-", "O-" -> qtdDisponivel += tipoDoador.getQtdDisponivel();
			}
    	}
    	return qtdDisponivel;
    }
    
  //AB+ pode receber de : todos
    public long getQuantidadeDisponivelABPositivo() {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos) {
    		qtdDisponivel+=tipoDoador.getQtdDisponivel();
    	}
    	return qtdDisponivel;
    }
    
  //AB- pode receber de : A-, B-, O- e AB-
    public long getQuantidadeDisponivelABNegativo() {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos) {
			switch (tipoDoador.getTipo()) {
				case "A-", "B-", "O-", "AB-" -> qtdDisponivel += tipoDoador.getQtdDisponivel();
			}
    	}
    	return qtdDisponivel;
    }
    
  //O+ pode receber de : O+ e O-
    public long getQuantidadeDisponivelOPositivo() {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos) {
			switch (tipoDoador.getTipo()) {
				case "0+", "O-" -> qtdDisponivel += tipoDoador.getQtdDisponivel();
			}
    	}
    	return qtdDisponivel;
    }
    
  //O- pode receber de : A-, B-, O- e AB-
    public long getQuantidadeDisponivelONegativo() {
    	long qtdDisponivel = 0;
    	ArrayList<TipoSanguineo> tiposSanguineos = dao.getAll();
    	for (TipoSanguineo tipoDoador:tiposSanguineos) {
    		if (tipoDoador.getTipo().equals("O-")) {
    			qtdDisponivel+=tipoDoador.getQtdDisponivel();
    		}
    	}
    	return qtdDisponivel;
    }
}
