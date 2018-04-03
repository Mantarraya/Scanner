package Scanner;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Scanner.Token.Tipos;

public class Scanner {

    public static ArrayList<Token> identificarTokens(String input) {


        final ArrayList<Token> tokens = new ArrayList<Token>();
        int j = 0; // contador de la cantidad de caracteres de la cadena input
        
        //System.out.println("Codigo fuente = "  + input);
        
        // Recorreremos el input por tokens
        while (j < (input.length())) {
            StringBuilder palabra = new StringBuilder();
            
            //Ignorar espacios en blanco
            while (j+1 < input.length() && input.charAt(j) == ' ' ){
                j++;
            }

            char c = input.charAt(j);
            
            // Verificamos si el primer caracter es una letra -> (palabra reservada, identificador ...)
            if (Character.isLetter(c)){ 
                while (Character.isLetter(c) || Character.isDigit(c)){
                    palabra.append(c);
                    if (j+1 != input.length())
                        j++;
                    else 
                        break;
                    c = input.charAt(j);
                }                  
                
            }
            // Verificamos si el primer caracter es un digito -> ( entero, real)
            else if (Character.isDigit(c)){ 
                while (Character.isDigit(c) || c == '.'){
                    palabra.append(c);
                    if (j+1 != input.length())
                        j++;
                    else 
                        break;
                    c = input.charAt(j);
                }
            } 
            // Verificamos si es un operador u otro ...
            else { //if (c==',' || c=='(' || c==')' || c=='=' || c=='*' || c=='/' || c=='-' || c=='+' || c=='<' || c=='>' || c==';')
        
                palabra.append(c);
                
                if (j+1 > input.length())
                        break;
                
                if ((c == '-' && input.charAt(j+1) == '-') ||
                    (c == '+' && input.charAt(j+1) == '+') ||
                    (c == '<' && input.charAt(j+1) == '=') ||
                    (c == '>' && input.charAt(j+1) == '=')){
                    palabra.append(input.charAt(j+1));
                    j++;
                    
                }
                j++;
                
            }
              
            //System.out.println("Palabra = " + palabra);

            boolean matched = false;
            
            // Verificamos que tipo de token es
            for (Tipos tokenTipo : Tipos.values()) {
                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher matcher = patron.matcher(palabra.toString());
                if (matcher.find()) {
                    Token tokenAux = new Token();
                    tokenAux.setTipo(tokenTipo);
                    tokenAux.setValor(palabra.toString());
                    tokens.add(tokenAux);
                    matched = true;
                    break;
                }
            }

            // Si el token no se encuentra en la clase Token, imprimimos mensaje de error
            if (!matched) {
                System.out.println("Se encontro un token invalido: " + palabra);
            }
        }

        return tokens;
    }


}
