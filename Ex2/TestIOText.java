package Ex2;
import java.io.*;

public class TestIOText {

    //Tạo file có tên list_song.txt
    private static final String FILE_NAME = "list_song.txt";

    //Tạo 1 mảng chuỗi
    private static final String[] arraySong = {
            "Hello California",
            "We don’t talk any more",
            "Nắng ấm xa dần",
            "Em của ngày hôm qua",
            "Thất tình"
    };

    // Viết hàm writeDataToFileWithFileWriter()
    public static void writeDataToFileWithFileWriter() {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            for (String song : arraySong) {
                fileWriter.write(song + "\n");
            }
            System.out.println("Data viết vào file thành công dùng FileWriter.");
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    //Viết hàm readDataToFileWithFileReader()
    public static void readDataFromFileWithFileReader() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            System.out.println("Data đọc file dùng FileReader:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    //Viết hàm writeDataToFileWithBufferWriter()
    public static void writeDataToFileWithBufferedWriter() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String song : arraySong) {
                bufferedWriter.write(song);
                bufferedWriter.newLine();
            }
            System.out.println("Data viết vào file thành công dùng BufferedWriter.");
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    //Viết hàm readDataToFileWithBufferReader()
    public static void readDataFromFileWithBufferedReader() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("Data đọc file dùng BufferedReader:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}