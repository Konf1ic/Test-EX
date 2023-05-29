package Ex2;
import static Ex2.TestIOText.*;

public class Main {
    public static void main(String[] args) {
        writeDataToFileWithFileWriter();
        readDataFromFileWithFileReader();

        System.out.println("-------------------------------------------");

        writeDataToFileWithBufferedWriter();
        readDataFromFileWithBufferedReader();
    }
}