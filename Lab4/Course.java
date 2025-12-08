public class Course {
    private Integer courseCode;
    private String courseName;
    private Integer creditHours;

    public Course(Integer courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public Integer getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getCreditHours() {
        return creditHours;
    }
}
