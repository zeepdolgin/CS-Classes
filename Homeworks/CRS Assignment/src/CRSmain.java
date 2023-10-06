//import java.io to serialize data
import java.io.*;
// import the scanner
import java.util.*;

public class CRSmain {

	public static void main(String[] args) {
		System.out.println(" ____________________________________________");
		System.out.println("|                                            |");
		System.out.println("| Welcome to the Cource Registration System! |"); // Welcome the user
		System.out.println("|____________________________________________|");
		System.out.println("");

		// 1. ASK USER IF HE IS ADMIN OR A STUDENT (Req. 10)
		int student_or_admin = determineUser();
		// 2. Follow different steps depending on user status:
		do {
			switch (student_or_admin) {
			case 1: // If user is a Student
				Scanner scan = new Scanner(System.in);
				System.out.println("You are a student, program works in Student mode");
				System.out.println("Time to log in as a Student");
				System.out.println("Please, enter username: ");
				String student_name = scan.nextLine();
				Student acting_student = checkStudent(student_name);

				if (acting_student.username.equals(student_name)) {
					StudentToolKit(acting_student);
				} else {
					System.out.println("you are not loged in");
				}
				break;
			case 2: // If user is an Admin
				System.out.println("You are an admin, program works in Admin mode");
				System.out.println("Time to log in as an Admin");
				boolean admin_loged_in = checkAmdmin();
				// once Admin has loged in, provide access to all the Admin Methods
				if (admin_loged_in) {
					AdminToolKit();

				} else {
					System.out.println("you are not loged in");
				}

				break;
			default:
				System.out.println("\nThe input is invalid, please choose between 1, 2, 3, 4, or 5");
				System.out.println("");
			}
		} while (student_or_admin != 0);
	}// end of main

	// ------------------------------------
	// Methods used in main
	// Method that gives students the ability to act
	public static void StudentToolKit(Student a) {
		Student acting_student = a;
		// 1. Create scanner
		Scanner scan = new Scanner(System.in);
		// 2. Display student menu
		printStudentMenue();
		// 3. Based on users choice - perform different tasks
		System.out.println("What would you like to do? Enter 1, 2, 3, 4, 5 or 6 to quit:");
		int userChoice;
		userChoice = 0;
		// Execution based on the users input
		do {
			userChoice = scan.nextInt();
			switch (userChoice) {

			case 1:
				acting_student.view_all_courses();
				printStudentMenue();
				break;
			case 2:
				acting_student.viewNotFull();
				printStudentMenue();
				break;
			case 3:
				acting_student.registerForCourse();
				printStudentMenue();
				break;
			case 4:
				acting_student.dropCourse();
				printStudentMenue();
				break;
			case 5:
				System.out.println("\nPrinting out all the courses you are regestered in");
				acting_student.viewAllRegClasses();
				printStudentMenue();
				break;
			case 6:
				System.out.println("\nThank you for using this program!");
				System.out.println("____________________________________________________________________________");
				System.exit(0);
				break;
			default:
				System.out.println("\nThe input is invalid, please choose between 1, 2, 3, 4, 5, or 6");
				System.out.println("");
			}
		} while (userChoice != 6);
	}

	// Method that gives admins the ability to act
	public static void AdminToolKit() {
		// 1. Create scanner
		Scanner scan = new Scanner(System.in);
		// 2. Create a new object of class User, with properties of an Admin (Req. 07)
		System.out.println("Please, enter your First Name");
		String First_Name = scan.next();
		System.out.println("Please, enter your Last Name");
		String Last_Name = scan.next();
		Admin acting_admin = new Admin(First_Name, Last_Name, "Admin001", "Admin");
		// 3. Display the menu to an Admin
		printAdminMenue();
		// 4. Based on users choice - perform different tasks
		System.out.println("What would you like to do? Enter 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 or 12 to quit:");
		int userChoice;
		userChoice = 0;
		// Execution based on the users input
		do {
			userChoice = scan.nextInt();
			switch (userChoice) {

			case 1:
				acting_admin.createCourse();
				printAdminMenue();
				break;
			case 2:
				acting_admin.deleteCourse();
				printAdminMenue();
				break;
			case 3:
				acting_admin.editCourse();
				printAdminMenue();
				break;
			case 4:
				acting_admin.displayInfo();
				printAdminMenue();
				break;
			case 5:
				acting_admin.registerStudent();
				printAdminMenue();
				break;
			case 6:
				acting_admin.view_all_courses();
				printAdminMenue();
				break;
			case 7:
				acting_admin.viewFullCourses();
				printAdminMenue();
				break;
			case 8:
				acting_admin.writeFull();
				printAdminMenue();
				break;
			case 9:
				acting_admin.viewCourseStudents();
				printAdminMenue();
				break;
			case 10:
				acting_admin.viewStudentsCourses();
				printAdminMenue();
				break;
			case 11:
				acting_admin.sortByReg();
				printAdminMenue();
				break;
			case 12:
				acting_admin.exit();
				System.out.println("_____________________________________________________________________");
				break;
			default:
				System.out.println(
						"\nThe input is invalid, please choose between 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 or 12 to quit:");
				System.out.println("");
			}
		} while (userChoice != 12);
	}

	// Method to determine User type (Admin or Student)
	public static int determineUser() {
		// 1. Create scanner
		Scanner scan = new Scanner(System.in);
		int user_status = 0;
		System.out.println("Please, press 1 if you are Student or 2 if you are an Administraitor: ");
		// 2. Scan the first input and keep asking for integers until user puts 1 or 2
		user_status = scan.nextInt();
		while (!((user_status == 1) || (user_status == 2))) {
			System.out.println("Please, try again, enter either '1' for student or '2' for administrator: ");
			user_status = scan.nextInt();
		}
		System.out.println("Thank you for pressing " + user_status);
		return user_status;
	}

	// Method to check password and username for Admin
	public static boolean checkAmdmin() {
		boolean access = false;
		Scanner scan = new Scanner(System.in);
		while (access == false) {
			System.out.println("Please, enter username: ");
			String username = scan.nextLine();
			System.out.println("Please, enter password: ");
			String password = scan.nextLine();
			// As professor said in class, we only have 1 Admin and when user logs in as
			// Admin for the first time, he needs to enter "Admin" for the user name and
			// "Admin001" for the password
			if (username.equals("Admin") && password.equals("Admin001")) {
				access = true;
				System.out.println("Successful Log-in!");
			} else {
				access = false;
				System.out.println("Wrong Password, try again");
			}
		}
		return access;
	}

	// Method to check password and username for student (this method compares the
	// username logged in with the data stored in the file studentData. if username				!!!!!!!!!!!!!
	// and password match, the access is granted
	public static Student checkStudent(String studentname) {
		Student_List All_Students = new Student_List();
		All_Students.readFromStudentDataFile();
		All_Students.format_Student_Data();
		Scanner scan = new Scanner(System.in);
		Student acting_student = new Student();
		boolean access = false;
		while (access == false) {
			String username = studentname;
			System.out.println("Please, enter password: ");
			String password = scan.nextLine();
			for (int i = 0; i < All_Students.All_Student.size(); i++) {
				if (username.equals(All_Students.All_Student.get(i).username)
						&& password.equals(All_Students.All_Student.get(i).password)) {
					acting_student = new Student(All_Students.All_Student.get(i).first_name,
							All_Students.All_Student.get(i).last_name, All_Students.All_Student.get(i).password,
							All_Students.All_Student.get(i).username);
					access = true;
					System.out.println("Successful Log-in!");
					return acting_student;
				}
			}
		}
		return acting_student;
	}

	// Method to printout Student Menu
	public static void printStudentMenue() {
		System.out.println("");
		System.out.println("_____________________________________________________________________");
		System.out.println("");
		System.out.println("                        STUDENT MENUE:");
		System.out.println("1 - View all courses");
		System.out.println("2 - View all courses that are not full");
		System.out.println("3 - Register in a course");
		System.out.println("4 - Withdraw from a course");
		System.out.println("5 - View all courses that the current student is registered in");
		System.out.println("6 - Quit the program");
		System.out.println("_____________________________________________________________________");
		System.out.println("");
	}

	// Method to print out Administrator Menu
	public static void printAdminMenue() {
		System.out.println("");
		System.out.println("_____________________________________________________________________");
		System.out.println("");
		System.out.println("                        ADMINISTRAITOR MENUE:");
		System.out.println("1 - Create a new course");
		System.out.println("2 - Delete a course");
		System.out.println("3 - Edit a course");
		System.out.println("4 - Display information for a given course (by course ID)");
		System.out.println("5 - Register a student");
		System.out.println("6 - View all courses");
		System.out.println("7 - View all courses that are FULL");
		System.out.println("8 - Write to a file the list of course that are full");
		System.out.println("9 - View the names of the students that are registered in a specific course");
		System.out.println("10 - View the list of courses that a given student is registered in");
		System.out.println("11 - Sort the courses based on the current number of students registered");
		System.out.println("12 - Exit the program");
		System.out.println("_____________________________________________________________________");
		System.out.println("");
	}
	// end of Methods
	// ------------------------------------

} // end of CRSmain