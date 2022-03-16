package com.kaankubat.createobject.component;

import org.csystem.util.console.Console;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*

  - @Component: Yazdığımız bir sınıfı component anotasyonu ile işaretlersek o sınıf türünden
nesne otamatik olarak yaratılır. Yaratılış türü default olarak 1 kez yaratılmasıdır(Singelton).
@Component sayesinde Singelton yaratılan nesneler Garbage Collector tarafından yok edilemez. Componentler
isimlendirilerek çağarılma sırası ayarlanabilir

  -  @Lazy: İstenmeden nesne yaratılmıyacak istediğindede 1 tane yaratılacak

  -  Uygulamayı run ettiğimizde nesnelerin yaratıldığını ve PostConstruct ile çalığırılan metodun geldiğini gözlemleyebilriz.

  -  @PostConstruct Görevi bir nesne oluşturulduktan hemen sonra herhangi uygulanan bir metoda giriş sağlaması ve o metodu işletmesidir.

*/

@Component
//@Lazy
public class DateTimePrinter {

    public DateTimePrinter() {
        Console.writeLine("/////////////////////////////////////////////////////");
        Console.writeLine("DateTimePrinter.DateTimePrinter()");
        Console.writeLine("/////////////////////////////////////////////////////");
    }

    @PostConstruct
    public void printDateTime() {

        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

        Console.writeLine(formatter.format(LocalDateTime.now()));
    }
}
