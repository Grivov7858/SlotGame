package readers;

import java.io.*;

public class FileReaderImpl implements FileReader {
    private static final int NUM_OF_LINES = 79;

    @Override
    public String[] readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                new FileInputStream(
                new File(filePath))));

        String[] fileLines = new String[NUM_OF_LINES];
        String line;
        int i = 0;

        while ((line = reader.readLine()) != null) {
            fileLines[i++] = line;
        }
        return fileLines;
    }
}