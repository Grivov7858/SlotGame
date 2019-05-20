package printers;

import entities.Column;

import java.util.List;

public class ConsolePrinter implements Printer {
    private final int NUM_OF_COLUMNS;
    private static final int NUM_OF_ROWS = 3;

    public ConsolePrinter(int numOfColumns) {
        NUM_OF_COLUMNS = numOfColumns;
    }

    @Override
    public String[][] print(List<Column> list, int[] numbers) {
        String[][] visibleArea = new String[NUM_OF_ROWS][NUM_OF_COLUMNS];

        for (int j = 0; j < NUM_OF_ROWS; j++) {
            for (int i = 0; i < NUM_OF_COLUMNS; i++) {
                int checkBounds = numbers[i];

                if (i % 2 == 0 && checkBounds == 77 && j > 0 ||
                    i % 2 == 1 && checkBounds == 74 && j > 0 ||
                    i % 2 == 0 && checkBounds == 76 && j == 2 ||
                    i % 2 == 1 && checkBounds == 73 && j == 2) {
                    checkBounds = -1;
                }
                visibleArea[j][i] = list.get(i)
                        .getColumn()
                        .get(checkBounds + j);

                System.out.print(list.get(i)
                        .getColumn()
                        .get(checkBounds + j) + "  ");
            }
            System.out.println();
        }
        return visibleArea;
    }
}