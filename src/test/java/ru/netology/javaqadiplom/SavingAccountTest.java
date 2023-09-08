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
    public void ReplenishmentOfTheBalanceWhenInit() {
                    SavingAccount account = new SavingAccount(
                            3_000,
                            3_000,
                            6_000,
                            5
                    );

                    account.add(2_000);

        Assertions.assertEquals(5_000, account.getBalance());
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
}
