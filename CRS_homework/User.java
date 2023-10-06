import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
	private String password;
	private String FirstName;
	private String LastName;

    // No-arg constructor
	public User(){
		this.username = "";
        this.password = "";
        this.FirstName = "";
        this.LastName = "";
	}

    // Full Constructor:
	public User(String username, String password, String firstName, String lastName){
		this.username = username;
		this.password = password;
		this.FirstName = firstName;
		this.LastName = lastName;
	}

    // Getters and Setters
    public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getFirstName(){
		return FirstName;
	}
	public void setFirstName(String firstName){
		FirstName = firstName;
	}
	public String getLastName(){
		return LastName;
	}
	public void setLastName(String lastName){
		LastName = lastName;
	}
	

	//view all courses
	public static void View_Courses (ArrayList <Course> courses){
        System.out.printf("%-45s", ("| " + "Course Name "));
		System.out.printf("%-20s", ("| " + "Course Id "));
		System.out.printf("%-20s", ("| " + "Maximum Students "));
		System.out.printf("%-15s", ("| " + "Current Students "));
		System.out.printf("%-10s", ("| " + "Students Registered "));
		System.out.printf("%-25s", ("| " + "Course Instructor "));
		System.out.printf("%-8s", ("| " + "Section Number "));
		System.out.print(" | " + "Course Location");
		System.out.println();
		for (int i = 0; i < courses.size(); i++){
			Course c = courses.get(i);
			System.out.printf("%-45s", ("| " + c.getCourse_Name()));
            System.out.printf("%-20s", ("| " + c.getCourse_Id()));
            System.out.printf("%-20s", ("| " + c.getMaximum_Students()));
            System.out.printf("%-19s", ("| " + c.getCurrent_Students()));
            System.out.printf("%-22s", ("| " + c.getStudent_Names()));
            System.out.printf("%-25s", ("| " + c.getInstructor()));
            System.out.printf("%-17s", ("| " + c.getCourse_Section()));
            System.out.println(" | " + c.getCourse_Location());
            System.out.println();
		}
	}
		
	//view list of courses student is in
	public void View_Student_Course(String Firstname, String Lastname, ArrayList <Student> sl){
        boolean student_found = false;
		for (Student s : sl){
			String first_name = s.getFirstName();
			String last_name = s.getLastName();
			if (first_name.equalsIgnoreCase(Firstname) && last_name.equalsIgnoreCase(Lastname)){
				s.getCourses();
                student_found = true;
			}	
		}
        if(!student_found){
            System.out.println("Student with the given name is not registered in the CRS yet.");
        }
	}
}