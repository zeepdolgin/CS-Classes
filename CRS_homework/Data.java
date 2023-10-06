import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


// This class is needed to get the course data from the given CSV into an ArrayList of Course objects.
public class Data {
	
// First, we will parse through the CSV file and add the course data into one long string:	
	
public String CourseString() throws FileNotFoundException {
	String start = "";
	Scanner scan = new Scanner (new File("MyUniversityCourses.csv"));
	while (scan.hasNextLine()){
		String next_line = scan.nextLine();
		start += next_line + "/";
		}
	scan.close();
	return start;
	}

// Method to format the string and extract data from it:

public static String[][] array (String CourseString){
    // creates a list of strings by splitting the CourseString by "/". 
	String [] array = CourseString.split("/");
	String [][] array2 = new String[array.length +1][8]; // there are 8 columns
	int count = 0;
	for (String s : array){
        int count2 = 0;
		String [] info = s.split(",");
		count ++;
		for (int i = 0; i < info.length; i ++){
			array2[count][count2] = info[i];
			count2++;
		}
		count2 = 0;
	}
	return array2;
}

// Method to create ArrayList of Course objects.

    public static ArrayList<Course> CreateCourse(String [][] array2){
	    ArrayList<Course> CourseList = new ArrayList();
	    for (int i = 2; i < array2.length; i ++){
			Course a = new Course();
			
			a.setCourse_Name(array2[i][0]);
			a.setCourse_Id(array2[i][1]);
			a.setMaximum_Students(array2[i][2]);
            // Student names and Current Students are empty for now, they are in positions 3 and 4 in the list of course info. 
			a.setInstructor(array2[i][5]);
			a.setCourse_Section(array2[i][6]);
			a.setCourse_Location(array2[i][7]);
			CourseList.add(a);
	}
	return CourseList;
	}
}
