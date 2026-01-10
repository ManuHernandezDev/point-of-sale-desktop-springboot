package com.michingon.point_of_sale.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

import com.michingon.point_of_sale.dto.ProductResponse;
import com.michingon.point_of_sale.service.ProductService;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Component
@RequiredArgsConstructor
public class ProductFxController implements Initializable {

    private final ProductService productService;

    @FXML
    private TableView<ProductResponse> tablaProductos;
    @FXML
    private TableColumn<ProductResponse, Long> colId;
    @FXML
    private TableColumn<ProductResponse, String> colBarcode;
    @FXML
    private TableColumn<ProductResponse, String> colName;
    @FXML
    private TableColumn<ProductResponse, BigDecimal> colPrice;
    @FXML
    private TableColumn<ProductResponse, String> colDescription;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureColumns();
        loadingData();
    }

    private void configureColumns() {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBarcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        colId.prefWidthProperty().bind(tablaProductos.widthProperty().multiply(0.10));
        colBarcode.prefWidthProperty().bind(tablaProductos.widthProperty().multiply(0.20));
        colName.prefWidthProperty().bind(tablaProductos.widthProperty().multiply(0.20));
        colDescription.prefWidthProperty().bind(tablaProductos.widthProperty().multiply(0.30));
        colPrice.prefWidthProperty().bind(tablaProductos.widthProperty().multiply(0.20));
    }

    @FXML
    public void loadingData() {
        List<ProductResponse> listProducts = productService.getAllProducts();
        ObservableList<ProductResponse> dataProducts = FXCollections.observableArrayList(listProducts);
        tablaProductos.setItems(dataProducts);

        System.out.println("Data load in the table of products.");
    }
}