package br.furb.bcc.bancosangue.endpoint;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.furb.bcc.bancosangue.dao.PessoaDAO;
import br.furb.bcc.bancosangue.model.Pessoa;

public class PessoaEndPoint {
	ResponseEntity<Object> responseEntity;
	
	@GetMapping("/pessoa")
    public String home(@RequestParam(value = "id") int id) {
        Pessoa pessoa = PessoaDAO.getInstance().find(id);
        return "Nome: " + pessoa.getNome()
        	 + "Idade: " + pessoa.getIdade()
        	 +  "Sexo: " + pessoa.getSexo() 
        	 + "Tipo Sanguíneo" + pessoa.getTipoSanguineo().getTipo();
    }
	
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> insert(@RequestBody Pessoa pessoa) {
		Map<String, String> responseObj = new HashMap<>();
		
		PessoaDAO dao = new PessoaDAO();
		
		try {
			if (pessoa == null)
				throw new Exception("Pessoa é nula.");

			dao.add(pessoa);

			responseObj.put("OK", "Pessoa cadastrada com sucesso");
			responseEntity = new ResponseEntity<>(responseObj, HttpStatus.OK);

		} catch (Exception e) {
			responseObj.put("ERRO", e.getMessage());
			responseEntity = new ResponseEntity<>(responseObj, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
}
