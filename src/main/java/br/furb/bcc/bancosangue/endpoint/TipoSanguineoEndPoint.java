package br.furb.bcc.bancosangue.endpoint;

import br.furb.bcc.bancosangue.controller.QuantidadePorReceptorController;
import br.furb.bcc.bancosangue.dao.AbstractDAO;
import br.furb.bcc.bancosangue.dao.TipoSanguineoDAO;
import br.furb.bcc.bancosangue.model.TipoSanguineo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/tipo")
public class TipoSanguineoEndPoint {
	TipoSanguineoDAO dao = TipoSanguineoDAO.getInstance();
    QuantidadePorReceptorController controller = new QuantidadePorReceptorController();

    @GetMapping(value = "/{tipo}", produces = "application/json")
    public ResponseEntity<Object> getTipoSanguineo(@PathVariable("tipo") String tipo) {
        TipoSanguineo tipoSanguineo = dao.findByTipo(tipo);
        return new ResponseEntity<>(tipoSanguineo, HttpStatus.OK);
    }

    @GetMapping(value = "/{tipo}/disponivel", produces = "application/json")
    public ResponseEntity<String> getDisponivel(@PathVariable("tipo") String tipo) {
        String tipoDisponivel = dao.findByTipo(tipo).getQtdDisponivel() + "ml";
        return new ResponseEntity<>(tipoDisponivel, HttpStatus.OK);
    }
    
	@GetMapping(value = "/{tipo}/disponivel/receptor", produces = "application/json")
	public ResponseEntity<String> getDisponivelReceptor(@PathVariable("tipo") String tipo) {
		TipoSanguineo tipoReceptor = dao.findByTipo(tipo);
		switch (tipoReceptor.getTipo()) {
		case "A+":
			String qtdDisponivelReceptor = controller.getQuantidadeDisponivelAPositivo() + " ml";
			return new ResponseEntity<>(qtdDisponivelReceptor, HttpStatus.OK);
		case "A-":
			qtdDisponivelReceptor = controller.getQuantidadeDisponivelANegativo() + " ml";
			return new ResponseEntity<>(qtdDisponivelReceptor, HttpStatus.OK);
		case "B+":
			qtdDisponivelReceptor = controller.getQuantidadeDisponivelBPositivo() + " ml" ;
			return new ResponseEntity<>(qtdDisponivelReceptor, HttpStatus.OK);
		case "B-":
			qtdDisponivelReceptor = controller.getQuantidadeDisponivelBNegativo() + " ml";
			return new ResponseEntity<>(qtdDisponivelReceptor, HttpStatus.OK);
		case "AB+":
			qtdDisponivelReceptor = controller.getQuantidadeDisponivelABPositivo() + " ml";
			return new ResponseEntity<>(qtdDisponivelReceptor, HttpStatus.OK);
		case "AB-":
			qtdDisponivelReceptor = controller.getQuantidadeDisponivelABNegativo() + " ml";
			return new ResponseEntity<>(qtdDisponivelReceptor, HttpStatus.OK);
		case "O+":
			qtdDisponivelReceptor = controller.getQuantidadeDisponivelOPositivo() + " ml";
			return new ResponseEntity<>(qtdDisponivelReceptor, HttpStatus.OK);
		case "O-":
			qtdDisponivelReceptor = controller.getQuantidadeDisponivelONegativo() + " ml";
			return new ResponseEntity<>(qtdDisponivelReceptor, HttpStatus.OK);
		}
		return null;
	}

    @GetMapping(produces = "application/json")
    public ResponseEntity<Object> getAll() {
        Map<String, String> responseObj = new HashMap<>();
        ResponseEntity<Object> responseEntity;

        try {
            ArrayList<TipoSanguineo> tipos = dao.getAll();
            responseEntity = new ResponseEntity<>(tipos, HttpStatus.OK);
        } catch (Exception e) {
            responseObj.put("error", e.getMessage());
            responseEntity = new ResponseEntity<>(responseObj, HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

}
