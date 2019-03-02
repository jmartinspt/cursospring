package pt.jmartinspt.cursospring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.jmartinspt.cursospring.dao.ClienteDao;
import pt.jmartinspt.cursospring.domain.Cliente;
import pt.jmartinspt.cursospring.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteDao dao;

    public Cliente findById(Integer id) {

        Optional<Cliente> obj = dao.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto Não encontrado! ID =" + id + ", Tipo: " + Cliente.class.getName()) );

    }

}
