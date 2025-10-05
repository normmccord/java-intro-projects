/*
Group 6: Erik Gijlstra, Aniel Granados, Prisca Louis, Norman McCord
 */
import java.util.ArrayList;
import java.util.Locale;

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

    //1)
    public char return_alphabet(int index) {
        return alphabets.get(index);
    }

    //2)
    public int return_alphabet_index(char letter) {
        return alphabets.indexOf(letter);
    }

    //3)
    public char return_symbol(int index) {
        return symbols.get(index);
    }

    //4)
    public int return_symbol_index(char symbol) {
        return symbols.indexOf(symbol);
    }

    //5)
    public String encrypt(String plainText){
        plainText = plainText.toLowerCase();
        String encrypted = "";
        for (char i : plainText.toCharArray()){
            int index = alphabets.indexOf(i);
            if (index == -1) {
                return "Error: Invalid Character"; // no trailing period
            }
            char encryptedChar = symbols.get(index);
            encrypted += encryptedChar;
        }
        return encrypted;
    }

    //6)
    public String decrypt(String codeText){
        String decrypted = "";
        for (char i : codeText.toCharArray()){
            int index = symbols.indexOf(i);
            if (index == -1){
                return "Error: Invalid Symbol"; // no trailing period
            }
            char decryptedChar = alphabets.get(index);
            decrypted += decryptedChar;
        }
        return decrypted;
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
        System.out.println("Symbol at index 0: " + e.return_symbol(0));
        System.out.println("Symbol at index 1: " + e.return_symbol(1));
        System.out.println("Symbol at index 5: " + e.return_symbol(5));
        System.out.println("Index of symbol !: " + e.return_symbol_index('!'));
        System.out.println("Index of symbol @: " + e.return_symbol_index('@'));

        System.out.println();
        System.out.println("Encrypting 'Elvis'...");
        System.out.println(e.encrypt("Elvis"));

        System.out.println();
        System.out.println("Decrypting ' )!@#$% '...");
        System.out.println(e.decrypt(")!@#$%"));

        System.out.println();
        System.out.println("Decrypting ' )!@#$ '...");
        System.out.println(e.decrypt(")!@#$"));
    }

}