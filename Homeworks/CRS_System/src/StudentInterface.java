public interface StudentInterface {

        // 2. View all courses that are not full
        void viewNotFull();
    
        // 3. Register in a course (student must enter the course name, section, the
        // name will be added to the appropriate course)
        void registerForCourse();
    
        // 4. Withdraw from a course (in this case the student will be asked to enter
        // the course name, then the name of the student will be taken off from the
        // given course)
        void dropCourse();
    
        // 5. View all courses that the current student is registered in
        void viewAllRegClasses();
    
        // 6. Exit
        void exit();
    }

