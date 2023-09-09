package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldNotCreateCreditAccountWithNegativeInitialBalance() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -1000,
                    5_000,
                    15
            );
        });
    }

    @Test
    public void shouldNotCreateCreditAccountWithNegativeCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    -5_000,
                    15
            );
        });

    }

    @Test
    public void shouldNotCreateCreditAccountWithNegativeRate() {


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    5_000,
                    -15
            );
        });
    }

    @Test
    public void shouldPay() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(true, account.pay(4999));
    }

    @Test
    public void shouldNotPayNegativeAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(false, account.pay(-1));
    }

    @Test
    public void shouldNotPayAmountUnderLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(false, account.pay(5_001));
    }

    @Test
    public void shouldPayAmountEqualLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(true, account.pay(5_000));
    }

    @Test
    public void shouldNotPayAmountNull() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(false, account.pay(0));
    }

    @Test
    public void shouldDoublePay() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(2000);
        account.pay(1000);

        Assertions.assertEquals(-3000, account.getBalance());
    }

    @Test
    public void shouldPayAmountWithInitialBalanceNotNull() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(2000);

        Assertions.assertEquals(-1000, account.getBalance());
    }

    @Test
    public void shouldAdd() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(true, account.add(1));
    }

    @Test
    public void shouldNotAddAmountLetterZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(false, account.add(-1));
    }

    @Test
    public void shouldNotAddAmountEqualsZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(false, account.add(0));
    }

    @Test
    public void shouldDoubleAdd() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(1);
        account.add(1);

        Assertions.assertEquals(2, account.getBalance());
    }

    @Test
    public void shouldAddWithNotNullInitialBalance() {
        CreditAccount account = new CreditAccount(
                1,
                5_000,
                15
        );

        account.add(1);

        Assertions.assertEquals(2, account.getBalance());
    }


    @Test
    public void shouldYearChange() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(200);

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void shouldNotYearChange() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(200);

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldYearChangeNull() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );


        Assertions.assertEquals(0, account.yearChange());
    }


}
