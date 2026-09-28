package Inheritance;
public class Mentor extends User {
    public void ajarCourse(){
        System.out.println("anda berhasil membuat course");
        super.addXp(2);
    }
}