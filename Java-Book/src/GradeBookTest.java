import java.util.Scanner;

public class GradeBookTest {
    public static void main(String[] args) {
        // create a scanner to get input
        Scanner input = new Scanner(System.in);

        //create a GradeBook object  and assign it to myGradeBook
        GradeBook myGradeBook = new GradeBook();

        //display initial value of course name
        System.out.printf("Initial course name is: %s\n\n", myGradeBook.getCourseName());

        //prompt for and input course name
        System.out.println("Please enter a course name: ");
        String theName = input.nextLine(); //read a line of text
        myGradeBook.setCourseName(theName); // sets the course name
        System.out.println(); //just outputs a blank line

        //call myGradeBook's displayMessage method
        //and pass nameOfCourse as an argument
        myGradeBook.displayMessage();

    }//end main
}//end class GradeBookTest
