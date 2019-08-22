/*
 * Crear un programa que genere un cuadrado mágico en una matriz cuadrada de orden N donde
 * N es impar positivo mayor o igual a 3. Considerar los siguientes pasos
 * a. El primer valor (1) se ingresa el centro de la primera fila
 * b. El siguiente valor se ingresa en la fila anterior y columna posterior
 * c. Si el valor ingresado es múltiplo de N entonces el siguiente valor se coloca en la misma
 * columna y la siguiente fila.
 * d. Considerar que si la fila anterior no existe se debe usar la última fila y que si la columna
 * posterior no existe entonces se debe usar la primera columna.
 */
package com.fxcompany.ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author fx
 */
public class CuadroMagico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaracion e inicializacion
        Scanner sc = new Scanner(System.in);
        int N = 3;
        int[][] CM;

        System.out.println("***Cuadro Magico***");
        //manejando posible error en la captura de un entero
        try {
            //repitiendo la peticion si hay un ingreso diferente al solicitado
            do {
                System.out.print("\nIngrese el orden del cuadro magico, debe ser un entero impar mayor o igual a 3: ");
                N = sc.nextInt();
            } while (N % 2 == 0 | N < 3);
        } catch (NumberFormatException | InputMismatchException ex) {
            System.err.println(ex.getMessage());
        }
        /*creando la matriz cuadrada
          tomando en cuanta que el valor por defecto del
          tipo de dato int es cero no es necesario setear a cero cada elemento
          de la matriz*/
        CM = new int[N][N];
        //el objeto matriz se pasa a un metodo de llenado del cuadro magico
        llenarCuadroMagico(CM, N);
        //imprime el cuadro magico
        System.out.println("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%10d",CM[i][j]);
            }
            System.out.println("");
        }
        
    }

    //metodo de llenado del cuadro magico, recibe como parametro la matriz y el orden
    private static void llenarCuadroMagico(int CM[][], int N) {
        //seteando el primer valor en el centro del cuadro de la primer fila
        int fila = 0;
        int col = (N - 1) / 2;
        CM[fila][col] = 1;

        int n = 2;
        while (n <= N * N) {
            //verificando si el numero anterior es multiplo de N
            if (n >= N & (n - 1) % N == 0) {
                if (fila == N - 1)
                    fila = 0;
                else 
                    fila++;                
            } else {
                if (isPrimerFila(fila))
                    fila = N - 1;
                else
                    fila--;                
                if (isUltimaColumna(col, N))
                    col = 0;
                else
                    col++;
            }
            CM[fila][col] = n;
            n++;
        }
    }
        //metodo de comprobacion de primer fila
    private static boolean isPrimerFila(int fila) {
        return (fila - 1) < 0;
    }

    //metodo de comprobacion de primer fila
    private static boolean isUltimaColumna(int col, int N) {
        return (col + 1) == N;
    }

}
