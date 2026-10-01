package com.sistema_pedidos.ms.model;

import com.sistema_pedidos.ms.dto.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nomeCliene;

    @Column(nullable = false)
    private String descricaoProduto;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private Status status;
}
