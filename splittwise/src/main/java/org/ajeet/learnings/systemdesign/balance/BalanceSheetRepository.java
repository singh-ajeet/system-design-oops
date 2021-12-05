package org.ajeet.learnings.systemdesign.balance;

import org.ajeet.learnings.systemdesign.user.User;

import java.io.Closeable;
import java.util.Collection;
import java.util.Map;

public interface BalanceSheetRepository extends Closeable {
    public Balance findBalanceByUser(User user);
    public Collection<Balance> listBalance();
    public void updateBalance(Map<User, Balance> balances);
}
