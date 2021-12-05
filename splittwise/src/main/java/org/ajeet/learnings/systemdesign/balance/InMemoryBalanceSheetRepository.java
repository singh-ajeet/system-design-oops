package org.ajeet.learnings.systemdesign.balance;

import org.ajeet.learnings.systemdesign.user.User;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryBalanceSheetRepository implements BalanceSheetRepository {
    private final Map<User, Balance> balanceData;

    public InMemoryBalanceSheetRepository() {
        this.balanceData = new ConcurrentHashMap<>();
    }

    @Override
    public Balance findBalanceByUser(User user) {
        Objects.requireNonNull(user);

        return balanceData.get(user);
    }

    @Override
    public Collection<Balance> listBalance() {
        return balanceData.values();
    }

    @Override
    public void updateBalance(Map<User, Balance> balances) {
        balances.entrySet()
                .forEach(entry -> updateBalance(entry.getKey(), entry.getValue()));
    }

    @Override
    public void close() throws IOException {
        balanceData.clear();
   }

   /*
   Helper method
    */
   private void updateBalance(User user, Balance balance){
       Balance oldBalance = balanceData.get(user);
       if (oldBalance == null){
           oldBalance = balance;
       } else {
           oldBalance = oldBalance.mergeBalance(balance);
       }
       balanceData.put(user, oldBalance);
   }
}
