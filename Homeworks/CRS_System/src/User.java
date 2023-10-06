import java.util.ArrayList;

public class User {
    // User Class variables
	String first_name, last_name, password, username;
	ArrayList<String> student_cources;

	// no-arg construstor
	public User() {
		first_name = "";
		last_name = "";
		password = "";
		username = "";
	}

	// normal constructors
	public User(String First_Name, String Last_Name, String Password, String User_Name) {
		this.first_name = First_Name;
		this.last_name = Last_Name;
		this.password = Password;
		this.username = User_Name;
	}

	// a method that allows Admin to view all courses (should be №6, but students
	// also have this method so it is not listed under Admin options. Student class
	// will overwrite this method)
	public void view_all_courses() {
		
		// printout line by line all the courses, and all the info described above.
	}
    
}

