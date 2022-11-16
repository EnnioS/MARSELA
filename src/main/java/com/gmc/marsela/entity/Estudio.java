package com.gmc.marsela.entity;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.DatePicker;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Estudio {


    private ObjectProperty<Date> fecha;
    private StringProperty ciudad;
    private StringProperty sitio;
    private StringProperty observaciones;

    private DoubleProperty area;
    private StringProperty uMedida;
    private IntegerProperty cantDepoBuenEstado;
    private IntegerProperty cantDepoMalEstado;
    private DoubleProperty cod;
    private IntegerProperty nivelContaminacion;
    private StringProperty resultado;


    public Date getFecha() {
        return fecha.get();
    }

    public ObjectProperty<Date> fechaProperty() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha.set(fecha);
    }



    public String getCiudad() {
        return ciudad.get();
    }

    public StringProperty ciudadProperty() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad.set(ciudad);
    }

    public String getSitio() {
        return sitio.get();
    }

    public StringProperty sitioProperty() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio.set(sitio);
    }

    public String getObservaciones() {
        return observaciones.get();
    }

    public StringProperty observacionesProperty() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones.set(observaciones);
    }

    public double getArea() {
        return area.get();
    }

    public DoubleProperty areaProperty() {
        return area;
    }

    public void setArea(double area) {
        this.area.set(area);
    }

    public String getuMedida() {
        return uMedida.get();
    }

    public StringProperty uMedidaProperty() {
        return uMedida;
    }

    public void setuMedida(String uMedida) {
        this.uMedida.set(uMedida);
    }

    public int getCantDepoBuenEstado() {
        return cantDepoBuenEstado.get();
    }

    public IntegerProperty cantDepoBuenEstadoProperty() {
        return cantDepoBuenEstado;
    }

    public void setCantDepoBuenEstado(int cantDepoBuenEstado) {
        this.cantDepoBuenEstado.set(cantDepoBuenEstado);
    }

    public int getCantDepoMalEstado() {
        return cantDepoMalEstado.get();
    }

    public IntegerProperty cantDepoMalEstadoProperty() {
        return cantDepoMalEstado;
    }

    public void setCantDepoMalEstado(int cantDepoMalEstado) {
        this.cantDepoMalEstado.set(cantDepoMalEstado);
    }

    public double getCod() {
        return cod.get();
    }

    public DoubleProperty codProperty() {
        return cod;
    }

    public void setCod(double cod) {
        this.cod.set(cod);
    }

    public int getNivelContaminacion() {
        return nivelContaminacion.get();
    }

    public IntegerProperty nivelContaminacionProperty() {
        return nivelContaminacion;
    }

    public void setNivelContaminacion(int nivelContaminacion) {
        this.nivelContaminacion.set(nivelContaminacion);
    }

    public String getResultado() {
        return resultado.get();
    }

    public StringProperty resultadoProperty() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado.set(resultado);
    }

    @Override
    public String toString() {
        return "Estudio{" +
                "fecha=" + fecha +
                ", ciudad=" + ciudad +
                ", sitio=" + sitio +
                ", observaciones=" + observaciones +
                ", area=" + area +
                ", uMedida=" + uMedida +
                ", cantDepoBuenEstado=" + cantDepoBuenEstado +
                ", cantDepoMalEstado=" + cantDepoMalEstado +
                ", cod=" + cod +
                ", nivelContaminacion=" + nivelContaminacion +
                ", resultado=" + resultado +
                '}';
    }

    public void saveStudy(){

    }
    public void updateStudy(){

    }
    public void deleteStudy(){

    }
    public ArrayList<Estudio> searchAllStudy(Integer id){
        return null;
    }
    public List<Estudio> searchStudy(){
        return null;
    }
}
