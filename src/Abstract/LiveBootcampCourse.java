package Abstract;

import java.util.UUID;
import Interface.Sertification;

public class LiveBootcampCourse extends Course implements Sertification {
    private int minAttendancePercentage;

    public LiveBootcampCourse(UUID courseId, String title, String instructorName, int durationWeeks, int minAttendancePercentage) {
        super(courseId, title, instructorName, durationWeeks);
        if (minAttendancePercentage <= 0 || minAttendancePercentage > 100)
            throw new IllegalArgumentException("Minimum attendance percentage must be between 1 and 100");
        this.minAttendancePercentage = minAttendancePercentage;
    }
    @Override public String getCourseType() { return "Live_Bootcamp"; }
    @Override public boolean checkCompletionCriteria(float progressPercentage, double portfolioScore) {
        return progressPercentage >= minAttendancePercentage && portfolioScore >= 80.0;
    }
    @Override public void generateSertif() { System.out.println("Menerbitkan sertifikat kelulusan Live Bootcamp: " + getTitle()); }
    @Override public void downloadSertif() { System.out.println("Mendownload file sertifikat Live Bootcamp: " + getTitle() + ".pdf"); }
    public int getMinAttendancePercentage() { return minAttendancePercentage; }
    @Override public String toString() { return String.format("%s{minAttendance=%d%%}", super.toString(), minAttendancePercentage); }
}
