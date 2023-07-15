package br.com.alura.springmvc.repository;

import br.com.alura.springmvc.model.Pedido;
import br.com.alura.springmvc.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

   List<Pedido> findByStatus (StatusPedido status);

}
