/*
Group 6: Erik Gijlstra, Aniel Granados, Prisca Louis, Norman McCord
 */
import java.util.ArrayList;

class Encryption {
    ArrayList<Character> symbols = new ArrayList<Character>();
    ArrayList<Character> alphabets = new ArrayList<Character>();
    public Encryption() {
        symbols.add('!');
        symbols.add('@');
        symbols.add('#');
        symbols.add('$');
        symbols.add('^');
        symbols.add('&');
        symbols.add('*');
        symbols.add('(');
        symbols.add(')');
        symbols.add('_');
        symbols.add('-');
        symbols.add('+');
        symbols.add('=');
        symbols.add('?');
        symbols.add(',');
        symbols.add('{');
        symbols.add('}');
        symbols.add('[');
        symbols.add(']');
        symbols.add('/');
        symbols.add('|');
        symbols.add(';');
        symbols.add(':');
        symbols.add('.');
        symbols.add('<');
        symbols.add('>');
        for(char letter = 'a'; letter <= 'z'; letter++) {
            alphabets.add(letter);
        }
    }

    public char return_alphabet(int index) {
        return alphabets.get(index);
    }

    public int return_alphabet_index(char letter) {
        return alphabets.indexOf(letter);
    }

    public char return_symbol(int index) {
        return symbols.get(index);
    }

    public int return_symbol_index(char symbol) {
        return symbols.indexOf(symbol);
    }

    //This is just for testing the methods.  Comment out or remove before submission.
    public static void main(String[] args) {
        Encryption e = new Encryption();

        System.out.println();
        System.out.println("Alphabet list:");
        System.out.println(e.alphabets);

        System.out.println("\nSymbol list:");
        System.out.println(e.symbols);

        System.out.println();
        System.out.println("Symbol at index 5: " + e.return_symbol(5));
        System.out.println("Index of symbol *: " + e.return_symbol_index('*'));
    }

}