package org.csystem.app.operation;

public class MultiplyOperation implements IIntBinaryOperation {
    @Override
    public boolean isValid(char op) {
        return op == '*' || op == 'x';
    }

    @Override
    public int applyAsInt(int left, int right) {
        return left * right;
    }
}
