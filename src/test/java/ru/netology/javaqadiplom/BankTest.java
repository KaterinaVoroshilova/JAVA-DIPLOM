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
            4_000,
            4_000,
            6_000,
            5
    );

    SavingAccount account5 = new SavingAccount(
            4_000,
            4_000,
            11_000,
            5
    );

    @Test
    public void test() {
        Bank bank = new Bank();

        Assertions.assertEquals(false,bank.transfer(account4, account5,5_000));
    }

    @Test
    public void shouldTransferSavingToSaving() {
        Bank bank = new Bank();

        Assertions.assertEquals(true,bank.transfer(account2, account1,2_000));
    }

    @Test
    public void shouldNotTransferSavingToSavingBalanceLetterMin() {
        Bank bank = new Bank();

        Assertions.assertEquals(false,bank.transfer(account1, account2,2_000));
    }
    @Test
    public void shouldNotTransferSavingToSavingBalanceBiggerMax() {
        Bank bank = new Bank();

        Assertions.assertEquals(false,bank.transfer(account2, account1,3_000));
    }

    @Test
    public void shouldTransferCreditToSaving() {
        Bank bank = new Bank();

        Assertions.assertEquals(true,bank.transfer(account3, account1,2_000));
    }

    @Test
    public void shouldNotTransferCreditToSavingAmountBiggerCreditLimit() {
        Bank bank = new Bank();

        Assertions.assertEquals(false,bank.transfer(account3, account1,5_001));
    }

}
