package Abstract;

import java.util.UUID;
import Interface.Sertification;

public abstract class Course {
    private UUID courseId;
    private String title;
    private String instructorName;
    private int durationWeeks;

    public Course(UUID courseId, String title, String instructorName, int durationWeeks) {
        if (courseId == null) throw new IllegalArgumentException("Course ID cannot be null");
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title cannot be null or empty");
        if (instructorName == null || instructorName.trim().isEmpty()) throw new IllegalArgumentException("Instructor name cannot be null or empty");
        if (durationWeeks <= 0) throw new IllegalArgumentException("Duration weeks must be positive");
        this.courseId = courseId;
        this.title = title;
        this.instructorName = instructorName;
        this.durationWeeks = durationWeeks;
    }

    public abstract String getCourseType();
    public abstract boolean checkCompletionCriteria(float progressPercentage, double portfolioScore);
    public UUID getCourseId() { return courseId; }
    public String getTitle() { return title; }
    public String getInstructorName() { return instructorName; }
    public int getDurationWeeks() { return durationWeeks; }

    @Override
    public String toString() {
        return String.format("%s{id=%s, title='%s', instructor='%s', duration=%d weeks}",
                getCourseType(), courseId, title, instructorName, durationWeeks);
    }
}
