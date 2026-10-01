package com.sistema_pedidos.ms.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PedidoRequest(String nomeCliente,
                            String descricaoProduto,
                            BigDecimal valor,
                            LocalDate data) {
}
