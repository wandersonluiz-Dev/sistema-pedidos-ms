package com.sistema_pedidos.ms.dto;

import com.sistema_pedidos.ms.model.PedidoEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PedidoResonseDto(Long id,
                               String nomeCliente,
                               String descricaoProduto,
                               BigDecimal valor,
                               LocalDate data,
                               Status status) {

    public PedidoResonseDto(PedidoEntity pedido) {
        this(
                pedido.getId(),
                pedido.getNomeCliene(),
                pedido.getDescricaoProduto(),
                pedido.getValor(),
                pedido.getData(),
                pedido.getStatus()
        );
    }
}
