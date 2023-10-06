import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Data {
    ArrayList<Course> All_Cources = new ArrayList<Course>();
    String fileName = "MyUniversityCourses.csv";
    ArrayList<Course> courses = CSV_reader.readCoursesFromCSV(fileName);

}

