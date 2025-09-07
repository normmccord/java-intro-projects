public class GradeBook {
    private String courseName; //instance variable: course name for this GradeBook

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
