package org.ajeet.learnings.systemdesign.balance;

import org.ajeet.learnings.systemdesign.user.User;

import java.io.Closeable;
import java.util.Collection;

public interface BalanceRepository extends Closeable {
    public Balance findBalanceByUser(User user);
    public Collection<Balance> listBalance();
}
