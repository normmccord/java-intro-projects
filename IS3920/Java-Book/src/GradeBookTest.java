//GradeBookTest.java
//GradeBook lessons


public class GradeBookTest {
    public static void main(String[] args) {

        //create GradeBook Object
        GradeBook gradeBook1 = new GradeBook(
                "CS101 Introduction to Java Programming");
        GradeBook gradeBook2 = new GradeBook(
                "CS102 Data Structures in Java");

        //display initial value of course name for each GradeBook
        System.out.printf("\ngradeBook1 course name is: %s\n", gradeBook1.getCourseName());
        System.out.printf("gradeBook2 course name is: %s\n", gradeBook2.getCourseName());


    }//end main
}//end class GradeBookTest
