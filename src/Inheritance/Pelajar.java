package Inheritance;

import Abstract.Course;

public class Pelajar extends User {
    public void ambilCourse(Course course) {
        setCourseDiambil(course);
        System.out.println("Anda berhasil mengambil course: " + course.getTitle());
    }
    public void selesaiCourse() {
        if (getCourseDiambil() == null) {
            System.out.println("Anda belum mengambil course");
            return;
        }
        System.out.println("Anda berhasil menyelesaikan course: " + getCourseDiambil().getTitle());
        System.out.println("Anda Mendapat 1 XP");
        addXp(1);
    }
}
