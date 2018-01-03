package com.example.alberth.appstopinfraction.data.model;

/**
 * Created by alberth on 01/01/2018.
 */

public class TypeInfraction {
    private String codigo;
    private String detalle;
    private String monto;


    public TypeInfraction(String codigo, String detalle, String monto){
        super();
        this.setCodigo(codigo);
        this.setDetalle(detalle);
        this.setMonto(monto);
    }

    public TypeInfraction(){
        super();
    }






    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }
}
