package org.ajeet.learnings.systemdesign;

public final class BalanceManager {

    public boolean createExpense(ExpenseRequest expenseRequest) {
        expenseRequest.getSplitType()
                .


        switch (expenseRequest.getSplitType()){
            case EQUAL: splitEqually(expenseRequest);
            break;
            case EXACT: splitExactly(expenseRequest);
            break;
            case PERCENT: splitByPercentage(expenseRequest);
            break;
            default: throw new IllegalArgumentException("Invalid split type !!");
        }
        return false;
    }
}
