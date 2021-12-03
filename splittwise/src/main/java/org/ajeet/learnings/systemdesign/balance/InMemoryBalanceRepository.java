package org.ajeet.learnings.systemdesign.balance;

import org.ajeet.learnings.systemdesign.user.User;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class InMemoryBalanceRepository implements BalanceRepository {
    private final Map<User, Balance> balanceData;

    public InMemoryBalanceRepository() {
        this.balanceData = new HashMap<>();
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
    public void close() throws IOException {
        balanceData.clear();
   }
}
