package pt.jmartinspt.cursospring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.jmartinspt.cursospring.domain.ItemPedido;

@Repository
public interface ItemPedidoDao extends JpaRepository<ItemPedido,Integer> {


}
