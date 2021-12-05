package org.ajeet.learnings.systemdesign.split;

import org.ajeet.learnings.systemdesign.balance.Balance;
import org.ajeet.learnings.systemdesign.user.User;

import java.util.List;
import java.util.Map;

public abstract class Splitter {
    protected final User paidBy;
    protected final List<User> users;
    protected final double amount;

    public Splitter(User paidBy, List<User> users, double amount) {
        if(users == null || users.size() == 0){
            throw new IllegalArgumentException("users array cant be null or empty.");
        }

        if(!(amount > 0.0)){
            throw new IllegalArgumentException("amount must be greater then 0.0");
        }

        this.paidBy = paidBy;
        this.users = users;
        this.amount = amount;
    }

    public abstract Map<User, Balance> split();
}
