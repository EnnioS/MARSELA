package com.gmc.marsela.entity;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Estudio {
/*
    private IntegerProperty id;
    private ObjectProperty<Date> fecha;
    private StringProperty ciudad;
    private StringProperty sitio;
    private StringProperty observaciones;

    private DoubleProperty area;
    private IntegerProperty uMedida;
    private IntegerProperty cantDepoBuenEstado;
    private IntegerProperty cantDepoMalEstado;
    private DoubleProperty cod;
    private IntegerProperty nivelContaminacion;
    private StringProperty resultado;
    private StringProperty sugerencia;

    public Estudio(Integer id, Date fecha, String ciudad, String sitio, String observaciones, Double area, Integer uMedida, Integer cantDepoBuenEstado, Integer cantDepoMalEstado, Double cod, Integer nivelContaminacion, String resultado, String sugerencia) {

        this.id                 = new SimpleIntegerProperty(id);
        this.fecha              = new SimpleObjectProperty<Date>(fecha);
        this.ciudad             = new SimpleStringProperty(ciudad);
        this.sitio              = new SimpleStringProperty(sitio);
        this.observaciones      = new SimpleStringProperty(observaciones);
        this.area               = new SimpleDoubleProperty(area);
        this.uMedida            = new SimpleIntegerProperty(uMedida);
        this.cantDepoBuenEstado = new SimpleIntegerProperty(cantDepoBuenEstado);
        this.cantDepoMalEstado  = new SimpleIntegerProperty(cantDepoMalEstado);
        this.cod                = new SimpleDoubleProperty(cod);
        this.nivelContaminacion = new SimpleIntegerProperty(nivelContaminacion);
        this.resultado          = new SimpleStringProperty(resultado);
        this.sugerencia         = new SimpleStringProperty(sugerencia);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

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

    public int getuMedida() {
        return uMedida.get();
    }

    public IntegerProperty uMedidaProperty() {
        return uMedida;
    }

    public void setuMedida(int uMedida) {
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

    public String getSugerencia() {
        return sugerencia.get();
    }

    public StringProperty sugerenciaProperty() {
        return sugerencia;
    }

    public void setSugerencia(String sugerencia) {
        this.sugerencia.set(sugerencia);
    }

    public void saveStudy(){

    }
    public void updateStudy(){

    }
    public void deleteStudy(){

    }
    public static void getAllStudy(Connection connection, ObservableList<Estudio> lista){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(
                    "Select * from estudios"
            );
            while(resultado.next()){
                lista.add(new Estudio(resultado.getInt("id"),
                        resultado.getDate("fecha"),
                        resultado.getString("ciudad"),
                        resultado.getString("sitio"),
                        resultado.getString("observaciones"),
                        resultado.getDouble("area"),
                        resultado.getInt("uMedida"),
                        resultado.getInt("cantDepoBuenEstado"),
                        resultado.getInt("cantDepoMalEstado"),
                        resultado.getDouble("cod"),
                        resultado.getInt("nivelContaminacion"),
                        resultado.getString("resultado"),
                        resultado.getString("sugerencia")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Estudio> searchStudy(Integer id){
        return null;
    }*/
}
