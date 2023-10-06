import java.util.ArrayList;

public class Course {
	// Course Class variables
	String course_name;
	String course_id;
	int max_numb_of_students;
	int cur_number_of_students;
	ArrayList<String> students_registered_in_course = new ArrayList<String>();
	String course_instructor;
	int section_number;
	String location;

	// no-arg constructor
	Course() {
		course_name = "";
		course_id = "";
		max_numb_of_students = 0;
		cur_number_of_students = 0;
		students_registered_in_course = new ArrayList<String>();
		course_instructor = "";
		section_number = 0;
		location = "";
	}

	// constructor with all args
	Course(String Course_Name, String Course_Id, int Max_Numb_Of_Students, int Cur_Number_Of_Students,
			String Course_Instructor, int Section_Number, String Location,
			ArrayList<String> Students_Registered_In_Course) {
		this.course_name = Course_Name;
		this.course_id = Course_Id;
		this.max_numb_of_students = Max_Numb_Of_Students;
		this.cur_number_of_students = Cur_Number_Of_Students;
		this.students_registered_in_course = Students_Registered_In_Course;
		this.course_instructor = Course_Instructor;
		this.section_number = Section_Number;
		this.location = Location;
	}
} // end of Course class