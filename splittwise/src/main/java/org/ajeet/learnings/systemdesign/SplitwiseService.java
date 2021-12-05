package org.ajeet.learnings.systemdesign;

import org.ajeet.learnings.systemdesign.balance.Balance;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;

public class SplitwiseService implements Closeable {
    private final BalanceManager balanceManager;

    public SplitwiseService(BalanceManager balanceManager) {
        this.balanceManager = balanceManager;
    }

    public Collection<Balance> getBalanceForAll(){
        return balanceManager.listBalance();
    }

    public Balance getBalanceForUser(String userId){
        return balanceManager.getBalance(userId);
    }

    public void createExpense(ExpenseRequest expenseRequest) {
        balanceManager.createExpense(expenseRequest);
    }

    @Override
    public void close() throws IOException {
        balanceManager.close();
    }


}
