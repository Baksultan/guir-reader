import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class GUIDComparator {

    public File compareFiles(File fileA, File fileB) throws IOException {
        Set<String> guidSetA = readGuidsFromFile(fileA);
        Set<String> guidSetB = readGuidsFromFile(fileB);
        Set<String> missingGuids = new HashSet<>(guidSetA);
        missingGuids.removeAll(guidSetB);

        File outputFile = new File("missing_guids.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String guid : missingGuids) {
                writer.write(guid);
                writer.newLine();
            }
        }

        return outputFile;
    }

    private Set<String> readGuidsFromFile(File file) throws IOException {
        Set<String> guidSet = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                guidSet.add(line.trim());
            }
        }
        return guidSet;
    }
}
