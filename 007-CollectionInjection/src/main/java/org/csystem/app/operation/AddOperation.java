package org.csystem.app.operation;

public class AddOperation implements IIntBinaryOperation {

    @Override
    public boolean isValid(char op) {
        return op == '+';
    }

    @Override
    public int applyAsInt(int left, int right) {
        return left + right;
    }
}
