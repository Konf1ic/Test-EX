package Ex1;

public class People {
    public String name;
    public int age;
    public String sex;
    public double height;
    public double weight;


    // P/thức khởi tạo đầy đủ tham số
    public People(String name, int age, String sex, double height, double weight) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }

    // P/thức khởi tạo 0 tham số
    public People(){
    }

    // Getter/Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    // toString trả về thông tin People
    @Override
    public String toString() {
        return "Name: " + name +
                ", Age: " + age +
                ", Sex: " + sex +
                ", Height: " + height +
                ", Weight: " + weight;
    }
}