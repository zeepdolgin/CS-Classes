import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public interface Admin_Interface {
	public abstract Course New_Course(String course_Name, String course_Id, String maximum_Students,
			 String instructor, String course_Section, String course_Location, ArrayList<Course> cl);
	public abstract void Write_File(ArrayList<Course> cl) throws FileNotFoundException, UnsupportedEncodingException; // Method to write a file to full courses.
	public abstract void Delete_Course(ArrayList <Course> c, String s); // Method to delete a course.
	public abstract void Edit_Course(ArrayList <Course> c); // Method to edit a course.
	public abstract void Display_Course(String CourseName, ArrayList <Course> c); // Method to display info course info by id.
	public static void Register_Student(ArrayList<Student> sl, String firstname, String lastname){} // Method to register a student with username and password.
    public void View_Full_Courses(ArrayList<Course> cl); // Method to view all courses that are full.
	public abstract void View_Students_In_Course(ArrayList <Course> cl, String course); // Method to view all students registered in a given course.
	public void View_CourseManagement();  // Method to print out course management menu.
	public void View_Reports(); // Method to print out reports menu.
    public void Sort(ArrayList<Course> cl); // Method to sort the courses by the number of registered students.
}
	
	
