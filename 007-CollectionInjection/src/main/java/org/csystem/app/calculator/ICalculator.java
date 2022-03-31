package org.csystem.app.calculator;

/*
Tek metot tanımı olan arayüzler Functional interfaces olarak adlandırılarak diğer arayüzler arasında tanım olarak ayrım yapılmıştır.

Fonksiyonel arayüzleri ifade etmek için @FunctionalInterface annotations kullanılır.
 */

@FunctionalInterface
public interface ICalculator {
    void calculate() throws Exception;
}
