package Inheritance;
public class Inheritance {
    public static void main(String[] args) {
        Pelajar pelajar1 = new Pelajar();
        pelajar1.setName("Saya sendiri");
        System.out.println("Nama Pelajar: " + pelajar1.getName());
        pelajar1.ambilCourse();
        pelajar1.selesaiCourse();
        System.out.println("Level Pelajar: " + pelajar1.level());
        Mentor mentor1 = new Mentor();
        mentor1.setName("Budi");
        System.out.println("Nama Mentor: " + mentor1.getName());    
        mentor1.ajarCourse();
    }

}