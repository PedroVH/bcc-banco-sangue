package br.furb.bcc.bancosangue.endpoint;

import br.furb.bcc.bancosangue.dao.TipoSanguineoDAO;
import br.furb.bcc.bancosangue.model.TipoSanguineo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipoSanguineoEndPoint {

    @GetMapping("/tipo")
    public String home(@RequestParam(value = "id") int id) {
        TipoSanguineo tipo = TipoSanguineoDAO.getInstance().find(id);
        return tipo.getQtdDisponivel() + " MLs para o tipo " + tipo.getTipo();
    }
}
