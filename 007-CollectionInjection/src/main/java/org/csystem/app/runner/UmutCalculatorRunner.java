package org.csystem.app.runner;

import org.csystem.app.calculator.ICalculator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UmutCalculatorRunner implements ApplicationRunner {
    private final ICalculator m_calculator;

    public UmutCalculatorRunner(@Qualifier("denizCalculator") ICalculator calculator) {
        m_calculator = calculator;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        m_calculator.calculate();
    }
}