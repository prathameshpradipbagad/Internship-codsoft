import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private List<Student> enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public int getAvailableSeats() {
        return capacity - enrolledStudents.size();
    }

    @Override
    public String toString() {
        return "Course: " + courseCode + "\nTitle: " + title + "\nDescription: " + description
                + "\nCapacity: " + capacity + "\nAvailable Seats: " + getAvailableSeats();
    }
}

class Student {
    private int studentId;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerForCourse(Course course) {
        if (!registeredCourses.contains(course) && course.enrollStudent(this)) {
            registeredCourses.add(course);
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.removeStudent(this);
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + "\nName: " + name + "\nRegistered Courses: " + registeredCourses.size();
    }
}

class CourseDatabase {
    private List<Course> courses;

    public CourseDatabase() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course getCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public List<Course> getAllCourses() {
        return courses;
    }
}

class StudentDatabase {
    private List<Student> students;

    public StudentDatabase() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        CourseDatabase courseDatabase = new CourseDatabase();
        StudentDatabase studentDatabase = new StudentDatabase();

        // Create some courses
        Course c1 = new Course("CSCI101", "Introduction to Programming", "Fundamentals of programming", 30);
        Course c2 = new Course("MATH201", "Calculus I", "Basic calculus concepts", 25);
        Course c3 = new Course("ENG101", "English Composition", "Writing skills", 35);

        courseDatabase.addCourse(c1);
        courseDatabase.addCourse(c2);
        courseDatabase.addCourse(c3);

        // Create some students
        Student s1 = new Student(1001, "Alice");
        Student s2 = new Student(1002, "Bob");

        studentDatabase.addStudent(s1);
        studentDatabase.addStudent(s2);

        // Simulate course registration
        s1.registerForCourse(c1);
        s1.registerForCourse(c2);
        s2.registerForCourse(c1);

        // Simulate dropping a course
        s1.dropCourse(c1);

        // Display course and student information
        System.out.println("Course Listing:");
        for (Course course : courseDatabase.getAllCourses()) {
            System.out.println(course);
            System.out.println("-----------");
        }

        System.out.println("\nStudent Information:");
        for (Student student : studentDatabase.getAllStudents()) {
            System.out.println(student);
            System.out.println("-----------");
        }
    }
}
