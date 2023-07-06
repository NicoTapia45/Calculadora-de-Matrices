import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Esta es la implementación de la interfaz OperacionesMatriz.
 * Implementa los métodos de suma, resta, multiplicación e inversa de matrices.
 */
public class OperacionesMatrizImpl implements OperacionesMatriz {
    private Matriz matriz;

    public OperacionesMatrizImpl(Matriz matriz) {
        this.matriz = matriz;
    }

    @Override
    public Matriz sumar(Matriz otra) {
        int filas = matriz.obtenerNumeroFilas();
        int columnas = matriz.obtenerNumeroColumnas();
        Matriz resultado = new Matriz(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                double valor = matriz.obtener(i, j) + otra.obtener(i, j);
                resultado.establecer(i, j, valor);
            }
        }
        return resultado;
    }

    @Override
    public Matriz restar(Matriz otra) {
        int filas = matriz.obtenerNumeroFilas();
        int columnas = matriz.obtenerNumeroColumnas();
        Matriz resultado = new Matriz(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                double valor = matriz.obtener(i, j) - otra.obtener(i, j);
                resultado.establecer(i, j, valor);
            }
        }
        return resultado;
    }

    @Override
    public Matriz multiplicar(Matriz otra) {
        int filas = matriz.obtenerNumeroFilas();
        int columnas = otra.obtenerNumeroColumnas();
        Matriz resultado = new Matriz(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                double valor = 0;
                for (int k = 0; k < matriz.obtenerNumeroColumnas(); k++) {
                    valor += matriz.obtener(i, k) * otra.obtener(k, j);
                }
                resultado.establecer(i, j, valor);
            }
        }
        return resultado;
    }

    @Override
    public Matriz inversa() {
        Matriz inversa = null;
        try {
            double determinante = matriz.determinante();
            if (determinante == 0) {
                throw new IllegalArgumentException("La matriz no tiene inversa.");
            }

            Matriz cofactores = matriz.cofactores();
            Matriz adjunta = cofactores.transpuesta();

            inversa = new Matriz(matriz.obtenerNumeroFilas(), matriz.obtenerNumeroColumnas());
            for (int i = 0; i < matriz.obtenerNumeroFilas(); i++) {
                for (int j = 0; j < matriz.obtenerNumeroColumnas(); j++) {
                    inversa.establecer(i, j, adjunta.obtener(i, j) / determinante);
                }
            }
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return inversa;
    }
}
