import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// this class is an important one as it has methods that allow Admins and Students to interact with data stored in the crsData file 
public class Course_data {
	ArrayList<Course> All_Cources = new ArrayList<Course>();

	// no-arg constructor
	Course_data() {
		All_Cources = new ArrayList<Course>();
	}

	// ------------------------------------
	// Methods to manage Data:
	// Method to format the Data and store it in a matrix of separate words
	public void format_Data() {
		// 1. store all data into an ArrayList of ArrayLists, where each sub-ArrayList
		// holds words from the text file
		ArrayList<ArrayList<String>> all_data = storeData();
		// 2. print the data out just to see if it works.
		// printDataOut(all_data);
		// 3. using all stored data, create courses as objects and store them into an
		// ArrayList.
		// ArrayList<Course> All_Cources = new ArrayList<Course>();
		int number_of_courses = all_data.size(); // as the first line is a header
		for (int i = 1; i < number_of_courses; i++) {
			String Course_Name = all_data.get(i).get(0);
			String Course_Id = all_data.get(i).get(1);
			int Max_Numb_Of_Students = Integer.parseInt(all_data.get(i).get(2));
			int Cur_Number_Of_Students = Integer.parseInt(all_data.get(i).get(3));

			ArrayList<String> Students_Registered_In_Course = new ArrayList<String>();

			String raw_names_string = all_data.get(i).get(4);
			String clean_nemes_string = raw_names_string.replace("[", "").replace("]", "").replace("NULL", "");

			String[] Students = clean_nemes_string.split("!");
			for (int j = 0; j < Students.length; j++) {
				Students_Registered_In_Course.add(Students[j]);
			}

			String Course_Instructor = all_data.get(i).get(5);
			int Section_Number = Integer.parseInt(all_data.get(i).get(6));
			String Location = all_data.get(i).get(7);
			// create an oblect
			Course course = new Course(Course_Name, Course_Id, Max_Numb_Of_Students, Cur_Number_Of_Students,
					Course_Instructor, Section_Number, Location, Students_Registered_In_Course);
			All_Cources.add(course);
		}
	}

	// Method to print all data
	public void print_all() {
		System.out.printf("%-45s", ("|  " + "Course_Name"));
		System.out.printf("%-20s", (" | " + "Course_Id"));
		System.out.printf("%-25s", (" | " + "Maximum_Students"));
		System.out.printf("%-24s", (" | " + "Current_Students"));
		System.out.printf("%-20s", (" | " + "List_Of_Names"));
		System.out.printf("%-28s", ("|  " + "Course_Instructor"));
		System.out.printf("%-28s", ("|  " + "Course_Section_Number"));
		System.out.print(" | " + "Course_Location");
		System.out.println();
		for (int i = 0; i < All_Cources.size(); i++) {
			System.out.printf("%-45s", ("|  " + All_Cources.get(i).course_name));
			System.out.printf("%-20s", (" | " + All_Cources.get(i).course_id));
			System.out.printf("%-25s", (" | " + All_Cources.get(i).max_numb_of_students));
			System.out.printf("%-24s", (" | " + All_Cources.get(i).cur_number_of_students));
			System.out.printf("%-20s", (" | " + All_Cources.get(i).students_registered_in_course));
			System.out.printf("%-28s", ("|  " + All_Cources.get(i).course_instructor));
			System.out.printf("%-28s", ("|  " + All_Cources.get(i).section_number));
			System.out.print(" | " + All_Cources.get(i).location);
			System.out.println();
		}
	}

	// Method to save all data into a file (Start point)
	public void write_to_file() {
		String fileName = "crsData2.csv";
		Scanner scan = new Scanner(System.in);

		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(
					"Course_Name,Course_Id,Maximum_Students,Current_Students,List_Of_Names,Course_Instructor,Course_Section_Number,Course_Location");
			bufferedWriter.newLine();
			for (int i = 0; i < All_Cources.size(); i++) {
				String course_students = "[";
				for (int d = 0; d < All_Cources.get(i).students_registered_in_course.size(); d++) {
					if ((!(All_Cources.get(i).students_registered_in_course.get(d).equals("NULL")))
							&& (!(All_Cources.get(i).students_registered_in_course.get(d).equals("!")))
							&& (!(All_Cources.get(i).students_registered_in_course.get(d).equals("")))) {
						course_students = course_students + All_Cources.get(i).students_registered_in_course.get(d)
								+ "!";
					}
				}
				course_students = course_students + "]";
				String text = (All_Cources.get(i).course_name + "," + All_Cources.get(i).course_id + ","
						+ All_Cources.get(i).max_numb_of_students + "," + All_Cources.get(i).cur_number_of_students
						+ "," + course_students + "," + All_Cources.get(i).course_instructor + ","
						+ All_Cources.get(i).section_number + "," + All_Cources.get(i).location);
				bufferedWriter.write(text);
				bufferedWriter.newLine();
			}

			// Always close writer
			bufferedWriter.close();
		}

		catch (IOException exk) {
			System.out.println("Error writing file '" + fileName + "'");
			exk.printStackTrace();
		}
	}

	// Method to Store Data that was read from the file
	public static ArrayList<ArrayList<String>> storeData() {
		// Create an ArrayList of lines that were read from the file
		ArrayList<String> List_of_Lines = readFromFile();

		ArrayList<ArrayList<String>> ArrList_Of_ArrList_Of_Words = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < List_of_Lines.size(); i++) {
			String[] each_word = List_of_Lines.get(i).split(",");
			// Temporary arrList
			ArrayList<String> a1 = new ArrayList<String>();
			for (int j = 0; j <= (each_word.length) - 1; j++) {
				a1.add(each_word[j]);
			}
			ArrList_Of_ArrList_Of_Words.add(a1);
		}
		return ArrList_Of_ArrList_Of_Words;
	}

	// Method to Read from the file
	public static ArrayList<String> readFromFile() {
		String fileName = "crsData2.csv";
		// References one line at a time
		String line = null;
		try {
			// FileReader reads text files as characters as opposed to bytes (like
			// FileInputStream)
			// First, we instantiate the file reader class
			// It's parameter would be the name of the file to read (in this case, the
			// string variable which represents the file name);

			FileReader fileReader = new FileReader(fileName);

			// The BufferedReader class can wrap around Readers, like FileReader, to buffer
			// the input and improve efficiency.
			// ALWAYS wrap FileReader in BufferedReader

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// readLine() reads a line of text.
			// A line is considered to be terminated by a new line ('\n'). So Buffered
			// reader would literally read line by line.
			// While there are still lines to read, our program will print the file
			// Create an Array List of Array list that would hold the text data and keep the
			// structure of it.
			ArrayList<String> ArrayList_of_lines = new ArrayList<String>();
			while ((line = bufferedReader.readLine()) != null) {
				ArrayList_of_lines.add(line);
				// System.out.println(line);
			}

			// Always close files
			bufferedReader.close();
			return ArrayList_of_lines;
		}
		// The catch block performs a specific action depending on the exception
		catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
			// the printStackTrace method will print out an error output stream ("What went
			// wrong?" report);

			ArrayList<String> empty_array = new ArrayList<String>();
			ex.printStackTrace();
			return empty_array;
		}

		catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			ArrayList<String> empty_array = new ArrayList<String>();
			ex.printStackTrace();
			return empty_array;
		}
	}

	// Method to write-out all full courses into a new file
	public void write_full_courses_to_file() {
		String fileName = "fullCourses.txt";
		Scanner scan = new Scanner(System.in);

		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Printed out all cources that are full");
			bufferedWriter.newLine();
			bufferedWriter.write(
					"Course_Name,Course_Id,Maximum_Students,Current_Students,List_Of_Names,Course_Instructor,Course_Section_Number,Course_Location");
			bufferedWriter.newLine();
			for (int i = 0; i < All_Cources.size(); i++) {
				if (All_Cources.get(i).cur_number_of_students == All_Cources.get(i).max_numb_of_students) {
					String text = (All_Cources.get(i).course_name + "," + All_Cources.get(i).course_id + ","
							+ All_Cources.get(i).max_numb_of_students + "," + All_Cources.get(i).cur_number_of_students
							+ "," + All_Cources.get(i).students_registered_in_course + ","
							+ All_Cources.get(i).course_instructor + "," + All_Cources.get(i).section_number + ","
							+ All_Cources.get(i).location);
					bufferedWriter.write(text);
					bufferedWriter.newLine();
				}
			}

			// Always close writer
			bufferedWriter.close();
		}

		catch (IOException exk) {
			System.out.println("Error writing file '" + fileName + "'");
			exk.printStackTrace();
		}
	}
	// ------------------------------------

	// ------------------------------------
	// Methods used by Admin:
	// Method to edit courses
	public void edit_cours(String Course_Name, int Section_Number) {
		for (int i = 0; i < All_Cources.size(); i++) {
			if ((All_Cources.get(i).course_name.equals(Course_Name))
					&& (All_Cources.get(i).section_number == Section_Number)) {

				Scanner scan = new Scanner(System.in);
				System.out.println("Enter NEW Course Instructor Name: ");
				String Course_Instructor = scan.nextLine();
				All_Cources.get(i).course_instructor = Course_Instructor;
				System.out.println("Enter NEW Course Location: ");
				String Location = scan.nextLine();
				All_Cources.get(i).location = Location;
				System.out.println("Enter NEW Maximum number of students: ");
				int Max_Numb_Of_Students = scan.nextInt();
				All_Cources.get(i).max_numb_of_students = Max_Numb_Of_Students;
				System.out.println("Enter NEW Curent number of students");
				int Cur_Number_Of_Students = scan.nextInt();
				All_Cources.get(i).cur_number_of_students = Cur_Number_Of_Students;
				System.out.println("Enter NEW Section Number: ");
				int S_Number = scan.nextInt();
				All_Cources.get(i).section_number = S_Number;
			}
		}
	}

	// Method to delete courses
	public void delete_cours(String Course_Name, int Section_Number) {
		for (int i = 0; i < All_Cources.size(); i++) {
			if ((All_Cources.get(i).course_name.equals(Course_Name))
					&& (All_Cources.get(i).section_number == Section_Number)) {
				All_Cources.remove(All_Cources.get(i));
			}
		}
	}

	// Method to add course
	public void add_course(Course a) {
		All_Cources.add(a);
	}

	// Method to Print 1 Course INFO
	public void print_course_info(String Course_Name, int Section_Number) {
		boolean course_exists = true;
		System.out.printf("%-45s", ("|  " + "Course_Name"));
		System.out.printf("%-20s", (" | " + "Course_Id"));
		System.out.printf("%-25s", (" | " + "Maximum_Students"));
		System.out.printf("%-24s", (" | " + "Current_Students"));
		System.out.printf("%-20s", (" | " + "List_Of_Names"));
		System.out.printf("%-28s", ("|  " + "Course_Instructor"));
		System.out.printf("%-28s", ("|  " + "Course_Section_Number"));
		System.out.print(" | " + "Course_Location");
		System.out.println();
		for (int i = 0; i < All_Cources.size(); i++) {
			if ((All_Cources.get(i).course_name.equals(Course_Name))
					&& (All_Cources.get(i).section_number == Section_Number)) {

				System.out.printf("%-45s", ("|  " + All_Cources.get(i).course_name));
				System.out.printf("%-20s", (" | " + All_Cources.get(i).course_id));
				System.out.printf("%-25s", (" | " + All_Cources.get(i).max_numb_of_students));
				System.out.printf("%-24s", (" | " + All_Cources.get(i).cur_number_of_students));
				System.out.printf("%-20s", (" | " + All_Cources.get(i).students_registered_in_course));
				System.out.printf("%-28s", ("|  " + All_Cources.get(i).course_instructor));
				System.out.printf("%-28s", ("|  " + All_Cources.get(i).section_number));
				System.out.print(" | " + All_Cources.get(i).location);
				System.out.println();
				course_exists = false;
			}
		}
		if (course_exists) {
			System.out.println("Course '" + Course_Name + "' was not found");
		}
	}

	// Print student list for a Course
	public void print_student_info_of_course(String Course_Name, int Section_Number) {
		boolean course_exists = true;
		System.out.printf("%-45s", ("|  " + "Course_Name"));
		System.out.printf("%-20s", (" | " + "Course_Id"));
		System.out.printf("%-28s", ("|  " + "Course_Section_Number"));
		System.out.printf("%-50s", (" | " + "List_Of_Names"));
		System.out.println();
		for (int i = 0; i < All_Cources.size(); i++) {
			if ((All_Cources.get(i).course_name.equals(Course_Name))
					&& (All_Cources.get(i).section_number == Section_Number)) {

				System.out.printf("%-45s", ("|  " + All_Cources.get(i).course_name));
				System.out.printf("%-20s", (" | " + All_Cources.get(i).course_id));
				System.out.printf("%-28s", ("|  " + All_Cources.get(i).section_number));
				System.out.printf("%-20s", (" | " + All_Cources.get(i).students_registered_in_course));
				System.out.println();
				course_exists = false;
			}
		}
		if (course_exists) {
			System.out.println("Course '" + Course_Name + "' was not found");
		}
	}

	// Print information about all course
	public void print_all_courses_info() {

		System.out.printf("%-45s", ("|  " + "Course Name"));
		System.out.printf("%-20s", (" | " + "Course Id"));
		System.out.printf("%-25s", (" | " + "Maximum Students"));
		System.out.printf("%-24s", (" | " + "Current Students"));
		System.out.printf("%-55s", (" | " + "List Of Names"));
		System.out.printf("%-28s", ("|  " + "Course Instructor"));
		System.out.printf("%-28s", ("|  " + "Course Section_Number"));
		System.out.print(" | " + "Course Location");
		System.out.println();
		for (int i = 0; i < All_Cources.size(); i++) {
			System.out.printf("%-45s", ("|  " + All_Cources.get(i).course_name));
			System.out.printf("%-20s", (" | " + All_Cources.get(i).course_id));
			System.out.printf("%-25s", (" | " + All_Cources.get(i).max_numb_of_students));
			System.out.printf("%-24s", (" | " + All_Cources.get(i).cur_number_of_students));
			System.out.printf("%-55s", (" | " + All_Cources.get(i).students_registered_in_course));
			System.out.printf("%-28s", ("|  " + All_Cources.get(i).course_instructor));
			System.out.printf("%-28s", ("|  " + All_Cources.get(i).section_number));
			System.out.print(" | " + All_Cources.get(i).location);
			System.out.println();
		}
	}

	// Method to print out courses sorted by the number of current students from
	// samples to largest
	public void print_sorted_courses() {
		System.out.printf("%-45s", ("|  " + "Course_Name"));
		System.out.printf("%-20s", (" | " + "Course_Id"));
		System.out.printf("%-25s", (" | " + "Maximum_Students"));
		System.out.printf("%-24s", (" | " + "Current_Students"));
		System.out.printf("%-55s", (" | " + "List_Of_Names"));
		System.out.printf("%-28s", ("|  " + "Course_Instructor"));
		System.out.printf("%-28s", ("|  " + "Course_Section_Number"));
		System.out.print(" | " + "Course_Location");
		System.out.println();
		int min = 0;
		int counter = 0;
		while (counter < All_Cources.size()) {
			for (int j = 0; j < All_Cources.size(); j++) {
				if (All_Cources.get(j).cur_number_of_students == min) {
					System.out.printf("%-45s", ("|  " + All_Cources.get(j).course_name));
					System.out.printf("%-20s", (" | " + All_Cources.get(j).course_id));
					System.out.printf("%-25s", (" | " + All_Cources.get(j).max_numb_of_students));
					System.out.printf("%-24s", (" | " + All_Cources.get(j).cur_number_of_students));
					System.out.printf("%-55s", (" | " + All_Cources.get(j).students_registered_in_course));
					System.out.printf("%-28s", ("|  " + All_Cources.get(j).course_instructor));
					System.out.printf("%-28s", ("|  " + All_Cources.get(j).section_number));
					System.out.print(" | " + All_Cources.get(j).location);
					System.out.println();
					counter = counter + 1;
				}
			}
			min = min + 1;
		}
	}

	// Print information about all FULL course
	public void print_all_full_courses_info() {
		System.out.printf("%-45s", ("|  " + "Course_Name"));
		System.out.printf("%-20s", (" | " + "Course_Id"));
		System.out.printf("%-25s", (" | " + "Maximum_Students"));
		System.out.printf("%-24s", (" | " + "Current_Students"));
		System.out.printf("%-20s", (" | " + "List_Of_Names"));
		System.out.printf("%-28s", ("|  " + "Course_Instructor"));
		System.out.printf("%-28s", ("|  " + "Course_Section_Number"));
		System.out.print(" | " + "Course_Location");
		System.out.println();
		for (int i = 0; i < All_Cources.size(); i++) {
			if (All_Cources.get(i).cur_number_of_students == All_Cources.get(i).max_numb_of_students) {

				System.out.printf("%-45s", ("|  " + All_Cources.get(i).course_name));
				System.out.printf("%-20s", (" | " + All_Cources.get(i).course_id));
				System.out.printf("%-25s", (" | " + All_Cources.get(i).max_numb_of_students));
				System.out.printf("%-24s", (" | " + All_Cources.get(i).cur_number_of_students));
				System.out.printf("%-20s", (" | " + All_Cources.get(i).students_registered_in_course));
				System.out.printf("%-28s", ("|  " + All_Cources.get(i).course_instructor));
				System.out.printf("%-28s", ("|  " + All_Cources.get(i).section_number));
				System.out.print(" | " + All_Cources.get(i).location);
				System.out.println();
			}
		}
	}
	// ------------------------------------

	// ------------------------------------
	// Methods used by Students:
	// Method to add students to a courses
	public void add_student_to_cours(String Course_Name, int Section_Number, String F_name, String L_name) {
		for (int i = 0; i < All_Cources.size(); i++) {
			if ((All_Cources.get(i).course_name.equals(Course_Name))
					&& (All_Cources.get(i).section_number == Section_Number)) {
				All_Cources.get(i).students_registered_in_course.add(F_name + " " + L_name); // +"!"
				All_Cources.get(i).cur_number_of_students = All_Cources.get(i).cur_number_of_students + 1;
			}
		}
	}

	// Method to delete student from a courses
	public void delete_student_from_course(String Course_Name, int Section_Number, String F_name, String L_name) {
		for (int i = 0; i < All_Cources.size(); i++) {
			if ((All_Cources.get(i).course_name.equals(Course_Name))
					&& (All_Cources.get(i).section_number == Section_Number)) {
				All_Cources.get(i).students_registered_in_course.remove(F_name + " " + L_name);
				if (All_Cources.get(i).cur_number_of_students > 0) {
					All_Cources.get(i).cur_number_of_students = All_Cources.get(i).cur_number_of_students - 1;
				}
			}
		}
	}

	// Method to pint information for students about all course (without printing
	// the list of
	// students that take each course)
	public void print_courses_info_for_students() {
		System.out.printf("%-45s", ("|  " + "Course_Name"));
		System.out.printf("%-20s", (" | " + "Course_Id"));
		System.out.printf("%-25s", (" | " + "Maximum_Students"));
		System.out.printf("%-24s", (" | " + "Current_Students"));
		System.out.printf("%-28s", ("|  " + "Course_Instructor"));
		System.out.printf("%-28s", ("|  " + "Course_Section_Number"));
		System.out.print(" | " + "Course_Location");
		System.out.println();
		for (int i = 0; i < All_Cources.size(); i++) {
			System.out.printf("%-45s", ("|  " + All_Cources.get(i).course_name));
			System.out.printf("%-20s", (" | " + All_Cources.get(i).course_id));
			System.out.printf("%-25s", (" | " + All_Cources.get(i).max_numb_of_students));
			System.out.printf("%-24s", (" | " + All_Cources.get(i).cur_number_of_students));
			System.out.printf("%-28s", ("|  " + All_Cources.get(i).course_instructor));
			System.out.printf("%-28s", ("|  " + All_Cources.get(i).section_number));
			System.out.print(" | " + All_Cources.get(i).location);
			System.out.println();
		}
	}

	// Method to print all courses student is registered for
	public void show_student_courses(String F_Name, String L_Name) {
		System.out.printf("%-45s", ("|  " + "Course_Name"));
		System.out.printf("%-20s", (" | " + "Course_Id"));
		System.out.printf("%-25s", (" | " + "Maximum_Students"));
		System.out.printf("%-24s", (" | " + "Current_Students"));
		System.out.printf("%-28s", ("|  " + "Course_Instructor"));
		System.out.printf("%-28s", ("|  " + "Course_Section_Number"));
		System.out.print(" | " + "Course_Location");
		System.out.println();
		for (int i = 0; i < All_Cources.size(); i++) {
			for (int j = 0; j < (All_Cources.get(i).students_registered_in_course.size()); j++) {
				if ((All_Cources.get(i).students_registered_in_course.get(j).equals(F_Name + " " + L_Name))) {
					System.out.printf("%-45s", ("|  " + All_Cources.get(i).course_name));
					System.out.printf("%-20s", (" | " + All_Cources.get(i).course_id));
					System.out.printf("%-25s", (" | " + All_Cources.get(i).max_numb_of_students));
					System.out.printf("%-24s", (" | " + All_Cources.get(i).cur_number_of_students));
					System.out.printf("%-28s", ("|  " + All_Cources.get(i).course_instructor));
					System.out.printf("%-28s", ("|  " + All_Cources.get(i).section_number));
					System.out.print(" | " + All_Cources.get(i).location);
					System.out.println();
				}
			}
		}
	}

	// Method to print information about all NOT FULL course (without printing what
	// students take which course)
	public void print_all_not_full_courses_info() {
		System.out.printf("%-45s", ("|  " + "Course_Name"));
		System.out.printf("%-20s", (" | " + "Course_Id"));
		System.out.printf("%-25s", (" | " + "Maximum_Students"));
		System.out.printf("%-24s", (" | " + "Current_Students"));
		System.out.printf("%-28s", ("|  " + "Course_Instructor"));
		System.out.printf("%-28s", ("|  " + "Course_Section_Number"));
		System.out.print(" | " + "Course_Location");
		System.out.println();
		for (int i = 0; i < All_Cources.size(); i++) {
			if (All_Cources.get(i).cur_number_of_students < All_Cources.get(i).max_numb_of_students) {
				System.out.printf("%-45s", ("|  " + All_Cources.get(i).course_name));
				System.out.printf("%-20s", (" | " + All_Cources.get(i).course_id));
				System.out.printf("%-25s", (" | " + All_Cources.get(i).max_numb_of_students));
				System.out.printf("%-24s", (" | " + All_Cources.get(i).cur_number_of_students));
				System.out.printf("%-28s", ("|  " + All_Cources.get(i).course_instructor));
				System.out.printf("%-28s", ("|  " + All_Cources.get(i).section_number));
				System.out.print(" | " + All_Cources.get(i).location);
				System.out.println();
			}
		}
	}
	// ------------------------------------

}// end of class Course_data