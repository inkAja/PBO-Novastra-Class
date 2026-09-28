package Inheritance;

public class Pelajar extends User {
    public void ambilCourse(){
        System.out.println("Anda berhasil mengambil course");
    }
    public void selesaiCourse(){
        System.out.println("Anda berhasil menyelesaikan course");
        super.addXp(1);
    }
}
