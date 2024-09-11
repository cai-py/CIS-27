import java.util.ArrayList;

public class Student extends Person {
    private ArrayList<Course> courses;

    public Student(String firstName, String lastName, ArrayList<Course> courses) {
        super(firstName, lastName);
        this.courses = courses;
    }

    // get methods
    public String getCourses() {
        StringBuilder transcript = new StringBuilder();

        if (courses.isEmpty()) {
            transcript.append("No courses taken.\n");
        }else {
            for (Course course : courses) {
                transcript.append(course.toString() + "\n");
            }
        }

        return transcript.toString();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }
}