package com.sistema_pedidos.ms.controller;

import com.sistema_pedidos.ms.dto.PedidoRequest;
import com.sistema_pedidos.ms.dto.PedidoResonseDto;
import com.sistema_pedidos.ms.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoResonseDto criarPedido(@RequestBody PedidoRequest request) {
       return service.criarPedido(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PedidoResonseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPoId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoResonseDto> buscarTodosPedidos() {
        return service.buscarTodosPedidos();
    }

}
