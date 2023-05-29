package Ex1;

public class Teacher extends People{
    public String level;
    public int experience;
    public String subject;

    // P/thức khởi tạo không tham số sử dụng super
    public Teacher(){
        super();
    }

    // P/thức khởi tạo đầy đủ tham số sử dụng super
    public Teacher(String name, int age, String sex, double height, double weight, String level, int experience, String subject) {
        super(name, age, sex, height, weight);
        this.level = level;
        this.experience = experience;
        this.subject = subject;
    }

    // Getter/Setter
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // P/thức toString trả về thông tin Teacher
    @Override
    public String toString() {
        return super.toString() +
                ", Level: " + level +
                ", Experience: " + experience +
                ", Subject: " + subject;
    }
}
