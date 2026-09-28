package Inheritance;
public class Inheritance {
    public static void main(String[] args) {
        Pelajar pelajar1 = new Pelajar();
        pelajar1.setName("John Doe");
        System.out.println("Pelajar Name: " + pelajar1.getName());
        pelajar1.ambilCourse();
        Mentor mentor1 = new Mentor();
        mentor1.setName("Jane Smith");
        System.out.println("Mentor Name: " + mentor1.getName());    
        mentor1.ajarCourse();
    }

}