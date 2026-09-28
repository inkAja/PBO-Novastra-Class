package Inheritance;
public class Mentor extends User {
   public void setName(String name) {
        super.setName(name);
    }
    public void ajarCourse(){
        System.out.println("anda berhasil membuat course");
    }
}