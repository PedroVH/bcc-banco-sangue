package br.furb.bcc.bancosangue.endpoint;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.furb.bcc.bancosangue.dao.PessoaDAO;
import br.furb.bcc.bancosangue.model.Pessoa;

@CrossOrigin
@RestController
@RequestMapping("/pessoa")
public class PessoaEndPoint {
	ResponseEntity<Object> responseEntity;

	@GetMapping("/{id}")
	public ResponseEntity<Object> get(@PathVariable(value = "id") int id) {
		Pessoa pessoa = PessoaDAO.getInstance().find(id);
		System.out.println(pessoa);
		return new ResponseEntity<>(pessoa, HttpStatus.OK);
	}

	@GetMapping("/nome/{nome}")
    public ResponseEntity<Object> getNome(@PathVariable(value = "nome") String nome) {
        Pessoa pessoa = PessoaDAO.getInstance().findByNome(nome);
		System.out.println(pessoa);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }
	/*
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
	}*/
}
