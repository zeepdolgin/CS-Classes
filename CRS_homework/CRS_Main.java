import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CRS_Main {
    public static void main(String[] args) throws IOException {
        System.out.println("______________________________________________");
        System.out.println("");
        System.out.println("| Welcome to the Cource Registration System! |");
        System.out.println("______________________________________________");
        System.out.println("");

        Scanner scan = new Scanner(System.in);
        System.out.println("Is this the first time this Course Registration System is launched? Please type in 'Yes' or 'No'.");

        String input = scan.nextLine();
        while( !input.equalsIgnoreCase("YES") && !input.equalsIgnoreCase("NO")){
            System.out.println("Please enter a valid input: 'Yes' or 'No'.");
            String input2 = scan.nextLine();
            input = input2;
        }

        ArrayList<Course> CourseArray = new ArrayList<>();
        ArrayList<Student> Students= new ArrayList<>();
            
        // If it's the first use - get the course data from CSV:
        if (input.equalsIgnoreCase("YES")){
            Data df = new Data();
            String info = df.CourseString();
            ArrayList <Course> CourseArray2 = df.CreateCourse(df.array(info));
            ArrayList<Student> Students_2 = new ArrayList<Student>();
            CourseArray = CourseArray2;
            Students = Students_2;
        }// If it is not the first time the first time the program is used, then we use deserialization to recreate the objects:
        else{
            try{
                FileInputStream f_stream_1 = new FileInputStream("Courses_Data.ser");
                FileInputStream f_stream_2 = new FileInputStream("Student_Data.ser");
                ObjectInputStream o_stream_1 = new ObjectInputStream(f_stream_1);
                ObjectInputStream o_stream_2 = new ObjectInputStream(f_stream_2);
                // readObject takes the object from ObjectInputStream
                CourseArray = (ArrayList<Course>)o_stream_1.readObject();
                Students= (ArrayList<Student>)o_stream_2.readObject();
                // close streams:
                o_stream_1.close();
                f_stream_1.close();
                o_stream_2.close();
                f_stream_2.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
                return;
            }catch(ClassNotFoundException error){
                error.printStackTrace();
                return;
            }
        }
        boolean program_run = true;
        while (program_run){
            System.out.println("Enter 'S' for Student, 'A' for Admin.");
            String answer = scan.nextLine();
            while (!answer.equalsIgnoreCase("S") && !answer.equalsIgnoreCase("A") ){
                System.out.println("Please try again; 'S' for Student, 'A' for Admin.");
                String 
                answer2 = scan.nextLine();
                answer = answer2;
            }
            if (answer.equalsIgnoreCase("A")){
                System.out.println("Please Enter a Username");
                String username = scan.nextLine();
                while (!username.equals("Admin")){
                    System.out.println("That was an incorrect username");
                    System.out.println("Please Enter a Username");
                    String username1 = scan.nextLine();
                    username = username1;
                }
                System.out.println("Please Enter a Password");
                String password = scan.nextLine();
                while (!password.equals("Admin001")){	
                    System.out.println("That was an incorrect password");
                    System.out.println("Please Enter a Password");
                    String password1 = scan.nextLine();
                    password = password1;
                }
                Admin admin = new Admin();
                boolean admin_run = true;
                while (admin_run){
                    System.out.println("Working in Admin Mode!");
                    System.out.println("For Course Management enter 'M'.");
                    System.out.println("For Reports enter 'R'.");
                    String menu_choice = scan.nextLine();
                    while (!menu_choice.equalsIgnoreCase("M") && !menu_choice.equalsIgnoreCase("R")){
                        System.out.println("For Course Management enter 'M'");	
                        System.out.println("For Reports enter 'R'");
                        String next_menu_choice = scan.nextLine();
                        menu_choice = next_menu_choice;
                    }
                    if (menu_choice.equalsIgnoreCase("M")){
                        admin.View_CourseManagement();
                        System.out.println("Choose an option:");
                        String choice = scan.nextLine();
                        while(!choice.equals("1") && !choice.equals("2") &&!choice.equals("3") &&!choice.equals("4") && !choice.equals("5") && !choice.equals("6")){
                            System.out.println("Please enter an integer within the menu bounds.");
                            String choice1 = scan.nextLine();
                            choice = choice1;
                        }
                        if (choice.equals("1")){
                            System.out.println("Enter course name: ");
                            String course_Name = scan.nextLine();
                            System.out.println("Enter course ID: ");
                            String course_Id = scan.nextLine();
                            System.out.println("Enter the maximum amount of students: ");
                            String maximum_Students = scan.nextLine();
                            System.out.println("Enter instructor name: ");
                            String instructor = scan.nextLine();
                            System.out.println("Enter course section: ");
                            String course_Section = scan.nextLine();
                            System.out.println("Enter course location: ");
                            String course_Location = scan.nextLine();
                            admin.New_Course(course_Name, course_Id, maximum_Students, instructor, course_Section, course_Location, CourseArray);
                            System.out.println("The course was successfully created.");
                        }
                        if (choice.equals("2")){
                            System.out.println("Which course would you like to delete? Enter course ID: ");
                            String ID = scan.nextLine();
                            admin.Delete_Course(CourseArray, ID);
                        }
                        if (choice.equals("3")){
                            admin.Edit_Course(CourseArray);
                        }
                        if (choice.equals("4")){
                            System.out.println("What course what you like to view? Please give the course ID.");
                            String c = scan.nextLine();
                            admin.Display_Course(c,CourseArray );
                        }
                        if (choice.equals("5")){
                            System.out.println("Please enter the first name of the student");
                            String first_name = scan.nextLine();
                            System.out.println("Please enter the last name of the student");
                            String last_name = scan.nextLine();
                            admin.Register_Student(Students, first_name, last_name );
                        }
                        if (choice.equals("6")){
                            program_run = false;
                            admin_run = false;
                        }
                    }
                    else {
                        admin.View_Reports();
                        System.out.println("Choose an option:");
                        String choice = scan.nextLine();
                        while (!choice.equals("1") && !choice.equals("2") &&!choice.equals("3") &&!choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7")){
                            System.out.println("Please enter an integer within the menu bounds.");
                            String choice1 = scan.nextLine();
                            choice = choice1;
                        }
                        if (choice.equals("1")){
                            admin.View_Courses(CourseArray);
                        }
                        if (choice.equals("2")){
                            admin.View_Full_Courses(CourseArray);
                        }
                        if (choice.equals("3")){
                            admin.Write_File(CourseArray);
                            System.out.println("The file with list of all courses was succesfully created.");
                        }
                        if (choice.equals("4")){
                            System.out.println("Please enter the Course Name you would like to see the student's of.");
                            String course = scan.nextLine();
                            admin.View_Students_In_Course(CourseArray, course);
                        }
                        if (choice.equals("5")){
                            System.out.println("Please enter the Student's first name");
                            String fname = scan.nextLine();
                            System.out.println("Please enter the Student's last name");
                            String lname = scan.nextLine();
                            admin.View_Student_Course(fname, lname, Students);
                            }
                        if (choice.equals("6")){
                            admin.Sort(CourseArray);
                        }
                        if (choice.equals("7")){
                            program_run = false;
                            admin_run = false; // Exit program
                        }
                    }
                }
            }
            
            boolean student_run = true;

            if (answer.equalsIgnoreCase("S")){
                boolean student_check = true;
                while (student_check){
                    System.out.println("Please Enter a username.");
                    String user_name_1 = scan.nextLine();
                    for (Student s:Students){
                        String user_name = s.getUsername();
                        if (user_name_1.equals(user_name)){
                            student_check = false;
                        }
                    }
                    if (student_check){
                    System.out.println("No such student registered, please ask the Admin to register you in the system.");
                    }
                }
                Student Current_Student = new Student();
                while (!student_check){
                    System.out.println("Please Enter a password");
                    String password_entered = scan.nextLine();
                    for (Student s:Students){
                        String password_check = s.getPassword();
                        if (password_entered.equals(password_check)){
                            Current_Student = s;
                            student_check = true;	
                        }
                    }
                    if (!student_check){
                    System.out.println("Incorrect Password, please try again.");
                    }
                }
        
                while (student_run){
                    Current_Student.View_Student_Menu();
                    System.out.println("CRS Running in Student Mode.");
                    String choice = scan.nextLine();
                    while (!choice.equals("1") && !choice.equals("2") &&!choice.equals("3") &&!choice.equals("4") && !choice.equals("5") && !choice.equals("6")){
                        System.out.println("Please enter an integer within the menu bounds.");
                        String choice1 = scan.nextLine();
                        choice = choice1;
                    }
                    if (choice.equals("1")){
                        Current_Student.View_Courses(CourseArray);
                    }
                    if (choice.equals("2")){
                        Current_Student.View_Open_Courses(CourseArray);
                    }
                    if (choice.equals("3")){
                        System.out.println("Please enter the course name.");
                        String course = scan.nextLine();
                        System.out.println("Please enter the course section.");
                        String section = scan.nextLine();
                        Current_Student.Register(Current_Student, CourseArray, course, section);
                    }
                    if (choice.equals("4")){
                        System.out.println("Please enter the course name.");
                        String course = scan.nextLine();
                        System.out.println("Please enter the course section.");
                        String section = scan.nextLine();
                        Current_Student.Drop_Course(CourseArray, Current_Student, course, section);
                    }
                    if (choice.equals("5")){
                        Current_Student.getCourses();
                        System.out.println("If no courses are displayed, the student is not registered for any courses yet.");
                    }
                    if (choice.equals("6")){ //Exit program
                        program_run = false;
                        student_run = false;
                    }
                }
            }		
        }
            
        // Serialization:
        try(FileOutputStream CourseArray_Data = new FileOutputStream("Courses_Data.ser");
            FileOutputStream Student_Data = new FileOutputStream("Student_Data.ser");
            ObjectOutputStream object_output_s = new ObjectOutputStream(CourseArray_Data);
            ObjectOutputStream object_output_s2 = new ObjectOutputStream(Student_Data);) {
                object_output_s.writeObject(CourseArray);
                object_output_s2.writeObject(Students);
                System.out.println("Information in the CRS has been updated. Thank you!");
        } 
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
