package Ex3;
import java.io.*;
import java.util.ArrayList;

public class Computer {
    private String code;
    private String name;
    private String manufacturer;
    private String config;
    private double price;
    private String status;

    // P/thức khởi tạo không tham số
    public Computer() {
        ArrayList<Computer> computerList = new ArrayList<>();
        Computer[] computers = computerList.toArray(new Computer[0]);
    }

    // P/thức khởi tạo full tham số
    public Computer(String code, String name, String manufacturer, String configuration, double price, String status) {
        this.code = code;
        this.name = name;
        this.manufacturer = manufacturer;
        this.config = configuration;
        this.price = price;
        this.status = status;
    }

    //Getter/Setter
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    //Phương thức thêm 1 máy tính vào danh sách
    public void addComputerToArray(ArrayList<Computer> computerList) {
        computerList.add(this);
    }


    //Phương thức lưu 1 máy tính vào file
    public void addComputerToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt", true))) {
            writer.write(this.toString());
            writer.newLine();
            System.out.println("Data của Computer được thêm vào file thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }


    //Phương thức trả về thông tin của 1 file
    public static Computer[] getDataFromFile() {
        ArrayList<Computer> computerList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("database.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    String code = data[0];
                    String name = data[1];
                    String manufacturer = data[2];
                    String configuration = data[3];
                    double price = Double.parseDouble(data[4]);
                    String status = data[5];

                    Computer computer = new Computer(code, name, manufacturer, configuration, price, status);
                    computerList.add(computer);
                } else {
                    System.out.println("Data hợp lệ: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        return computerList.toArray(new Computer[0]);
    }


    //Phương thức lưu danh sách máy tính vào file
    public static void addComputersToFile(ArrayList<Computer> computerList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt"))) {
            for (Computer computer : computerList) {
                writer.write(computer.toString());
                writer.newLine();
            }
            System.out.println("Data của Computers đã được thêm vào file thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }


    //Phương thức đọc và trả về danh sách máy tính trong file
    public static void getAllComputerFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("database.txt"))) {
            String line;
            System.out.println("Data của Computers đọc từ file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return code + "," + name + "," + manufacturer + "," + config + "," + price + "," + status;
    }
}

class AppComputer {
    public static void main(String[] args) {
        // Tạo file database.txt
        createDatabaseFile();

        // Tạo 5 đối tượng Computer với thông tin khác nhau
        Computer computer1 = new Computer("PC001", "Laptop Acer", "Acer", "Intel i5, 8GB RAM, 256GB SSD", 1200.0, "In stock");
        Computer computer2 = new Computer("PC002", "Desktop Dell", "Dell", "Intel i7, 16GB RAM, 1TB HDD", 1500.0, "Out of stock");
        Computer computer3 = new Computer("PC003", "Macbook Pro", "Apple", "Intel i9, 16GB RAM, 512GB SSD", 2500.0, "In stock");
        Computer computer4 = new Computer("PC004", "Lenovo ThinkPad", "Lenovo", "Intel i5, 8GB RAM, 256GB SSD", 1100.0, "In stock");
        Computer computer5 = new Computer("PC005", "Asus ROG", "Asus", "AMD Ryzen 7, 16GB RAM, 1TB SSD", 1800.0, "Out of stock");

        // Lưu từng đối tượng vào file database.txt
        computer1.addComputerToFile();
        computer2.addComputerToFile();
        computer3.addComputerToFile();
        computer4.addComputerToFile();
        computer5.addComputerToFile();

        // Hiển thị thông tin từ file database.txt
        System.out.println("Data từ database.txt:");
        Computer[] computersFromFile = Computer.getDataFromFile();
        for (Computer computer : computersFromFile) {
            System.out.println(computer.toString());
        }

        System.out.println("--------------------------------------------------");

        // Lưu mảng đối tượng vào file database.txt
        ArrayList<Computer> computerList = new ArrayList<>();
        computer1.addComputerToArray(computerList);
        computer2.addComputerToArray(computerList);
        computer3.addComputerToArray(computerList);
        computer4.addComputerToArray(computerList);
        computer5.addComputerToArray(computerList);

        Computer.addComputersToFile(computerList);

        // Hiển thị thông tin từ file database.txt
        System.out.println("Data từ database.txt:");
        Computer.getAllComputerFromFile();
    }

    public static void createDatabaseFile() {
        try {
            File file = new File("database.txt");
            if (file.createNewFile()) {
                System.out.println("Tạo database.txt thành công.");
            } else {
                System.out.println("File database.txt đã tồn tại.");
            }
        } catch (IOException e) {
            System.out.println("Lỗi tạo file database.txt: " + e.getMessage());
        }
    }
}