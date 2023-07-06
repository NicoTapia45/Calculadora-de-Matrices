/**
 * Esta interfaz define las operaciones que se pueden realizar en una matriz.
 * Estas operaciones incluyen suma, resta, multiplicación e inversa.
 */
public interface OperacionesMatriz {
    Matriz sumar(Matriz otra);
    Matriz restar(Matriz otra);
    Matriz multiplicar(Matriz otra);
    Matriz inversa();
}


