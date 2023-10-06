import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.Scanner;

public class Admin extends User implements Admin_Interface {
   
    private static final long serialVersionUID = 1L;
    public ArrayList<Student> All_Students;

    // Method to create a course:
	public Course New_Course(String course_Name, String course_Id, String maximum_Students, String instructor, 
    String course_Section, String course_Location, ArrayList<Course> cl){
		String current_Students = "0";
		Course c = new Course(course_Name, course_Id, maximum_Students, current_Students, instructor, course_Section, course_Location );
		cl.add(c);
		return c;	
	}
			
	// Method to create a file with full courses:
	public void Write_File(ArrayList<Course> cl) throws FileNotFoundException, UnsupportedEncodingException {
	    PrintWriter writer = new PrintWriter ("FullCourses.txt", "UTF-8");
		
        for (int i = 0; i < cl.size(); i++){
            Course a = cl.get(i);
            if (a.getCurrent_Students() == a.getMaximum_Students()){
                writer.println(a.getCourse_Name());
            }	
        }	
        writer.close();
	}
			
	// Method to delete a course:
	public void Delete_Course(ArrayList <Course> c, String s){
        boolean course_found = false;
        for (int i = 0; i < c.size(); i++){
			Course a = c.get(i);
			if (a.getCourse_Id().equalsIgnoreCase(s)){
				c.remove(a);
                System.out.println("The course was successfully deleted.");
                course_found = true;
			}
        }
		if(!course_found){
            System.out.println("No course with such ID found.");
        }
    }
    // Method to edit a course:
    public void Edit_Course(ArrayList <Course> c){
        Scanner scan = new Scanner(System.in);
        System.out.println("Which course would you like edit? Enter course ID:");
        String course_id = scan.nextLine();
        boolean course_found = false;
        for (int i = 0; i < c.size(); i++){
            Course a = c.get(i);
            if(a.getCourse_Id().equalsIgnoreCase(course_id)){
                course_found = true;
                System.out.println("Course found: ");
                String option_choice = "";
                do{
                    System.out.println("Which details would you like to edit?");
                    System.out.println("1. Change course name.");
                    System.out.println("2. Change the maximum number of students.");
                    System.out.println("3. Change number of current students.");
                    System.out.println("4. Change the name of the instructor.");
                    System.out.println("5. Change section number.");
                    System.out.println("6. Change course location.");
                    System.out.println("7. Exit change mode.");
                    System.out.println("Enter an integer:");
                    option_choice = scan.nextLine();
                    switch(option_choice){

                        case "1":
                        System.out.println("Please enter new course name: ");
                        String new_course_name = scan.nextLine();
                        a.setCourse_Name(new_course_name);
                        break;

                        case "2":
                        System.out.println("Please enter new max number of srudents: ");
                        String new_max = scan.nextLine();
                        a.setMaximum_Students(new_max);
                        break;
        
                        case "3":
                        System.out.println("Please enter new current number of students: ");
                        String new_cur = scan.nextLine();
                        a.setCurrent_Students(new_cur);					
                        break;
        
                        case "4":
                        System.out.println("Please enter new name of the instructor: ");
                        String new_instructor_name = scan.nextLine();
                        a.setInstructor(new_instructor_name);					
                        break;
        
                        case "5":
                        System.out.println("Please enter new section number: ");
                        String new_section = scan.nextLine();
                        a.setCourse_Section(new_section);					
                        break;
        
                        case "6":
                        System.out.println("Please enter new course location ");
                        String new_location = scan.nextLine();
                        a.setCourse_Location(new_location);					
                        break;
        
                        case "7":
                        System.out.println("Thank you, course details succesfully changed. ");
                        break;
        
                        default:
                        System.out.println("No such option, please try again ");
                        break;
                    }
                }while (!option_choice.equals("7"));
            }
        }
        if(!course_found){
            System.out.println("No such course found.");
        }
    }  
    // Method to display course information, given ID:
	public  void Display_Course(String CourseName, ArrayList <Course> c){
		for (int i = 0; i < c.size(); i++){
			Course a = c.get(i);
			if (a.getCourse_Id().equalsIgnoreCase(CourseName)){
				System.out.println("Printing out the information for the course: " + a.getCourse_Id());
				System.out.println("Course name | " + a.getCourse_Name() + " | ");
				System.out.println("Course location | " + a.getCourse_Location() + " | ");
				System.out.println("Course section | " + a.getCourse_Section() + " | ");	
				System.out.println("Course Instructor | " + a.getInstructor() + " | ");
				System.out.println("Current Number of Students | " + a.getCurrent_Students() + " | ");
				System.out.println("Maximum Students | " + a.getMaximum_Students() + " | ");
				System.out.println("Student Names | ");
				for (Student names: a.viewStudent_Names()){
					System.out.println(names.getFirstName() + " " + names.getLastName());	
				}	
			}
		}	
	}
	
    // Method to register a student (create password and username):
	public void Register_Student(ArrayList<Student> sl, String firstname, String lastname){
        Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the username for new student: ");
		String username = scan.nextLine();
        System.out.println("Please enter the password for new student: ");
		String password = scan.nextLine();
		Student student = new Student( firstname, lastname,username, password);
		sl.add(student);
        System.out.println("New student added.");
        System.out.println("The username is " + username);
		System.out.println("The password is " + password);	
		}
		
	// Method to view courses that are full:
	public void View_Full_Courses(ArrayList<Course> cl){
		boolean cont = true;
		System.out.print("The following courses are full: | ");
		for (int i = 0; i < cl.size(); i++){
			Course a = cl.get(i);
			if (a.getCurrent_Students() == a.getMaximum_Students()){
				System.out.println(a.getCourse_Name());
				cont = false;
			}
		}
        if (cont){
			System.out.println("Each course currently has at least one spot left.");
		}	
	}
		
    // Method to view all students registered for a given course: 
	public void View_Students_In_Course(ArrayList <Course> cl, String course){
		boolean cont = true;
		System.out.println("The following students are registered in: " + course);
		for (int i = 0; i < cl.size(); i ++){
			Course c = cl.get(i);
			if (c.getCourse_Name().equalsIgnoreCase(course)){
				ArrayList<Student> stu = c.getStudent_Names();
				for (Student f: stu){
					System.out.println(f.getFirstName() + " " + f.getLastName());
					cont = false;
				}
			}
		}
        if (cont){
			System.out.println("There are no students in this course.");
		}	
	}

    // Method to print out course management menu:
	public void View_CourseManagement(){
        System.out.println("Course Management Options:");
		System.out.println("1. Create a new Course.");
		System.out.println("2. Delete a Course.");
		System.out.println("3. Edit a Course.");
		System.out.println("4. Display information for a given course.");
		System.out.println("5. Register a student.");
		System.out.println("6. Exit.");
	}
	
    // Method to print out reports menu:
	public void View_Reports(){
        System.out.println("Report Options");
		System.out.println("1. View all courses.");
		System.out.println("2. View all courses that are FULL.");
		System.out.println("3. Write to a file the list of course that are full.");
		System.out.println("4. View the names of the students that are registered in a specific course.");
		System.out.println("5. View the list of courses that a given student is registered in.");
		System.out.println("6. Sort the courses based on the current number of students registered.");
		System.out.println("7. Exit.");	
	}

	// Method to sort the courses by the number of registered students:
    public void Sort(ArrayList<Course> cl){
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Course> list2 = new ArrayList<>();
		ArrayList<String> list3 = new ArrayList<>();
		for (int i = 0 ; i < cl.size(); i++){
			Course a = cl.get(i);
			list.add(a.getCurrent_Students());
			list2.add(a);	
			}
		Collections.sort(list);
		for (int h: list){
			for (int i = 0; i < list2.size(); i++){
				Course a = list2.get(i);
				if (a.getCurrent_Students() == h){
					list3.add(a.getCourse_Name() + ": " + a.getCurrent_Students() + " students in the course." );
					list2.remove(a);	
				}
			}
        }
        System.out.println("Printing the sorted list of courses (from least students in the course, to most): ");
			for (String a : list3){
			System.out.println(a);
			}
		}	
}