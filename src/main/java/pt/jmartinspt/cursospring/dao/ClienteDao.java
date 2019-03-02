package pt.jmartinspt.cursospring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.jmartinspt.cursospring.domain.Cliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente,Integer> {


}
