import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentManager {
    private static final Course course1 =new Course(01, "java");  
    private static final Course course2 =new Course(02, "c++");  
    private static final Course course3 =new Course(03, "python");  
    private static final Course course4 =new Course(04, "ruby");  
    private static final Course course5 =new Course(05, "c");  
    Course[] courses = {course1, course2, course3, course4, course5};
    private ArrayList<student>students;
    private Scanner scan;

    public StudentManager(){
        this.students = new ArrayList<>();
        this.scan = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. Register Student to Multiple Courses");
        System.out.println("3. Display All Students");
        System.out.println("4. Exit");
        System.out.print("Choice: ");
    }
    
    public int getChoice() {
        int choice = -1;
        while (true) {
            try {
                choice = Integer.parseInt(scan.nextLine());
                if (choice < 1 || choice > 4) {
                    System.out.print("✗ Invalid choice! Enter 1 to 4: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("✗ Enter numbers only! Try again: ");
            }
        }
        return choice;
    }

    public void addStudent() {
        Integer id = null;

        while (true) {
            try {
                System.out.print("Enter Student ID: ");
                id = Integer.parseInt(scan.nextLine());

                //  Check for duplicate ID
                boolean exists = false;
                for (student s : students) {
                    if (s.getStudentId().equals(id)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("✗ This ID already exists! Enter a different ID.");
                    continue;
                }

                break; //  Valid and unique ID → exit loop

            } catch (NumberFormatException e) {
                System.out.println("✗ Invalid ID! Enter numbers only.");
            }
        }

        String name;
        while (true) {
            System.out.print("Enter Student Name: ");
            name = scan.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("✗ Name cannot be empty!");
            } 
            else if (!name.matches("[a-zA-Z ]+")) {
                System.out.println("✗ Name must NOT contain numbers or symbols!");
            } 
            else {
                break;
            }
        }

        student newStudent = new student(id, name);
        students.add(newStudent);
        System.out.println("✓ Student added successfully!");
    }



    public void registerStudent(){
        if(students.isEmpty()){
            System.out.print("No Students available");
            return;
        }
        //show all students
        System.out.print("Students: ");
        for(int i=0;i<students.size();i++){
            System.out.println((i+1)+" ID: "+students.get(i).getStudentId()+ " - "+ students.get(i).getName());
        }

        System.out.print("Select student number: ");
        int studentNum;
        try {
            studentNum = Integer.parseInt(scan.nextLine());

            if (studentNum < 1 || studentNum > students.size()) {
                System.out.println("✗ Invalid student selection!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("✗ Enter numbers only!");
            return;
        }
        student selectedStudent = students.get(studentNum - 1);


        //show all courses
        System.out.println("Available Courses:");
        for(int i=0;i<courses.length;i++){
            System.out.println((i+1)+" - "+ courses[i].getCourseName());
        }

        // Using StringTokenizer to parse multiple courses
        System.out.println("\nEnter course numbers separated by commas (e.g., 1,2,3):");
        System.out.print("Courses: ");
        String courseInput = scan.nextLine();
        
        System.out.println("Enter grades for each course separated by commas (e.g., 85.5,90,78):");
        System.out.print("Grades: ");
        String gradeInput = scan.nextLine();

        // parse courses uning StringTokenizer
        StringTokenizer courseTokenizer =new StringTokenizer(courseInput,",");
        StringTokenizer gradeTokenizer =new StringTokenizer(gradeInput,",");

        if (courseTokenizer.countTokens() != gradeTokenizer.countTokens()) {
            System.out.println("✗ Number of courses and grades must match!");
            return;
        }

        Integer registrationCount = 0; // Wrapper class - autoboxing
        
        while (courseTokenizer.hasMoreTokens() && gradeTokenizer.hasMoreTokens()) {
            String courseNumStr = courseTokenizer.nextToken().trim();
            String gradeStr = gradeTokenizer.nextToken().trim();
            
            try {
                Integer courseNum = Integer.parseInt(courseNumStr); // Wrapper class
                Double grade = Double.parseDouble(gradeStr); // Wrapper class - autoboxing
                
                Course selectedCourse = null;
                if (courseNum == 1) selectedCourse = course1; // unboxing
                else if (courseNum == 2) selectedCourse = course2;
                else if (courseNum == 3) selectedCourse = course3;
                else if (courseNum == 4) selectedCourse = course4;
                else if (courseNum == 5) selectedCourse = course5;
                else {
                    System.out.println("✗ Invalid course number: " + courseNum);
                    continue;
                }
                
                // Register using the interface method
                selectedStudent.registerCourse(selectedCourse, grade);
                registrationCount++; // unboxing, increment, autoboxing
                
            } catch (NumberFormatException e) {
                System.out.println("✗ Invalid input format!");
            }
        }
        
        System.out.println("✓ Registration successful! " + registrationCount + 
                         " course(s) registered.");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available!");
            return;
        }

        System.out.print("\n═══════════════════════════════════════\n");
        System.out.print("        STUDENT REPORTS\n");
        System.out.print("═══════════════════════════════════════\n");
        
        for (student s : students) {
            s.printReport();
            System.out.print("-------------------\n");
            
            //System.out.print("\n");
        }
        
        //System.out.println(fullReport.toString());
    }

    public void closeScanner() {
        scan.close();
    }
}
