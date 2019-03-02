package pt.jmartinspt.cursospring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.jmartinspt.cursospring.domain.Pedido;

@Repository
public interface PedidoDao extends JpaRepository<Pedido,Integer> {


}
