package com.kaankubat.createobject.configuration;

import org.csystem.util.console.Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;

/*
    - Spring'in bu class ın bir Configuration olduğunu anlaması için @Configuration anotasyonunu kullandık
 Component de kullunılabilir ama @Configruation yazmamız daha hızlı algılanmasını sağlar.

    - localDateTime sınıfını biz yazmadık bizim yazmadık peki bunu nasıl enjekte edeceğiz nasıl Component işaretliyeceğiz ?
çözüm -> @Bean   Bean anotasyonlarını genelikle configuration paketi altına yazıyoruz.


  - @Scope("prototype) -> Her seferinde nesne yaratma gerektiğinde yarat.

  - @Scope("singleton) -> bir kere nesne yaratır.

 */


@Configuration
public class DateTimeConfig {
    @Bean("dateTimeConfigCreateNow")
    @Scope("prototype")
    public Temporal getNow()
    {
        Console.writeLine("----------------------------------");
        Console.writeLine("DateTimeConfig.createNow");
        Console.writeLine("----------------------------------");

        return LocalDateTime.now();
    }
}
