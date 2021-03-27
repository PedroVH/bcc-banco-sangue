package br.furb.bcc.bancosangue.endpoint;

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
    AbstractDAO<TipoSanguineo> dao = TipoSanguineoDAO.getInstance();

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> get(@PathVariable("id") int id) {
        TipoSanguineo tipo = dao.find(id);

        String response = tipo.getQtdDisponivel() + " MLs para o tipo " + tipo.getTipo();
        return new ResponseEntity<>(response, HttpStatus.OK);
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
