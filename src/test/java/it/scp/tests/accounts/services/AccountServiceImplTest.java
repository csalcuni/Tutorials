package it.scp.tests.accounts.services;

import it.scp.tests.accounts.entities.Account;
import it.scp.tests.accounts.entities.Transaction;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AccountServiceImplTest {

    AccountService accountService = new AccountServiceImpl();

    /**
     * Test method for {@link AccountServiceImpl#createNewAccount(Account)}
     */
    @Test
    public void testCreateNewAccount() throws Exception {
        Account account = new Account();
        account.setName("Carlo Salcuni");
        account.setDescription("This is a description");

        Account accountInserted = accountService.createNewAccount(account);
        assertThat(account, isA(Account.class));
        assertEquals(account.getName(), accountInserted.getName());
    }

    @Test
    public void testUpdateAccount() throws Exception {
        Account oldAccount = new Account();
        oldAccount.setName("Carlo Salcuni");
        oldAccount.setDescription("This is a description");

        String name = oldAccount.getName();
        Account expectedAccount = accountService.updateAccount(oldAccount);
        assertThat(expectedAccount, isA(Account.class));
        assertNotEquals(name, expectedAccount.getName());
    }

    @Test
    public void testRemoveAccount() throws Exception {
        Account toBeRemovedAccount = new Account();
        toBeRemovedAccount.setName("Carlo Salcuni");
        toBeRemovedAccount.setDescription("This is a description");

        assertTrue(accountService.removeAccount(toBeRemovedAccount));
    }

    @Test
    public void testListAllTransactions() throws Exception {
        Account account = new Account();
        account.setName("Carlo Salcuni");

        List<Transaction> transactions = accountService.listAllTransactions(account);

        assertTrue(transactions.size() > 0);
    }
}
