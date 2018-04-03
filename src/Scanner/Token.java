package Scanner;

/* Esta clase permitira administrar y almacenar los tokens(lexemas) */
public class Token {

    /* Atributos */
    private Tipos tipo;
    private String valor;

    /* Definiremos los tipos del token */
    enum Tipos {

        NumeroEntero("^[0-9]*$"), // todas las posibles combinaciones de numeros enteros
        NumeroReal("^[0-9]*\\.[0-9]+$"),
        OperadorAritmetico("[*|/|+|-]"),
        OperadorAsignacion("[=]"),
        OperadorComparacion("[<|>|>=|<=|==]"),
        PalabraReservada("do|while|for|if|DO|WHILE|FOR|IF|true|false|TRUE|FALSE"),
        OperadorAgrupacion("[(|)|{|}]"),
        Identificador("^[a-zA-Z]+[a-zA-Z0-9]*$"),
        Delimitador("[;]");

        /* 
           Averiguar todas las formas de identificar un tipo de lexema
           tales como un numero real, identificar con letras y numeros, etc ...
         */
        
        public final String patron;

        Tipos(String s) {
            this.patron = s;
        }

    }

    // Metodos Getter
    public Tipos getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    // Metodos Setter
    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
