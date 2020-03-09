import entities.Player;
import exceptions.NegativeBetException;
import exceptions.NotEnoughMoneyException;

import java.util.Scanner;
import java.math.BigDecimal;

public class Slot {
    private Player player;

    public Slot() {
        this.player = new Player();
    }

    public Player getPlayer() {
        return player;
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(String
                .format("Balance: %.2f", this.player.getBalance()));
        System.out.print("Bet: ");

        String line = scanner.nextLine();
        if ( line.trim().isEmpty() ) {
            throw new IllegalArgumentException();
        } else {
            player.setStakeMoney( BigDecimal.valueOf(Double.parseDouble(line)) );

            if ( this.player.getStakeMoney().compareTo( BigDecimal.ZERO ) < 0 ) {
                throw new NegativeBetException( );
            }

            if ( this.player.getBalance().compareTo(player.getStakeMoney()) >= 0 ) {

                this.player.setBalance(this.player.getBalance().subtract(player.getStakeMoney()));
            }  else {
                throw  new NotEnoughMoneyException();
            }
        }

        System.out.println(String
                .format("Balance: %.2f", this.player.getBalance()));
    }

    public boolean winOrLose(String[][] area) {
        String check;
        int counter = 1;

        for (String[] strings : area) {
            check = strings[0];
            counter = 1;
            for (int j = 1; j < strings.length; j++) {
                if (check.equals(strings[j])) {
                    counter++;
                } else {
                    check = strings[j];
                    counter = 1;
                }

                if (counter == 3) {
                    return true;
                }
            }
        }

        int diagonalCnt1 = 1;
        for (int i = 0; i < area.length - 1; i++) {
            if (area[i][i].equals(area[i + 1][i + 1])) {
                diagonalCnt1++;
            }
            if (diagonalCnt1 == 3) {
                return true;
            }
        }

        int backCounter = 2;
        int diagonalCnt2 = 1;
        for (int i = area.length - 1; i > 0; i--) {
            if (area[i][backCounter].equals(area[i - 1][backCounter + 1])) {
                diagonalCnt2++;
            }
            if (diagonalCnt2 == 3) {
                return true;
            }
            backCounter++;
        }
        return false;
    }

    public void checkForProfit(String[][] area) {
        if (winOrLose(area) && player.getBalance().compareTo(player.getStakeMoney()) >= 0) {
            this.player.setBalance(
                    this.player.getBalance().add(
                            player.getStakeMoney()
                                    .multiply(BigDecimal.valueOf(2))));

            System.out.println(String.format("Win: %.2f",
                    player.getStakeMoney()
                            .multiply(BigDecimal.valueOf(2))));
        }
    }
}