public class Course {
    private String course;
    private String grade;

    public Course(String course, String grade) {
        this.course = course;
        this.grade = grade;
    }

    // get methods
    public String getCourse() {
        return course;
    }

    public String getGrade() {
        return grade;
    }

    // set methods
    public void setCourse(String course) {
        this.course = course;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return course + ": " + grade;
    }

}

