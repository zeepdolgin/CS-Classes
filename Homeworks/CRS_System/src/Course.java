import java.util.ArrayList;

public class Course {
    // Course Variables:
    String course_name;
    String course_id;
	int max_students;
	int cur_students;
	ArrayList<String> students_in_course = new ArrayList<String>();
	String course_instructor;
	int section_number;
	String location;
    
    // Constructors:
    Course(){
        course_name = "";
		course_id = "";
		max_students = 0;
		cur_students = 0;
		students_in_course = new ArrayList<String>();
		course_instructor = "";
		section_number = 0;
		location = "";
    }

    Course(String Course_Name, String Course_Id, int Max_Students, int Cur_Students,
    String Course_Instructor, int Section_Number, String Location,
    ArrayList<String> Students_In_Course){
        this.course_name = Course_Name;
        this.course_id = Course_Id;
        this.max_students = Max_Students;
        this.cur_students = Cur_Students;
        this.course_instructor = Course_Instructor;
        this.section_number = Section_Number;
        this.location = Location;
        this.students_in_course = Students_In_Course;
    }
}
