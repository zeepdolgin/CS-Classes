import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class Student_List implements java.io.Serializable{ //															implement serialization!!!!!!!!!!!
	ArrayList<Student> All_Student = new ArrayList<Student>();

	// no arg constructor
	public Student_List() {
		this.All_Student = new ArrayList<Student>();
	}

	// Method to add a student
	public void addStudent(Student a) {
		this.All_Student.add(a);
	}

	// Method to delete a student
	public void deleteStudent(Student a) {
		this.All_Student.remove(a);
	}

	// Method to format the Data and store it in a matrix of separate words
	public void format_Student_Data() {
		// 1. store all data into an ArrayList of ArrayLists, where each sub-ArrayList
		// holds words from the text file
		ArrayList<ArrayList<String>> all_student_data = storeData();
		int number_of_students = all_student_data.size();
		// i starts from 1 as the first line is a header
		for (int i = 1; i < number_of_students; i++) {
			String First_Name = all_student_data.get(i).get(0);
			String Last_Name = all_student_data.get(i).get(1);
			String User_Name = all_student_data.get(i).get(2);
			String Password = all_student_data.get(i).get(3);
			// Create a Student object
			Student student = new Student(First_Name, Last_Name, Password, User_Name);
			All_Student.add(student);
		}
	}

	// Method to save all data into a file
	public void write_to_StudentData_file() {
		String fileName = "studentData.txt";
		Scanner scan = new Scanner(System.in);

		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Student First Name, Student Last Name, Student Username, Student Password");
			bufferedWriter.newLine();
			for (int i = 0; i < All_Student.size(); i++) {
				String text = (All_Student.get(i).first_name + "," + All_Student.get(i).last_name + ","
						+ All_Student.get(i).username + "," + All_Student.get(i).password);
				bufferedWriter.write(text);
				bufferedWriter.newLine();
			}
			// Close writer
			bufferedWriter.close();
		}

		catch (IOException exk) {
			System.out.println("Error writing file '" + fileName + "'");
			exk.printStackTrace();
		}
	}

	// Method to Store Data in an ArrayList of ArrayLists
	public static ArrayList<ArrayList<String>> storeData() {
		// Create an ArrayList of lines that were read from the file
		ArrayList<String> List_of_Lines = readFromStudentDataFile();
		// Create an ArrayList of ArrayLists
		ArrayList<ArrayList<String>> ArrList_Of_ArrList_Of_Words = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < List_of_Lines.size(); i++) {
			String[] each_word = List_of_Lines.get(i).split(",");
			// Temporary arrList;
			ArrayList<String> a1 = new ArrayList<String>();
			for (int j = 0; j <= (each_word.length) - 1; j++) {
				a1.add(each_word[j]);
			}
			// Fill in the ArrayList with comma-separated words
			ArrList_Of_ArrList_Of_Words.add(a1);
		}
		return ArrList_Of_ArrList_Of_Words;
	}

	// Method to read from file (taken from professor example)
	public static ArrayList<String> readFromStudentDataFile() {
		String fileName = "studentData.txt";
		// References one line at a time
		String line = null;
		try {
			// FileReader reads text files as characters
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
} // end of Student List class