package com.sistema_pedidos.ms.repository;

import com.sistema_pedidos.ms.model.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
