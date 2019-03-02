package pt.jmartinspt.cursospring.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pt.jmartinspt.cursospring.domain.Categoria;
import pt.jmartinspt.cursospring.domain.Cliente;
import pt.jmartinspt.cursospring.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) {

        Cliente obj = service.findById(id);

        return ResponseEntity.ok(obj);

    }


}
