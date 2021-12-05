package org.ajeet.learnings.systemdesign.balance;

import org.ajeet.learnings.systemdesign.user.User;

import java.util.Map;

public final class Balance {
    private final User user;
    private final Map<User, Double> ownFrom;

    public Balance(User user, Map<User, Double> ownFrom) {
        this.user = user;
        this.ownFrom = ownFrom;
    }

    public User getUser() {
        return user;
    }

    public Map<User, Double> getOwnFrom() {
        return ownFrom;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if(ownFrom == null || ownFrom.isEmpty()){
            stringBuilder.append("No balances");
        } else {
            ownFrom.entrySet()
                    .forEach(balance ->
                            stringBuilder.append(String.format("% owes %: %", user.getUserId(), balance.getKey().getUserId(), balance.getValue())));
        }
        return stringBuilder.toString();
    }

    public Balance mergeBalance(Balance balance) {
        balance.getOwnFrom()
                .entrySet()
                .forEach(entry -> {
                    User fromUser = entry.getKey();
                    ownFrom.put(fromUser, ownFrom.getOrDefault(fromUser, 0.0) + entry.getValue());
                });
        return null;
    }
}
