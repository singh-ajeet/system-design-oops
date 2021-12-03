package org.ajeet.learnings.systemdesign.balance;

import org.ajeet.learnings.systemdesign.user.User;

public final class Balance {
    private final User user;
    private final User ownFrom;
    private final double amount;

    public Balance(User ownBy, User ownFrom, double amount) {
        this.user = ownBy;
        this.ownFrom = ownFrom;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public User getOwnFrom() {
        return ownFrom;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("% owes %: %", user.getUserId(), ownFrom.getUserId(), amount);
    }
}
