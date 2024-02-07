import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File fileA = new File("FileA.txt");
        File fileB = new File("FileB.txt");
        GUIDComparator guidComparator = new GUIDComparator();

        try {
            File outputFile = guidComparator.compareFiles(fileA, fileB);
            System.out.println("Comparison completed successfully. Results written to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

    }
}
