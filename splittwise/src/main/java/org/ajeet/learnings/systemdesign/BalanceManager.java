package org.ajeet.learnings.systemdesign;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.ajeet.learnings.systemdesign.balance.Balance;
import org.ajeet.learnings.systemdesign.balance.BalanceSheetRepository;
import org.ajeet.learnings.systemdesign.split.EqualSplitter;
import org.ajeet.learnings.systemdesign.split.Splitter;
import org.ajeet.learnings.systemdesign.user.User;
import org.ajeet.learnings.systemdesign.user.UserRepository;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class BalanceManager implements Closeable {
    private final static Logger LOG = LoggerFactory.getLogger(BalanceManager.class);

    private final BalanceSheetRepository balanceRepository;
    private final UserRepository userRepository;

    public BalanceManager(BalanceSheetRepository balanceRepository, UserRepository userRepository) {
        this.balanceRepository = balanceRepository;
        this.userRepository = userRepository;
    }

    public boolean createExpense(ExpenseRequest expenseRequest) {
        switch (expenseRequest.getSplitType()){
            case EQUAL: splitEqually(expenseRequest);
            break;
            case EXACT: splitExactly(expenseRequest);
            break;
            case PERCENT: splitByPercentage(expenseRequest);
            break;
            default: throw new IllegalArgumentException("Invalid split type !!");
        }
        return false;
    }

    private void splitEqually(ExpenseRequest expenseRequest) {
        User user = userRepository.findUserById(expenseRequest.getBillPaidByUserId());
        List<User> usersSharingBill = expenseRequest.getUsersIdsSharingBill()
                .stream()
                .map(userId -> findUserById(userId))
                .collect(Collectors.toList());

        Splitter equalSplitter = new EqualSplitter(user, usersSharingBill, expenseRequest.getAmountPaid());
        Map<User, Balance> balances = equalSplitter.split();
        balanceRepository.updateBalance(balances);
    }

    public Collection<Balance> listBalance() {
        return null;
    }

    public Balance getBalance(String userId) {
        User user = userRepository.findUserById(userId);
        if(user == null){
            return null;
        }
        return balanceRepository.findBalanceByUser(user);
    }

    @Override
    public void close() throws IOException {
        try{
            balanceRepository.close();
        } catch(Exception ex) {
            LOG.error("Failed to close Balance Repository", ex);
        }

        try{
            userRepository.close();
        } catch(Exception ex) {
            LOG.error("Failed to close User Repository", ex);
        }
    }

    /*
    Utility methods
 */
    private User findUserById(String userId){
        User user = userRepository.findUserById(userId);

        if(user == null){
            throw new IllegalArgumentException("Invalid request, user does not exists !!");
        }
        return user;
    }
}
