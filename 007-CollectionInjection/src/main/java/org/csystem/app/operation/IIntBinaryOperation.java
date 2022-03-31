package org.csystem.app.operation;

import java.util.function.IntBinaryOperator;

public interface IIntBinaryOperation extends IntBinaryOperator {
    boolean isValid(char op);
}