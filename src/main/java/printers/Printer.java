package printers;

import entities.Column;

import java.util.List;

public interface Printer {
    String[][] print(List<Column> list, int[] numbers);
}
