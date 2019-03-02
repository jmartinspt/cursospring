package pt.jmartinspt.cursospring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.jmartinspt.cursospring.dao.CategoriaDao;
import pt.jmartinspt.cursospring.domain.Categoria;
import pt.jmartinspt.cursospring.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaDao dao;

    public Categoria findById(Integer id) {

        Optional<Categoria> obj = dao.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto Não encontrado! ID =" + id + ", Tipo: " + Categoria.class.getName()) );

    }

}
