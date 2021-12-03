package org.ajeet.learnings.systemdesign;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.ajeet.learnings.systemdesign.balance.Balance;
import org.ajeet.learnings.systemdesign.balance.InMemoryBalanceRepository;
import org.ajeet.learnings.systemdesign.user.User;
import org.ajeet.learnings.systemdesign.user.UserRepository;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SplitwiseService implements Closeable {
    private final static Logger LOG = LoggerFactory.getLogger(SplitwiseService.class);

    private final InMemoryBalanceRepository balanceRepository;
    private final UserRepository userRepository;
    private final BalanceManager balanceManager;

    public SplitwiseService(InMemoryBalanceRepository balanceRepository, UserRepository userRepository, BalanceManager balanceManager) {
        this.balanceRepository = balanceRepository;
        this.userRepository = userRepository;
        this.balanceManager = balanceManager;
    }

    public Collection<Balance> getBalanceForAll(){
        return balanceRepository.listBalance();
    }

    public Balance getBalanceForUser(String userId){
        User user = userRepository.findUserById(userId);
        if(user == null){
            return null;
        }
        return balanceRepository.findBalanceByUser(user);
    }

    public boolean createExpense(ExpenseRequest expenseRequest) {
        User billPaidByUser = findUserById(expenseRequest.getBillPaidByUserId());

        if(billPaidByUser == null){
            throw new IllegalArgumentException("Invalid request, user does not exists !!");
        }

        List<User> usersSharingBill = expenseRequest.getUsersIdsSharingBill()
                .stream()
                .map(userId -> findUserById(userId))
                .collect(Collectors.toList());

        return balanceManager.createExpense(expenseRequest);
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
