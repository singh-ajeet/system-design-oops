package org.ajeet.learnings.systemdesign.split;

import org.ajeet.learnings.systemdesign.balance.Balance;
import org.ajeet.learnings.systemdesign.user.User;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class EqualSplitter extends Splitter {

    public EqualSplitter(User paidBy, List<User> users, double amount) {
        super(paidBy, users, amount);
    }

    @Override
    public Map<User, Balance> split() {
        double amount = this.amount/ users.size();

        return users.stream()
                .map(user -> new Balance(user, Collections.singletonMap(paidBy,amount)))
                .collect(Collectors.toMap(Balance::getUser, Function.identity()));
    }
}
