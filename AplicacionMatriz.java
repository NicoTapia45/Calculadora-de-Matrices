import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AplicacionMatriz extends Application {
    private PanelMatriz panelMatrizA;
    private PanelMatriz panelMatrizB;

    @Override
    public void start(Stage primaryStage) {
        panelMatrizA = new PanelMatriz();
        panelMatrizB = new PanelMatriz();

        Button botonSumar = new Button("Sumar");
        Button botonRestar = new Button("Restar");
        Button botonMultiplicar = new Button("Multiplicar");
        Button botonInversa = new Button("Inversa");

        TextArea areaResultado = new TextArea();
        areaResultado.setPrefRowCount(10); // make the text area larger

        botonSumar.setOnAction(e -> {
            OperacionesMatriz operaciones = new OperacionesMatrizImpl(panelMatrizA.getMatriz());
            Matriz resultado = operaciones.sumar(panelMatrizB.getMatriz());
            areaResultado.setText(resultado.toString());
        });

        botonRestar.setOnAction(e -> {
            OperacionesMatriz operaciones = new OperacionesMatrizImpl(panelMatrizA.getMatriz());
            Matriz resultado = operaciones.restar(panelMatrizB.getMatriz());
            areaResultado.setText(resultado.toString());
        });

        botonMultiplicar.setOnAction(e -> {
            OperacionesMatriz operaciones = new OperacionesMatrizImpl(panelMatrizA.getMatriz());
            Matriz resultado = operaciones.multiplicar(panelMatrizB.getMatriz());
            areaResultado.setText(resultado.toString());
        });

        botonInversa.setOnAction(e -> {
            OperacionesMatriz operaciones = new OperacionesMatrizImpl(panelMatrizA.getMatriz());
            Matriz resultado = operaciones.inversa();
            if (resultado != null) {
                areaResultado.setText(resultado.toString());
            }
        });

        HBox hBox = new HBox(panelMatrizA, panelMatrizB);
        hBox.setSpacing(10); // add some space between the matrix panels

        HBox botones = new HBox(botonSumar, botonRestar, botonMultiplicar, botonInversa);
        botones.setSpacing(10); // add some space between the buttons

        VBox raiz = new VBox(hBox, botones, areaResultado);
        raiz.setPadding(new Insets(10)); // add some padding around the VBox
        raiz.setSpacing(10); // add some space between the VBox's children

        Scene scene = new Scene(raiz);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculadora de Matrices");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
