package pt.jmartinspt.cursospring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.jmartinspt.cursospring.domain.Produto;

@Repository
public interface ProdutoDao extends JpaRepository<Produto,Integer> {


}
