import entities.Column;
import entities.Player;
import printers.ConsolePrinter;
import printers.Printer;
import readers.FileReader;
import readers.FileReaderImpl;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static int NUM_OF_COLUMNS = 5;

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReaderImpl();
        Printer printer = new ConsolePrinter(NUM_OF_COLUMNS);
        List<Column> columns = new ArrayList<>();
        Slot slot = new Slot();

        for (int i = 1; i <= NUM_OF_COLUMNS; i++) {
            columns.add(new Column(fileReader, i));
        }

        while (slot.getPlayer().getBalance().compareTo(BigDecimal.valueOf(0)) > 0) {

            int[] randNumbers = getRandNumbers();
            try {
                slot.play();
                String[][] visibleArea = printer.print(columns, randNumbers);
                slot.checkForProfit(visibleArea);
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong input for Bet!");
            }
        }
    }

    private static int[] getRandNumbers() {
        int[] randNumbers = new int[NUM_OF_COLUMNS];

        for (int i = 0; i < randNumbers.length; i++) {
            if (i % 2 == 0) {
                randNumbers[i] = (int) (Math.random() * 78);
            } else {
                randNumbers[i] = (int) (Math.random() * 75);
            }
        }

        return randNumbers;
    }
}