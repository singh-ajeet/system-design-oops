package org.ajeet.learnings.systemdesign.split;

import org.ajeet.learnings.systemdesign.balance.Balance;
import org.ajeet.learnings.systemdesign.user.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class EqualSplitter extends Splitter {

    public EqualSplitter(User paidBy, User[] users, double amount) {
        super(paidBy, users, amount);
    }

    @Override
    public List<Balance> split() {
        double amount = this.amount/ users.length;

        return Arrays.stream(users)
                .map(user -> new Balance(paidBy, user, amount))
                .collect(Collectors.toList());
    }
}
