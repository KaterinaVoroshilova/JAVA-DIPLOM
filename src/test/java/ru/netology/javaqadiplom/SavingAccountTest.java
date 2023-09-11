package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldNotCreateSavingAccountWithNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(
                    -1_000,
                    6_000,
                    15_000,
                    12
            );
        });
    }

    @Test
    public void shouldNotCreateSavingAccountWithNegativeMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(
                    1_000,
                    -5_000,
                    10_000,
                    15
            );
        });
    }

    @Test
    public void shouldNotCreateSavingAccountWithNegativeMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(
                    1_000,
                    5_000,
                    -1_000,
                    15
            );
        });
    }

    @Test
    public void shouldNotCreateSavingAccountWithNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(
                    1_000,
                    5_000,
                    10_000,
                    -15
            );
        });
    }

    @Test
    public void minBalanceMoreMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    15_000,
                    6_000,
                    12
            );
        });
    }

    @Test
    public void shouldNotCreateSavingAccountWithInitialBalanceLetterMin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(
                    1_000,
                    5_000,
                    10_000,
                    15
            );
        });
    }

    @Test
    public void shouldNotCreateSavingAccountWithInitialBalanceLetterMax() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(
                    11_000,
                    5_000,
                    9_000,
                    15
            );
        });
    }

    @Test
    public void shouldPay() {
        SavingAccount account = new SavingAccount(
                1_000,
                0,
                10_500,
                5
        );

        Assertions.assertEquals(true, account.pay(999));
    }

    @Test
    public void shouldNotPayNegativeAmount() {
        SavingAccount account = new SavingAccount(
                1_000,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(false, account.pay(-1));
    }

    @Test
    public void shouldNotPayAmountBiggerBalance() {
        SavingAccount account = new SavingAccount(
                1_000,
                0,
                10_500,
                15
        );

        Assertions.assertEquals(false, account.pay(1001));
    }

    @Test
    public void shouldNotPayAmountEqualBalance() {
        SavingAccount account = new SavingAccount(
                1_000,
                0,
                10_000,
                15
        );

        Assertions.assertEquals(true, account.pay(1000));
    }

    @Test
    public void shouldNotPayAmountNull() {
        SavingAccount account = new SavingAccount(
                1_000,
                0,
                10_500,
                15
        );

        Assertions.assertEquals(false, account.pay(0));
    }

    @Test
    public void shouldDoublePay() {
        SavingAccount account = new SavingAccount(
                1_000,
                0,
                10_000,
                15
        );

        account.pay(300);
        account.pay(700);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAdd() {
        SavingAccount account = new SavingAccount(
                0,
                0,
                10_000,
                15
        );

        Assertions.assertEquals(true, account.add(1));
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

        Assertions.assertEquals(2_000, account.getBalance());
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

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void negativeBalancePay() {
        SavingAccount account = new SavingAccount(
                100,
                50,
                500,
                5
        );

        account.pay(200);

        Assertions.assertEquals(100, account.getBalance());
    }

    @Test
    public void minBalanceEqualsMaxBalance() {
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

        Assertions.assertEquals(false, account.pay(500));
    }

    @Test
    public void initBalanceEqualMinBalance() {
        SavingAccount account = new SavingAccount(
                200,
                200,
                300,
                5
        );

        Assertions.assertEquals(false, account.pay(200));
    }

    @Test
    public void balanceReplenishmentIsHigherMax() {
        SavingAccount account = new SavingAccount(
                4_000,
                4_000,
                6_000,
                5
        );

        account.add(6_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void balanceReplenishmentIsBelowMin() {
        SavingAccount account = new SavingAccount(
                4_000,
                4_000,
                6_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

}