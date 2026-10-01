package com.sistema_pedidos.ms.exception;

public class ValorInvalidoException extends RuntimeException {
    public ValorInvalidoException() {
        super("O valor digitado é inválido");
    }
}
