package com.sistema_pedidos.ms.service;

import com.sistema_pedidos.ms.dto.PedidoRequest;
import com.sistema_pedidos.ms.dto.PedidoResonseDto;
import com.sistema_pedidos.ms.dto.Status;
import com.sistema_pedidos.ms.exception.PedidoNaoEncontradoException;
import com.sistema_pedidos.ms.exception.ValorInvalidoException;
import com.sistema_pedidos.ms.model.PedidoEntity;
import com.sistema_pedidos.ms.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;


    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoResonseDto criarPedido(PedidoRequest request) {

        if (request.valor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValorInvalidoException();
        }

        PedidoEntity pedido = new PedidoEntity();

        pedido.setNomeCliene(request.nomeCliente());
        pedido.setDescricaoProduto(request.descricaoProduto());
        pedido.setValor(request.valor());
        pedido.setData(request.data());
        pedido.setStatus(Status.CRIADO);

        PedidoEntity pedidoSalvo = pedidoRepository.save(pedido);

        return new PedidoResonseDto(pedidoSalvo);

    }

    public PedidoResonseDto buscarPoId(Long id) {
        PedidoEntity pedido = pedidoRepository.findById(id)
                .orElseThrow(PedidoNaoEncontradoException::new);

        return new PedidoResonseDto(pedido);
    }

    public List<PedidoResonseDto> buscarTodosPedidos() {

        List<PedidoEntity> pedido = pedidoRepository.findAll();

        return pedido.stream().
                map(PedidoResonseDto::new).
                toList();
    }


}
