package org.ajeet.learnings.systemdesign.split;

import org.ajeet.learnings.systemdesign.balance.Balance;
import org.ajeet.learnings.systemdesign.user.User;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class EqualSplitter extends Splitter {
    private static final Splitter INSTANCE = new EqualSplitter();

    private EqualSplitter(){}

    @Override
    public Map<User, Balance> split(SplitCommand splitCommand) {
        double amount = splitCommand.getAmountPaid() / splitCommand.getUsersSharingBill().size();

        return  splitCommand.getUsersSharingBill().stream()
                .map(user -> new Balance(user, Collections.singletonMap(splitCommand.getBillPaidByUserId(),amount)))
                .collect(Collectors.toMap(Balance::getUser, Function.identity()));
    }

    public static Splitter getInstance(){
        return INSTANCE;
    }

}
