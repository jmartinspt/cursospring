package pt.jmartinspt.cursospring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.jmartinspt.cursospring.domain.Categoria;

@Repository
public interface CategoriaDao extends JpaRepository<Categoria,Integer> {


}
