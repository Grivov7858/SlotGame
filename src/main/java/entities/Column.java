package entities;

import readers.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Column {
    private List<String> column;
    private final int index;
    private final FileReader fileReader;
    private static final String FILE_PATH = new File("src/main/resources/reels_template.txt")
            .getAbsolutePath();

    public Column(FileReader fileReader, int index) throws IOException {
        this.fileReader = fileReader;
        this.index = index;
        column = new ArrayList<>();
        setColumn(column);
    }

    public List<String> getColumn() {
        return column;
    }

    private void setColumn(List<String> column) throws IOException {
        String[] fileLines = this.fileReader.readFile(FILE_PATH);

        for (String fileLine : fileLines) {
            String[] arr = fileLine.split("\\s+");

            if (!(arr[this.index].equals("NA") || arr[this.index].equals(String.format("R%d", this.index)))) {
                column.add(arr[this.index]);
            }
        }
    }

}