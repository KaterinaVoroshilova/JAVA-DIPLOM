package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldNotAffectBalanceWhenAddZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldNotExceedMaxBalanceWhenAddMoreThanMax() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(15_000);

        Assertions.assertEquals(10_000, account.getBalance());
    }

    @Test
    public void shouldNotGoBelowMinBalanceWhenAddNegativeAmount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-5_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void balanceReplenishmentIsBelowrMin() {
                    SavingAccount account = new SavingAccount(
                            0,
                            4_000,
                            6_000,
                            5
                    );

                    account.add(3_000);

        Assertions.assertEquals(false, account.getBalance());
    }

    @Test
    public void minBalanceMoreMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    100,
                    500,
                    500,
                    5
            );
        });
    }

    @Test
    public void initBalanceEqualMaxBalance() {
        SavingAccount account = new SavingAccount(
                500,
                200,
                500,
                10
        );

        Assertions.assertEquals(true, account.pay(500));
    }
}

