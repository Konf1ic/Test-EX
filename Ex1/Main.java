package Ex1;

public class Main {
    public static void main(String[] args) {
        // Tạo People
        People person = new People("Hưng", 18, "Male", 180, 55);

        // In thông tin
        System.out.println("Sinh Viên ID:");
        System.out.println(person.toString());

        System.out.println("-----------------------");

        // Tạo một đối tượng Teacher
        Teacher teacher = new Teacher("Phí", 24, "Male", 165, 60, "ThS", 5, "IT");

        // In thông tin Teacher
        System.out.println("Giáo viên ID:");
        System.out.println(teacher.toString());
    }
}