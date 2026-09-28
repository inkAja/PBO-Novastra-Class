package Abstract;

import java.util.UUID;
import Interface.Sertification;

public class VideoCourse extends Course implements Sertification {
    private int totalVideoCount;

    public VideoCourse(UUID courseId, String title, String instructorName, int durationWeeks, int totalVideoCount) {
        super(courseId, title, instructorName, durationWeeks);
        if (totalVideoCount <= 0) throw new IllegalArgumentException("Total video count must be positive");
        this.totalVideoCount = totalVideoCount;
    }
    @Override public String getCourseType() { return "Video"; }
    @Override public boolean checkCompletionCriteria(float progressPercentage, double portfolioScore) {
        return progressPercentage >= 100.0f && portfolioScore >= 70.0;
    }
    @Override public void generateSertif() { System.out.println("Menerbitkan sertifikat kelulusan Video Course: " + getTitle()); }
    @Override public void downloadSertif() { System.out.println("Mendownload file sertifikat Video Course: " + getTitle() + ".pdf"); }
    public int getTotalVideoCount() { return totalVideoCount; }
    @Override public String toString() { return String.format("%s{totalVideos=%d}", super.toString(), totalVideoCount); }
}
