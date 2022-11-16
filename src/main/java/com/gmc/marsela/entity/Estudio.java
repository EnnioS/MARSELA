package com.gmc.marsela.entity;

import javafx.scene.control.DatePicker;

public class Estudio {

    private DatePicker fecha;
    private String ciudad;
    private String sitio;
    private String observaciones;

    private Double area;
    private String uMedida;
    private Integer cantDepoBuenEstado;
    private Integer cantDepoMalEstado;
    private Double cod;
    private Integer nivelContaminacion;
    private String resultado;


    public String getSugerencia() {
        return sugerencia;
    }

    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }

    private String sugerencia;

    public DatePicker getFecha() {
        return fecha;
    }

    public void setFecha(DatePicker fecha) {
        this.fecha = fecha;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getuMedida() {
        return uMedida;
    }

    public void setuMedida(String uMedida) {
        this.uMedida = uMedida;
    }

    public Integer getCantDepoBuenEstado() {
        return cantDepoBuenEstado;
    }

    public void setCantDepoBuenEstado(Integer cantDepoBuenEstado) {
        this.cantDepoBuenEstado = cantDepoBuenEstado;
    }

    public Integer getCantDepoMalEstado() {
        return cantDepoMalEstado;
    }

    public void setCantDepoMalEstado(Integer cantDepoMalEstado) {
        this.cantDepoMalEstado = cantDepoMalEstado;
    }

    public Double getCod() {
        return cod;
    }

    public void setCod(Double cod) {
        this.cod = cod;
    }

    public Integer getNivelContaminacion() {
        return nivelContaminacion;
    }

    public void setNivelContaminacion(Integer nivelContaminacion) {
        this.nivelContaminacion = nivelContaminacion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Estudio{" +
                "fecha=" + fecha +
                ", ciudad='" + ciudad + '\'' +
                ", sitio='" + sitio + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", area=" + area +
                ", uMedida='" + uMedida + '\'' +
                ", cantDepoBuenEstado=" + cantDepoBuenEstado +
                ", cantDepoMalEstado=" + cantDepoMalEstado +
                ", cod=" + cod +
                ", nivelContaminacion=" + nivelContaminacion +
                ", resultado='" + resultado + '\'' +
                ", sugerencia='" + sugerencia + '\'' +
                '}';
    }
}
