import java.util.ArrayList;

public class student implements StudentInterface {
    private Integer id;
    private String fullName;
    private ArrayList<CourseRegistration> registrations;

    public student(Integer id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.registrations = new ArrayList<>();
    }
    public Integer getStudentId() {
        return id;
    }
    public String getName() {
        return fullName;
    }
    public ArrayList<CourseRegistration> getRegistrations() {
        return registrations;
    }

    //registerCourse(Course course, Double grade)
    @Override
    public void registerCourse(Course course, Double grade) {
        CourseRegistration newRegistration = new CourseRegistration(course, grade);
        registrations.add(newRegistration);
    }
    @Override
    public void printReport(){
        StringBuilder report = new StringBuilder();
        report.append("Student ID: ").append(id).append('\n');
        report.append("Student Name: ").append(fullName).append('\n');
        report.append("Course Registration").append("\n");

        if(registrations.isEmpty()){
            report.append("  No courses registered yet \n" );   
        }
        else{
            for(CourseRegistration registration:registrations){
                report.append("* Course: ").append(registration.getCourse().getCourseName()).append("- Grade: ").append(registration.getGrade()).append('\n');
            }
        }
        System.out.print(report.toString());
    }

    public class CourseRegistration {

        private Course course;
        private Double grade;

        public CourseRegistration(Course course, Double grade) {
            this.course = course;
            this.grade = grade;
        }

        public Course getCourse() {
            return course;
        }

        public Double getGrade() {
            return grade;
        }
    }
}
