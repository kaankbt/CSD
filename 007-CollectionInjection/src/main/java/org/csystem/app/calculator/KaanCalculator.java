package org.csystem.app.calculator;

import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KaanCalculator implements ICalculator {
    // Sample Calculator enjekte işlemi
    private final IlkaySimpleCalculator m_sampleCalculator;

    // Bu bean bulunmazsa,  0 döner("a:0")
    @Value("${kaan.calculator.a:0}")
    private int m_a;
    // Bu bean bulunmazsa, 0 döner("a:0")
    @Value("${kaan.calculator.b:0}")
    private int m_b;
    // Bu bean bulunmazsa, + döner("a:0")
    @Value("${kaan.calculator.b:+}")
    private char m_op;


    public KaanCalculator(IlkaySimpleCalculator m_sampleCalculator) {
        this.m_sampleCalculator = m_sampleCalculator;
    }

    @Override
    public void calculate() throws Exception {

        Console.writeLine("Kaan Calculator");
        m_sampleCalculator.calculate(m_a, m_b, m_op);
    }
}
