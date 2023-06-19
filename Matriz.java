public class Matriz {
    private final double[][] elementos;

    public Matriz(int filas, int columnas) {
        this.elementos = new double[filas][columnas];
    }

    public double obtener(int fila, int columna) {
        return elementos[fila][columna];
    }

    public void establecer(int fila, int columna, double valor) {
        elementos[fila][columna] = valor;
    }

    public int obtenerNumeroFilas() {
        return elementos.length;
    }

    public int obtenerNumeroColumnas() {
        return elementos[0].length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] fila : elementos) {
            for (double valor : fila) {
                sb.append(valor).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}

