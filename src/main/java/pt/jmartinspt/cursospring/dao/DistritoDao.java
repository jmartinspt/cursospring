package pt.jmartinspt.cursospring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.jmartinspt.cursospring.domain.Distrito;

@Repository
public interface DistritoDao extends JpaRepository<Distrito,Integer> {


}
