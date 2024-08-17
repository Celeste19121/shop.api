package com.methaporce.shop.app.exeptiones;

import org.springframework.http.HttpStatus;

public class NotFoundExeption extends RuntimeException{
    private String codigo;
    private HttpStatus httpStatus;
    public NotFoundExeption(String mensaje, String codigo, HttpStatus httpStatus){
        super(mensaje);
        this.codigo = codigo;
        this.httpStatus = httpStatus;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
