package Inheritance;

public class Pelajar extends User {
    public void setName(String name) {
        super.setName(name);
    }
    public void ambilCourse(){
        System.out.println("Anda berhasil mengambil course");
    }
}
