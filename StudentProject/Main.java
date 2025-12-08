public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Management System ===\n");
        
        StudentManager manager = new StudentManager();
        boolean running = true;
        
        while (running) {
            manager.displayMenu();
            Integer choice = manager.getChoice();
            
            switch (choice) {
                case 1:
                    manager.addStudent();
                    break;
                case 2:
                    manager.registerStudent();
                    break;
                case 3:
                    manager.displayStudents();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
        manager.closeScanner();
    }
}