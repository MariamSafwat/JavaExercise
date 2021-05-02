import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter character");

        char searchChar = inputObj.next().charAt(0);  // Read user input

        Scanner testFile = new Scanner(new FileInputStream("D:\\AI_Pro\\Java\\Day3\\Assignment\\src\\test.txt"));
        //char searchChar = 'e';
        int count = 0;
        while (testFile.hasNextLine()) {
            String line = testFile.nextLine();
            //System.out.println(line.length());
            for (int i = 0; i < line.length(); i++) {

                if (line.charAt(i) == searchChar) {
                    count ++;
                }
            }

        }
        System.out.println(count);
    }
}
