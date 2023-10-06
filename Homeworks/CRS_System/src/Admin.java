import java.util.Scanner;

public class Admin extends User implements AdminInterface {
    Scanner scan = new Scanner(System.in);

	// constructor for an Admin
	public Admin(String First_Name, String Last_Name, String Password, String User_Name) {
		this.first_name = First_Name;
		this.last_name = Last_Name;
		this.password = Password;
		this.username = User_Name;
	}

	// 1.Create a new course
	public void createCourse() {
		Scanner scan = new Scanner(System.in);
		Course_ata all_data = new Course_data();
		all_data.format_Data();
		System.out.println("Creating a new course");
		System.out.println("Enter Course Name: ");
		String Course_Name = scan.nextLine();
		System.out.println("Enter Course ID: ");
		String Course_Id = scan.nextLine();
		System.out.println("Enter Course Instructor Name: ");
		String Course_Instructor = scan.nextLine();
		System.out.println("Enter Course Location: ");
		String Location = scan.nextLine();
		System.out.println("Enter Maximum number of students: ");
		int Max_Numb_Of_Students = scan.nextInt();
		System.out.println("Enter Curent number of students");
		int Cur_Number_Of_Students = scan.nextInt();
		ArrayList<String> Students_Registered_In_Course = new ArrayList<String>();

		System.out.println("Enter Section Number: ");
		int Section_Number = scan.nextInt();

		Course newcourse = new Course(Course_Name, Course_Id, Max_Numb_Of_Students, Cur_Number_Of_Students,
				Course_Instructor, Section_Number, Location, Students_Registered_In_Course);
		all_data.add_course(newcourse);
		all_data.write_to_file();
	}

	// 2.Delete a course
	public void deleteCourse() {
		Scanner scan = new Scanner(System.in);
		Course_data all_data = new Course_data();
		all_data.format_Data();
		System.out.println("Deleting a course");
		System.out.println("Enter Course Name: ");
		String Course_Name = scan.nextLine();
		System.out.println("Enter Section Number: ");
		int Section_Number = scan.nextInt();
		all_data.delete_cours(Course_Name, Section_Number);
		all_data.write_to_file();
	}

	// 3.Edit a course (this will allow the Admin to edit any information on the
	// course except for course ID and name)
	public void editCourse() {
		Scanner scan = new Scanner(System.in);
		Course_data all_data = new Course_data();
		all_data.format_Data();
		System.out.println("Editing course");
		System.out.println("Enter Course Name: ");
		String Course_Name = scan.nextLine();
		System.out.println("Enter Section Number: ");
		int Section_Number = scan.nextInt();
		all_data.edit_cours(Course_Name, Section_Number);
		all_data.write_to_file();
	}

	// 4.Display information for a given course (by course ID)
	public void displayInfo() {
		System.out.println("Displaying information for a given course");
		Scanner scan = new Scanner(System.in);
		Course_data all_data = new Course_data();
		all_data.format_Data();
		System.out.println("Enter Course Name: ");
		String Course_Name = scan.nextLine();
		System.out.println("Enter Section Number: ");
		int Section_Number = scan.nextInt();
		all_data.print_course_info(Course_Name, Section_Number);
	}

	// 5.Register a student (this option will allow the Admin to add a student
	// without assigning to a course)
	public void registerStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Registering a new student");
		System.out.println("Enter student first name: ");
		String S_F_Name = scan.nextLine();
		System.out.println("Enter student last name: ");
		String S_L_Name = scan.nextLine();
		System.out.println("Enter student username: ");
		String S_U_Name = scan.nextLine();
		System.out.println("Enter student password: ");
		String S_Password = scan.nextLine();
		ArrayList<String> empty_array = new ArrayList<String>(1);
		Student student1 = new Student(S_F_Name, S_L_Name, S_Password, S_U_Name);

		Student_List new_student_list = new Student_List();
		new_student_list.format_Student_Data();
		new_student_list.addStudent(student1);
		new_student_list.write_to_StudentData_file();
	}

	// 7.View all courses that are FULL (reached the maximum number of students)
	public void viewFullCourses() {
		System.out.println("Displaying all courses that are full");
		Course_data all_data = new Course_data();
		all_data.format_Data();
		all_data.print_all_full_courses_info();
	}

	// 8.Write to a file the list of course that are full
	public void writeFull() {
		System.out.println("Writing out the list of all courses that are full to a new file");
		Course_data all_data = new Course_data();
		all_data.format_Data();
		all_data.write_full_courses_to_file();
	}

	// 9.View the names of the students that are registered in a specific course
	public void viewCourseStudents() {
		System.out.println("Printing out the names of all students that are registered in a given course");
		Scanner scan = new Scanner(System.in);
		Course_data all_data = new Course_data();
		all_data.format_Data();
		System.out.println("Enter Course Name: ");
		String Course_Name = scan.nextLine();
		System.out.println("Enter Section Number: ");
		int Section_Number = scan.nextInt();
		all_data.print_student_info_of_course(Course_Name, Section_Number);
	}

	// 10.View the list of courses that a given student is registered in (the system
	// shall display all the courses that logged-in student is registered in)
	public void viewStudentsCourses() {
		System.out.println("Printing out the Courses that a given student is taking");
		Scanner scan = new Scanner(System.in);
		Course_data all_data = new Course_data();
		all_data.format_Data();
		System.out.println("Enter Student Name: ");
		String F_Name = scan.nextLine();
		System.out.println("Enter Student Last Name: ");
		String L_Name = scan.nextLine();
		all_data.show_student_courses(F_Name, L_Name);
	}

	// 11. Sort the courses based on the current number of students registered (from
	// smallest number to the greatest number)
	public void sortByReg() {
		System.out.println("Sorting courses based on the number of students taking them");
		Course_data all_data = new Course_data();
		all_data.format_Data();
		all_data.print_sorted_courses();
	}

	// 12. Exit
	public void exit() {
		System.out.println("Exiting the program");
		System.exit(0);
	}

}