package com.sistema_pedidos.ms.exception;

public class DataInvalidaException extends RuntimeException {
    public DataInvalidaException() {
        super("A data inválida");
    }
}
