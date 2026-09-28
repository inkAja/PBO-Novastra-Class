package Abstract;

import java.util.UUID;
import Interface.Sertification;

public abstract class Course {
    private UUID courseId;
    private String title;
    private String instructorName;
    private int durationWeeks;


    public Course(UUID courseId, String title, String instructorName, int durationWeeks) {
        if (courseId == null) {
            throw new IllegalArgumentException("Course ID cannot be null");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (instructorName == null || instructorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Instructor name cannot be null or empty");
        }
        if (durationWeeks <= 0) {
            throw new IllegalArgumentException("Duration weeks must be positive");
        }
        this.courseId = courseId;
        this.title = title;
        this.instructorName = instructorName;
        this.durationWeeks = durationWeeks;
    }


    public abstract String getCourseType();
    public abstract boolean checkCompletionCriteria(float progressPercentage, double portfolioScore);

    // Concrete Methods / Shared Behavior
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

// Subclass 1: Video Course
class VideoCourse extends Course implements Sertification {
    private int totalVideoCount;

    public VideoCourse(UUID courseId, String title, String instructorName, int durationWeeks, int totalVideoCount) {
        super(courseId, title, instructorName, durationWeeks);
        if (totalVideoCount <= 0) {
            throw new IllegalArgumentException("Total video count must be positive");
        }
        this.totalVideoCount = totalVideoCount;
    }

    @Override
    public String getCourseType() {
        return "Video";
    }

    @Override
    public boolean checkCompletionCriteria(float progressPercentage, double portfolioScore) {
        // Untuk Video Course: Cukup progress video 100% dan score portfolio di atas 70
        return progressPercentage >= 100.0f && portfolioScore >= 70.0;
    }

    @Override
    public void generateSertif() {
        System.out.println("Menerbitkan sertifikat kelulusan Video Course: " + getTitle());
    }
    
    @Override
    public void downloadSertif() {
        System.out.println("Mendownload file sertifikat Video Course: " + getTitle() + ".pdf");
    }

    public int getTotalVideoCount() { return totalVideoCount; }

    @Override
    public String toString() {
        return String.format("%s{totalVideos=%d}", super.toString(), totalVideoCount);
    }
}

// Subclass 2: Live Bootcamp Course
class LiveBootcampCourse extends Course implements Sertification{
    private int minAttendancePercentage;

    public LiveBootcampCourse(UUID courseId, String title, String instructorName, int durationWeeks, int minAttendancePercentage) {
        super(courseId, title, instructorName, durationWeeks);
        if (minAttendancePercentage <= 0 || minAttendancePercentage > 100) {
            throw new IllegalArgumentException("Minimum attendance percentage must be between 1 and 100");
        }
        this.minAttendancePercentage = minAttendancePercentage;
    }

    @Override
    public String getCourseType() {
        return "Live_Bootcamp";
    }

    
    @Override
    public boolean checkCompletionCriteria(float progressPercentage, double portfolioScore) {
        // Untuk Bootcamp: Syarat kelulusan lebih ketat (Portfolio minimal 80)
        return progressPercentage >= minAttendancePercentage && portfolioScore >= 80.0;
    }

    @Override
    public void generateSertif() {
        System.out.println("Menerbitkan sertifikat kelulusan Live Bootcamp: " + getTitle());
    }

    @Override
    public void downloadSertif() {
        System.out.println("Mendownload file sertifikat Live Bootcamp: " + getTitle() + ".pdf");
    }
    
    public int getMinAttendancePercentage() { return minAttendancePercentage; }

    @Override
    public String toString() {
        return String.format("%s{minAttendance=%d%%}", super.toString(), minAttendancePercentage);
    }
}