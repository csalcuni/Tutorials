package it.scp.tests.accounts.services;

import it.scp.tests.accounts.entities.Account;
import it.scp.tests.accounts.entities.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    @Override
    public Account createNewAccount(Account account) {
        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        account.setName("Carlo Salcuni Updated");
        return account;
    }

    @Override
    public boolean removeAccount(Account account) {
        return true;
    }

    @Override
    public List<Transaction> listAllTransactions(Account account) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction());
        transactions.add(new Transaction());
        transactions.add(new Transaction());
        transactions.add(new Transaction());
        account.setTransactions(transactions);

        return account.getTransactions();
    }

}
