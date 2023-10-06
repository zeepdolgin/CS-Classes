import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List;

public class CSV_reader {
    
    public static ArrayList<Course> readCoursesFromCSV(String fileName) throws IOException {
        ArrayList<Course> courses = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
    
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while (line != null){
                String[] attributes = line.split(",");
                Course course = creatCourse(attributes);
                courses.add(course);
                line = br.readLine();
                }
            } catch (IOException ioeException){
                ioeException.printStackTrace();
            }
    
            return courses;
        }

   // Method to create course
   public static Course creatCourse(String[] info){
        String course_name = info[0];
        String course_id = info[1];
        int max_students = Integer.parseInt(info[2]);
        int cur_students = Integer.parseInt(info[3]);
        ArrayList<String> students_in_course = null;
        String course_instructor = info[5];
        int section_number = Integer.parseInt(info[6]);
        String location = info [7];
        return new Course(course_name, course_id, max_students, cur_students, course_instructor, section_number, location, students_in_course);
    }
}