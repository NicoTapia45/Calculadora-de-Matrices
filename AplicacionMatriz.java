import javafx.application.Application;
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

        TextArea areaResultado = new TextArea();

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

        VBox raiz = new VBox(
                new HBox(panelMatrizA, panelMatrizB),
                new HBox(botonSumar, botonRestar, botonMultiplicar),
                areaResultado
        );

        primaryStage.setScene(new Scene(raiz));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
