package org.serratec.java2backend.exercicio021.repository;

import org.serratec.java2backend.exercicio021.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
