import java.util.ArrayList;


public class Student extends User implements Student_Interface {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<String> Courses = new ArrayList<>();

    // No-args constructor:
	public Student(){
		super();
	}

    // Full args constructor
	public Student (String firstName, String lastName, String username, String password){	
		super(username, password, firstName, lastName);
	}
	
    // Method to get courses that student is registered in:
	public void getCourses(){
		System.out.println(this.getFirstName() + " " + this.getLastName() + " is enrolled in the following courses:");
		for (String x: this.Courses){
			System.out.println(x);
		}
    }

	// Method to view courses that are not full
	public void View_Open_Courses(ArrayList<Course> cl){
		System.out.println("The following courses are not full: ");
        System.out.printf("%-45s", ("| " + "Course Name "));
		System.out.printf("%-20s", ("| " + "Course Id "));
		System.out.printf("%-20s", ("| " + "Maximum Students "));
		System.out.printf("%-15s", ("| " + "Current Students "));
		System.out.printf("%-10s", ("| " + "Students Registered "));
		System.out.printf("%-25s", ("| " + "Course Instructor "));
		System.out.printf("%-8s", ("| " + "Section Number "));
		System.out.print(" | " + "Course Location");
		System.out.println();
		for (int i = 0; i < cl.size(); i++){
			Course c = cl.get(i);
			if (c.getCurrent_Students() < c.getMaximum_Students()){
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
	}
	
	// Method to drop a course:
	public void Drop_Course(ArrayList <Course> cl, Student s, String course, String section){
		for (int i = 0; i < cl.size(); i++){
			Course c = cl.get(i);
			if (c.getCourse_Name().equalsIgnoreCase(course) && c.getCourse_Section().equalsIgnoreCase(section)){
				c.delete_Student(s);		
				Courses.remove(course);
                System.out.println("You have succesfully dropped from " + c.getCourse_Name());
			}
		}
	}

    // Method to register for a course:
	public void  Register(Student name, ArrayList <Course> cl, String course, String section ){
		for(int i = 0; i < cl.size(); i++){
			Course c = cl.get(i);
			if(c.getCourse_Name().equalsIgnoreCase(course) && c.getCourse_Section().equals(section)){
				Courses.add(course);
				c.add_Student(name);
            }
		}	
	}

    // Method to print out student menu.
	public void View_Student_Menu(){
		System.out.println("1. View all courses.");
		System.out.println("2. View all courses that are not FULL.");
		System.out.println("3. Register for a course.");
		System.out.println("4. Withdraw from a course.");
		System.out.println("5. View all current courses.");
		System.out.println("6. Exit.");
	}

	public void withdraw(String cn){
		Courses.remove(cn);
	}
}
