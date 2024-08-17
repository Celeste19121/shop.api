package com.methaporce.shop.app.utils;

import java.util.List;

public class ModelError {
    private String codigo;
    private String mensaje;

    private List<String> errores;

    public ModelError() {
    }

    public ModelError(String codigo, String mensaje, List<String> errores) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.errores = errores;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }
}

