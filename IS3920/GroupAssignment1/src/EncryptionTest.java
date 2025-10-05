import java.util.Scanner;

public class EncryptionTest {

    private static void printMenu() {
        System.out.println("1 - Encrypt");
        System.out.println("2 - Decrypt");
        System.out.println("3 - Exit");
        System.out.println();
        System.out.print("Enter choice ");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Encryption enc = new Encryption();

        while(true) {
            printMenu();
            String choice = input.nextLine().trim();
            System.out.println(); // trying to match the screenshots in the instructions as much as possible

            //Validate Choice
            if (!(choice.equals("1") || choice.equals("2") || choice.equals("3"))) {
                System.out.println("Error: Please enter valid input");
                System.out.println();
                continue; // re-display the menu
            }

            //Process Valid Choices
            switch (choice) {
                case "1" -> {
                    //Encrypt
                    System.out.print("Enter the plain text message:\n");
                    String plain = input.nextLine();
                    String encrypted = enc.encrypt(plain);
                    System.out.println();
                    System.out.println("Encrypted Msg: " + encrypted);
                    System.out.println();
                }
                
                case "2" -> {
                    //Decrypt
                    System.out.print("Enter the encrypted message:\n");
                    String cipher = input.nextLine();
                    String decrypted = enc.decrypt(cipher);
                    System.out.println();
                    System.out.println("Decrypted Msg: " + decrypted);
                    System.out.println();
                }

                case "3" -> {
                    //Exit
                    input.close();
                        return; // exit main method
                    }
                }
            }
        }
    }