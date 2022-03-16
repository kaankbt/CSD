package com.kaankubat.createobject.component;

import org.csystem.util.console.Console;
import org.springframework.stereotype.Component;

/*

    @Component: Yazdığımız bir sınıfı component anotasyonu ile işaretlersek o sınıf türünden
nesne otamatik olarak yaratılır. Yaratılış türü default olarak 1 kez yaratılmasıdır(Singelton).
@Component sayesinde Singelton yaratılan nesneler Garbage Collector tarafından yok edilemez.

Uygulamayı run ettiğimizde nesnelerin yaratıldığını gözlemleyebilriz.

*/

@Component
public class TimePrinter {
    public TimePrinter() {
        Console.writeLine("/////////////////////////////////////////////////////");
        Console.writeLine("TimePrinter.TimePrinter()");
        Console.writeLine("/////////////////////////////////////////////////////");
    }
}
