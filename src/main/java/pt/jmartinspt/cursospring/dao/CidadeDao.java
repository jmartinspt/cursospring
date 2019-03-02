package pt.jmartinspt.cursospring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.jmartinspt.cursospring.domain.Cidade;

@Repository
public interface CidadeDao extends JpaRepository<Cidade,Integer> {


}
