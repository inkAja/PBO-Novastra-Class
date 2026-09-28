package Inheritance;

import Abstract.Course;

public class User {
    private String name;
    private String email;
    private String experience_level;
    private Integer total_xp = 1;
    private Course courseDiambil;

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public Course getCourseDiambil() { return courseDiambil; }

    protected void setCourseDiambil(Course course) {
        if (course == null) throw new IllegalArgumentException("Course tidak boleh null");
        this.courseDiambil = course;
    }

    public String level() {
        if (this.total_xp < 100) this.experience_level = "Beginner";
        else if (this.total_xp < 500) this.experience_level = "Intermediate";
        else this.experience_level = "Advanced";
        return this.experience_level;
    }
    public void addXp(Integer xp) { this.total_xp += xp; }
}
