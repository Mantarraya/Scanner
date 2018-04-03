package Scanner;

import java.util.ArrayList;

import static Scanner.Scanner.*;

public class Prueba {

    public static void main(String[] args) {
        
        // Codigo de Archivo Fuente
        String input = "if (aux1 >= 3123.4) {mayor23 = 4123};";
        
        // Identificamos los tokens(lexemas) del codigo
        ArrayList<Token> tokens = identificarTokens(input);
        
        System.out.println("Codigo Fuente: " + input + "\n");
        // Imprimimos todos los tokens encontrados
        for (Token token : tokens) {
            System.out.printf("%-20s : %-10s\n",token.getTipo(), token.getValor() );
        }
    }

}
