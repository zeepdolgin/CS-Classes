import java.util.ArrayList;

public class Student extends User implements StudentInterface {
	// No arg-constructor
	public Student() {
	}

	// Constructor with all arguments
	public Student(String First_Name, String Last_Name, String Password, String User_Name) {
		this.first_name = First_Name;
		this.last_name = Last_Name;
		this.password = Password;
		this.username = User_Name;
		this.student_cources = new ArrayList<String>();
	}

	// Methods that are available to Students
	// 1. View all courses (overwriting the method view_all_courses(), from the
	// class User, as students are not supposed to see who is registered to what
	// course)
	public void view_all_courses() {
		System.out.println("Displaying information for all cources: ");
		Course_data all_data = new Course_data();
		all_data.format_Data();
		all_data.print_courses_info_for_students();
	}

	// 2. View all courses that are not full
	public void viewNotFull() {
		System.out.println("Displaying all courses that are not full: ");
		Course_data all_data = new Course_data();
		all_data.format_Data();
		all_data.print_all_not_full_courses_info();
	}

	// 3. Register in a course (student must enter the course name, section, the
	// name of the logged in student will be added to the appropriate course)
	public void registerForCourse() {
		Scanner scan = new Scanner(System.in);
		Course_data all_data = new Course_data();
		all_data.format_Data();
		System.out.println("Registering for a course");
		System.out.println("Enter Course Name: ");
		String Course_Name = scan.nextLine();
		System.out.println("Enter Section Number: ");
		int Section_Number = scan.nextInt();
		// get the name and the last name of the student who is registering for a course
		String F_Name = this.first_name;
		String L_Name = this.last_name;
		all_data.add_student_to_cours(Course_Name, Section_Number, F_Name, L_Name);
		all_data.write_to_file();
	}

	// 4. Withdraw from a course (in this case the student will be asked to enter
	// the course name, then the name of the student will be taken off from the
	// given course)
	public void dropCourse() {
		Scanner scan = new Scanner(System.in);
		Course_data all_data = new Course_data();
		all_data.format_Data();
		System.out.println("Withdrawing for a course");
		System.out.println("Enter Course Name: ");
		String Course_Name = scan.nextLine();
		System.out.println("Enter Section Number: ");
		int Section_Number = scan.nextInt();
		// get the name and the last name of the student who is registering for a course
		String F_Name = this.first_name;
		String L_Name = this.last_name;
		all_data.delete_student_from_course(Course_Name, Section_Number, F_Name, L_Name);
		all_data.write_to_file();

	}

	// 5. View all courses that the current student is registered in
	public void viewAllRegClasses() {
		Course_data all_data = new Course_data();
		all_data.format_Data();
		// get the name and the last name of the student who is registering for a course
		String F_Name = this.first_name;
		String L_Name = this.last_name;
		all_data.show_student_courses(F_Name, L_Name);
	}

	// 6. Exit
	public void exit() {
	}
} // end of Student class    
    

    
}
