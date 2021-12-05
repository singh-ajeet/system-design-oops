package org.ajeet.learnings.systemdesign;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.ajeet.learnings.systemdesign.balance.Balance;
import org.ajeet.learnings.systemdesign.balance.BalanceSheetRepository;
import org.ajeet.learnings.systemdesign.balance.InMemoryBalanceSheetRepository;
import org.ajeet.learnings.systemdesign.user.User;
import org.ajeet.learnings.systemdesign.user.UserRepository;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean createExpense(ExpenseRequest expenseRequest) {
        User billPaidByUser = findUserById(expenseRequest.getBillPaidByUserId());

        if(billPaidByUser == null){
            throw new IllegalArgumentException("Invalid request, user does not exists !!");
        }



        return balanceManager.createExpense(expenseRequest);
    }

    @Override
    public void close() throws IOException {
        balanceManager.close();
    }


}
