//GradeBook.java
//GradeBook class with a constructor to initialize the course name.

public class GradeBook {
    private String courseName; //instance variable: course name for this GradeBook

    //constructor initializes courseName with String argument
    public GradeBook( String name ){
        courseName = name; //initializes courseName
    }//end constructor

    //method to set course name: Setter
    public void setCourseName( String name ){ //'name' of type String
        courseName = name; //store the course name
    }//end method setCourseName

    //method to get (retrieve) the course name: Getter
    public String getCourseName(){
        return courseName;
    }//end method getCourseName

    public void displayMessage() {
        // Display a welcome message
        System.out.printf("Welcome to the grade book for\n%s!\n", getCourseName());
    }
}
