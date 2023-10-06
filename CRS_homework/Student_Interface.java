import java.util.ArrayList;

public interface Student_Interface{

    public void getCourses(); //Method to get the courses that student is registered in.
	public void View_Open_Courses(ArrayList<Course> cl); // Method to view courses that are not full.
   	public void Drop_Course(ArrayList <Course> cl, Student s, String course, String section); // Method to withdraw from a course.
	public void Register(Student name, ArrayList <Course> cl, String course, String section ); // Method to register for a course.
    public void View_Student_Menu(); // Method to print out student menu.
    public void withdraw(String cn); // Method to delete student from the list of students taking the course.
}
