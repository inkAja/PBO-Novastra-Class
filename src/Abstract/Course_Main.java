package Abstract;

import java.util.UUID;

public class Course_Main {
    public static void main(String[] args) {
        System.out.println("=== Course Management System Demo ===\n");

        // Create a Video Course
        UUID videoCourseId = UUID.randomUUID();
        VideoCourse videoCourse = new VideoCourse(
                videoCourseId,
                "Java Programming Fundamentals",
                "Dr. Sarah Johnson",
                8,
                45
        );

        // Create a Live Bootcamp Course
        UUID bootcampCourseId = UUID.randomUUID();
        LiveBootcampCourse bootcampCourse = new LiveBootcampCourse(
                bootcampCourseId,
                "Full Stack Web Development Bootcamp",
                "Prof. Michael Chen",
                12,
                85
        );

        // Display course information
        System.out.println("--- Course Information ---");
        System.out.println(videoCourse);
        System.out.println(bootcampCourse);
        System.out.println();

        // Test completion criteria for Video Course
        System.out.println("--- Video Course Completion Tests ---");
        testCompletion(videoCourse, 100.0f, 75.0, "Full progress, good portfolio");
        testCompletion(videoCourse, 90.0f, 85.0, "Incomplete progress, good portfolio");
        testCompletion(videoCourse, 100.0f, 65.0, "Full progress, low portfolio");
        testCompletion(videoCourse, 100.0f, 70.0, "Full progress, exactly minimum portfolio");
        System.out.println();

        // Test completion criteria for Bootcamp Course
        System.out.println("--- Bootcamp Course Completion Tests ---");
        testCompletion(bootcampCourse, 85.0f, 85.0, "Meets attendance, good portfolio");
        testCompletion(bootcampCourse, 80.0f, 90.0, "Below attendance, good portfolio");
        testCompletion(bootcampCourse, 90.0f, 75.0, "Meets attendance, low portfolio");
        testCompletion(bootcampCourse, 85.0f, 80.0, "Meets attendance, exactly minimum portfolio");
        System.out.println();

        // Demonstrate polymorphism
        System.out.println("--- Polymorphism Demo ---");
        Course[] courses = {videoCourse, bootcampCourse};
        for (Course course : courses) {
            System.out.printf("Course: %s | Type: %s | Duration: %d weeks%n",
                    course.getTitle(), course.getCourseType(), course.getDurationWeeks());
        }
        System.out.println();

        // Test validation
        System.out.println("--- Validation Tests ---");
        testValidation();
    }

    private static void testCompletion(Course course, float progress, double portfolio, String description) {
        boolean passed = course.checkCompletionCriteria(progress, portfolio);
        String status = passed ? "PASSED" : "FAILED";
        System.out.printf("[%s] %s: progress=%.1f%%, portfolio=%.1f => %s%n",
                status, description, progress, portfolio, passed ? "COMPLETED" : "NOT COMPLETED");
    }

    private static void testValidation() {
        // Test invalid course ID
        try {
            new VideoCourse(null, "Test", "Instructor", 4, 10);
            System.out.println("FAIL: Should have thrown exception for null course ID");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Null course ID rejected - " + e.getMessage());
        }

        // Test empty title
        try {
            new VideoCourse(UUID.randomUUID(), "", "Instructor", 4, 10);
            System.out.println("FAIL: Should have thrown exception for empty title");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Empty title rejected - " + e.getMessage());
        }

        // Test negative duration
        try {
            new VideoCourse(UUID.randomUUID(), "Test", "Instructor", -1, 10);
            System.out.println("FAIL: Should have thrown exception for negative duration");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Negative duration rejected - " + e.getMessage());
        }

        // Test invalid video count
        try {
            new VideoCourse(UUID.randomUUID(), "Test", "Instructor", 4, 0);
            System.out.println("FAIL: Should have thrown exception for zero video count");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Zero video count rejected - " + e.getMessage());
        }

        // Test invalid attendance percentage (too high)
        try {
            new LiveBootcampCourse(UUID.randomUUID(), "Test", "Instructor", 4, 150);
            System.out.println("FAIL: Should have thrown exception for attendance > 100");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Attendance > 100 rejected - " + e.getMessage());
        }

        // Test invalid attendance percentage (zero)
        try {
            new LiveBootcampCourse(UUID.randomUUID(), "Test", "Instructor", 4, 0);
            System.out.println("FAIL: Should have thrown exception for zero attendance");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: Zero attendance rejected - " + e.getMessage());
        }
    }
}