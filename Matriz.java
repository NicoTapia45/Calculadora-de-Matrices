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

    public double determinante() {
        if (elementos.length != elementos[0].length) {
            throw new IllegalArgumentException("La matriz no es cuadrada.");
        }

        if (elementos.length > 3) {
            throw new IllegalArgumentException("El cálculo del determinante solo está implementado para matrices de hasta 3x3.");
        }

        return calcularDeterminante(elementos);
    }

    private double calcularDeterminante(double[][] matriz) {
        double resultado = 0;

        if (matriz.length == 1) {
            resultado = matriz[0][0];
        } else if (matriz.length == 2) {
            resultado = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        } else if (matriz.length == 3) {
            resultado = matriz[0][0] * (matriz[1][1] * matriz[2][2] - matriz[1][2] * matriz[2][1]) -
                    matriz[0][1] * (matriz[1][0] * matriz[2][2] - matriz[1][2] * matriz[2][0]) +
                    matriz[0][2] * (matriz[1][0] * matriz[2][1] - matriz[1][1] * matriz[2][0]);
        }

        return resultado;
    }

    public Matriz cofactores() {
        if (elementos.length != elementos[0].length) {
            throw new IllegalArgumentException("La matriz no es cuadrada.");
        }

        if (elementos.length > 3) {
            throw new IllegalArgumentException("El cálculo de los cofactores solo está implementado para matrices de hasta 3x3.");
        }

        Matriz cofactores = new Matriz(elementos.length, elementos[0].length);

        for (int i = 0; i < elementos.length; i++) {
            for (int j = 0; j < elementos[0].length; j++) {
                double[][] submatriz = new double[elementos.length - 1][elementos[0].length - 1];
                int fila = 0;
                for (int x = 0; x < elementos.length; x++) {
                    if (x == i) {
                        continue;
                    }
                    int columna = 0;
                    for (int y = 0; y < elementos[0].length; y++) {
                        if (y == j) {
                            continue;
                        }
                        submatriz[fila][columna] = elementos[x][y];
                        columna++;
                    }
                    fila++;
                }
                cofactores.establecer(i, j, Math.pow(-1, i + j) * calcularDeterminante(submatriz));
            }
        }

        return cofactores;
    }

    public Matriz transpuesta() {
        Matriz transpuesta = new Matriz(elementos[0].length, elementos.length);
        for (int i = 0; i < elementos.length; i++) {
            for (int j = 0; j < elementos[0].length; j++) {
                transpuesta.establecer(j, i, obtener(i, j));
            }
        }
        return transpuesta;
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
