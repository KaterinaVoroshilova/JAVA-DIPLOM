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
            7_000,
            15
    );

    SavingAccount account4 = new SavingAccount(
            7_000,
            4_000,
            13_000,
            5
    );

    @Test
    public void TransferMoreThanTheInitialAmount() {
        Bank bank = new Bank();

        Assertions.assertEquals(false,bank.transfer(account1, account4,5_000));
    }

    @Test
    public void СheckingBalanceAfterTransfer() {
        Bank bank = new Bank();

        Assertions.assertEquals(true,bank.transfer(account2, account4,2_000));
        Assertions.assertEquals(5_000,account2.getBalance());
        Assertions.assertEquals(9_000,account4.getBalance());
    }

    @Test
    public void negativeAmountTransfer() {
        Bank bank = new Bank();

        Assertions.assertEquals(false,bank.transfer(account4, account1,-1_000));
    }

    @Test
    public void NotTransferCreditToSavingAmountBiggerCreditLimit() {
        Bank bank = new Bank();

        Assertions.assertEquals(false,bank.transfer(account3, account1,7_001));
    }

    @Test
    public void shouldTransferSavingToSaving() {
        Bank bank = new Bank();

        Assertions.assertEquals(true,bank.transfer(account2, account1,2_000));
    }

    @Test
    public void NotTransferSavingToSavingBalanceLetterMin() {
        Bank bank = new Bank();

        Assertions.assertEquals(false,bank.transfer(account1, account2,2_000));
    }
    @Test
    public void NotTransferSavingToSavingBalanceBiggerMax() {
        Bank bank = new Bank();

        Assertions.assertEquals(false,bank.transfer(account2, account1,3_000));
    }

    @Test
    public void TransferCreditToSaving() {
        Bank bank = new Bank();

        Assertions.assertEquals(true,bank.transfer(account3, account1,2_000));
    }

    @Test
    public void doNotTransferCreditMoreThanTheMax() {
        Bank bank = new Bank();

        Assertions.assertEquals(false,bank.transfer(account3, account1,4_000));
        Assertions.assertEquals(0,account3.getBalance());
        Assertions.assertEquals(4000,account1.getBalance());
    }


}
