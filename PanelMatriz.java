import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Esta clase representa un panel para la entrada de matrices en la interfaz de usuario.
 * Proporciona una interfaz gráfica para que el usuario introduzca los valores de la matriz y obtenga la matriz resultante.
 */
public class PanelMatriz extends GridPane {
    private TextField[][] campos;

    public PanelMatriz() {
        campos = new TextField[3][3];  // Cambia el tamaño según sea necesario

        for (int i = 0; i < campos.length; i++) {
            for (int j = 0; j < campos[0].length; j++) {
                campos[i][j] = new TextField();
                this.add(campos[i][j], j, i);
            }
        }
    }

    public Matriz getMatriz() {
        Matriz matriz = new Matriz(campos.length, campos[0].length);
        for (int i = 0; i < campos.length; i++) {
            for (int j = 0; j < campos[0].length; j++) {
                matriz.establecer(i, j, Double.parseDouble(campos[i][j].getText()));
            }
        }
        return matriz;
    }
}
