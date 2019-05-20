package entities;

import java.math.BigDecimal;

public class Player {
    private BigDecimal balance;
    private BigDecimal stakeMoney;

    public Player() {
        this.balance = BigDecimal.valueOf(10000);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getStakeMoney() {
        return stakeMoney;
    }

    public void setStakeMoney(BigDecimal stakeMoney) {
        this.stakeMoney = stakeMoney;
    }
}