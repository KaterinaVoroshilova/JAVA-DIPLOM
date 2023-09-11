package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    SavingAccount account1 = new SavingAccount(
            4_000,
            4_000,
            6_000,
            5
    );
    SavingAccount account2 = new SavingAccount(
            7_000,
            4_000,
            7_000,
            10
    );
    CreditAccount account3 = new CreditAccount(
            0,
            5_000,
            15
    );

    SavingAccount account4 = new SavingAccount(
            7_000,
            4_000,
            13_000,
            5
    );

    SavingAccount account5 = new SavingAccount(
            4_000,
            4_000,
            11_000,
            5
    );
    SavingAccount account6 = new SavingAccount(
            6_000,
            5_000,
            11_000,
            5
    );

    @Test
    public void TransferMoreThanTheInitialAmount() {
        Bank bank = new Bank();

        Assertions.assertEquals(false,bank.transfer(account5, account4,5_000));
    }

    @Test
    public void СheckingBalanceAfterTransfer() {
        Bank bank = new Bank();

        Assertions.assertEquals(true,bank.transfer(account4, account5,3_000));
        Assertions.assertEquals(4_000,account4.getBalance());
        Assertions.assertEquals(7_000,account5.getBalance());
    }


   @Test
    public void transferToTheSameAccount() {
        Bank bank = new Bank();

        Assertions.assertEquals(false,bank.transfer(account6, account6,1_000));
    }

    @Test
    public void testFour() { // перевод отрицательной суммы
        Bank bank = new Bank();

        Assertions.assertEquals(false,bank.transfer(account6, account5,-1_000));
    }

}
