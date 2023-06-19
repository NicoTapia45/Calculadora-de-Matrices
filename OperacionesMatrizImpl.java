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
}

