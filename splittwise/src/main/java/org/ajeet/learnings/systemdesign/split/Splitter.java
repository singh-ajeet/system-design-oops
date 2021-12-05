package org.ajeet.learnings.systemdesign.split;

import org.ajeet.learnings.systemdesign.balance.Balance;
import org.ajeet.learnings.systemdesign.user.User;

import java.util.Map;

public abstract class Splitter {
    public abstract Map<User, Balance> split(SplitCommand splitCommand);
}
