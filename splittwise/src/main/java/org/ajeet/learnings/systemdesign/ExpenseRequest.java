package org.ajeet.learnings.systemdesign;

import org.ajeet.learnings.systemdesign.split.Split;

import java.util.List;
import java.util.Map;

public final class ExpenseRequest {
    private final String billPaidByUserId;
    private final double amountPaid;
    private final List<String> usersIdsSharingBill;
    private final Split splitType;
    private final Map<String, Object> expenseAttributes;

    public ExpenseRequest(String billPaidBy, double amountPaid, List<String> usersSharingExpense, Split splitType) {
       this(billPaidBy, amountPaid, usersSharingExpense, splitType, null);
    }

    public ExpenseRequest(String billPaidBy, double amountPaid, List<String> usersSharingExpense, Split splitType, Map<String, Object> expenseAttributes) {
        this.billPaidByUserId = billPaidBy;
        this.amountPaid = amountPaid;
        this.usersIdsSharingBill = usersSharingExpense;
        this.splitType = splitType;
        this.expenseAttributes = expenseAttributes;
    }

    public String getBillPaidByUserId() {
        return billPaidByUserId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public List<String> getUsersIdsSharingBill() {
        return usersIdsSharingBill;
    }

    public Split getSplitType() {
        return splitType;
    }

    public Map<String, Object> getExpenseAttributes() {
        return expenseAttributes;
    }

    public Object getExpenseAttributeByName(String attributeName) {
        return expenseAttributes.get(attributeName);
    }

}
