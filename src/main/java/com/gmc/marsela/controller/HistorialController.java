package com.gmc.marsela.controller;

import com.gmc.marsela.entity.Estudio;
import com.gmc.marsela.util.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class HistorialController implements Initializable {

    //Componentes GUI
        @FXML private TableView<Estudio> tblViewEstudios;
        @FXML private TableColumn<Estudio, String> colCiudad;
        @FXML private TableColumn<Estudio, String> colSitio;
        @FXML private TableColumn<Estudio, Double> colArea;
        @FXML private TableColumn<Estudio, Date> colFecha;


    //Colecciones
    private ObservableList<Estudio> listaEstudio;

    private DbConnection conexion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       //Abrir Conexion a la BD
        conexion = new DbConnection();
        conexion.establecerConnection();

        //Inicializar Lista
        listaEstudio = FXCollections.observableArrayList(); //Modo de instanciar un Observable

        //Llenar Tabla Historial
        //Estudio.getAllStudy(conexion.getConnection(), listaEstudio);//Metodo estatico

        //Enlazar Lista con TableVIew
        tblViewEstudios.setItems(listaEstudio);

        //Enlazar Clumnas de TableView con atributos
        colCiudad.setCellValueFactory(new PropertyValueFactory<Estudio, String>("ciudad"));
        colSitio.setCellValueFactory(new PropertyValueFactory<Estudio, String>("sitio"));
        colArea.setCellValueFactory(new PropertyValueFactory<Estudio, Double>("area"));
        colFecha.setCellValueFactory(new PropertyValueFactory<Estudio, Date>("fecha"));

        //Cerrar conexión ala BD
        conexion.closeConnection();


    }
}
