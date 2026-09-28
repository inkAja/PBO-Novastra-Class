import Abstract.Course;
import Abstract.LiveBootcampCourse;
import Abstract.VideoCourse;
import Inheritance.Mentor;
import Inheritance.Pelajar;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Course Management System Demo ===\n");

        VideoCourse videoCourse = new VideoCourse(UUID.randomUUID(),
                "Java Programming Fundamentals", "Dr. Sarah Johnson", 8, 45);
        LiveBootcampCourse bootcampCourse = new LiveBootcampCourse(UUID.randomUUID(),
                "Full Stack Web Development Bootcamp", "Prof. Michael Chen", 12, 85);

        System.out.println("--- Course Information ---");
        System.out.println(videoCourse);
        System.out.println(bootcampCourse);
        System.out.println();

        System.out.println("--- Video Course Completion Tests ---");
        testCompletion(videoCourse, 100.0f, 75.0, "Full progress, good portfolio");
        testCompletion(videoCourse, 90.0f, 85.0, "Incomplete progress, good portfolio");
        testCompletion(videoCourse, 100.0f, 65.0, "Full progress, low portfolio");
        testCompletion(videoCourse, 100.0f, 70.0, "Full progress, exactly minimum portfolio");
        System.out.println();

        System.out.println("--- Bootcamp Course Completion Tests ---");
        testCompletion(bootcampCourse, 85.0f, 85.0, "Meets attendance, good portfolio");
        testCompletion(bootcampCourse, 80.0f, 90.0, "Below attendance, good portfolio");
        testCompletion(bootcampCourse, 90.0f, 75.0, "Meets attendance, low portfolio");
        testCompletion(bootcampCourse, 85.0f, 80.0, "Meets attendance, exactly minimum portfolio");
        System.out.println();

        System.out.println("--- Polymorphism Demo ---");
        Course[] courses = {videoCourse, bootcampCourse};
        for (Course course : courses) {
            System.out.printf("Course: %s | Type: %s | Duration: %d weeks%n",
                    course.getTitle(), course.getCourseType(), course.getDurationWeeks());
        }
        System.out.println();

        System.out.println("--- Validation Tests ---");
        testValidation();

        System.out.println("\n=== Inheritance Demo ===");
        Pelajar pelajar1 = new Pelajar();
        pelajar1.setName("Saya sendiri");
        System.out.println("Nama Pelajar: " + pelajar1.getName());
        pelajar1.ambilCourse(videoCourse); // Pelajar dapat memilih course yang diikuti.
        pelajar1.selesaiCourse();
        System.out.println("Level Pelajar: " + pelajar1.level());

        Mentor mentor1 = new Mentor();
        mentor1.setName("Budi");
        System.out.println("Nama Mentor: " + mentor1.getName());
        mentor1.ajarCourse();
    }

    private static void testCompletion(Course course, float progress, double portfolio, String description) {
        boolean passed = course.checkCompletionCriteria(progress, portfolio);
        String status = passed ? "PASSED" : "FAILED";
        System.out.printf("[%s] %s: progress=%.1f%%, portfolio=%.1f => %s%n",
                status, description, progress, portfolio, passed ? "COMPLETED" : "NOT COMPLETED");
    }

    private static void testValidation() {
        try {
            new VideoCourse(null, "Test", "Instructor", 4, 10);
            System.out.println("FAIL: Should have thrown exception for null course ID");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Null course ID rejected - " + e.getMessage());
        }
        try {
            new VideoCourse(UUID.randomUUID(), "", "Instructor", 4, 10);
            System.out.println("FAIL: Should have thrown exception for empty title");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Empty title rejected - " + e.getMessage());
        }
        try {
            new VideoCourse(UUID.randomUUID(), "Test", "Instructor", -1, 10);
            System.out.println("FAIL: Should have thrown exception for negative duration");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Negative duration rejected - " + e.getMessage());
        }
        try {
            new VideoCourse(UUID.randomUUID(), "Test", "Instructor", 4, 0);
            System.out.println("FAIL: Should have thrown exception for zero video count");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Zero video count rejected - " + e.getMessage());
        }
        try {
            new LiveBootcampCourse(UUID.randomUUID(), "Test", "Instructor", 4, 150);
            System.out.println("FAIL: Should have thrown exception for attendance > 100");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Attendance > 100 rejected - " + e.getMessage());
        }
        try {
            new LiveBootcampCourse(UUID.randomUUID(), "Test", "Instructor", 4, 0);
            System.out.println("FAIL: Should have thrown exception for zero attendance");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Zero attendance rejected - " + e.getMessage());
        }
    }
}
