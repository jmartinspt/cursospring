package pt.jmartinspt.cursospring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.jmartinspt.cursospring.domain.Endereco;

@Repository
public interface EnderecoDao extends JpaRepository<Endereco,Integer> {


}
