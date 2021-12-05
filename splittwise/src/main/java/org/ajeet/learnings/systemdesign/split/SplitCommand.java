package org.ajeet.learnings.systemdesign.split;

import org.ajeet.learnings.systemdesign.user.User;

import java.util.List;

public class SplitCommand {
    private final User billPaidByUser;
    private final double amountPaid;
    private final List<User> usersSharingBill;


    public SplitCommand(User billPaidByUser, double amountPaid, List<User> usersIdsSharingBill) {
        this.billPaidByUser = billPaidByUser;
        this.amountPaid = amountPaid;
        this.usersSharingBill = usersIdsSharingBill;
    }

    public User getBillPaidByUserId() {
        return billPaidByUser;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public List<User> getUsersSharingBill() {
        return usersSharingBill;
    }
}
