package it.scp.tests.accounts.services;

import it.scp.tests.accounts.entities.Account;
import it.scp.tests.accounts.entities.Transaction;

import java.util.List;

public interface AccountService {

    Account createNewAccount(Account account);

    Account updateAccount(Account account);

    boolean removeAccount(Account account);

    List<Transaction> listAllTransactions(Account account);

}
