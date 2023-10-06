public interface AdminInterface {
    // Methods that are available to Admins
	// 1.Create a new course
	void createCourse();

	// 2.Delete a course
	void deleteCourse();

	// 3.Edit a course (this will allow the Admin to edit any information on the
	// course except for course ID and name)
	void editCourse();

	// 4.Display information for a given course (by course ID)
	void displayInfo();

	// 5.Register a student (this option will allow the admin to add a student
	// without assigning to a course)
	void registerStudent();

	// 7.View all courses that are FULL (reached the maximum number of students)
	void viewFullCourses();

	// 8.Write to a file the list of course that are full
	void writeFull();

	// 9.View the names of the students that are registered in a specific course
	void viewCourseStudents();

	// 10.View the list of courses that a given student is registered in (the system
	// shall display all the courses that logged-in student is registered in)
	void viewStudentsCourses();

	// 11. Sort the courses based on the current number of students registered (from
	// smallest number to the greatest number)
	void sortByReg();

	// 12. Exit
	void exit();
}

