package com.kaankubat.createobject.component;

import com.kaankubat.createobject.BeanName;
import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/*

  -  @Component: Yazdığımız bir sınıfı component anotasyonu ile işaretlersek o sınıf türünden
nesne otamatik olarak yaratılır. Yaratılış türü default olarak 1 kez yaratılmasıdır(Singelton).
@Component sayesinde Singelton yaratılan nesneler Garbage Collector tarafından yok edilemez. Componentler
isimlendirilerek çağarılma sırası ayarlanabilir.
  _____________________________________________________________________________________

  -  Uygulamayı run ettiğimizde nesnelerin yaratıldığını ve PostConstruct ile çalığırılan metodun geldiğini gözlemleyebilriz.

  _____________________________________________________________________________________

  -  @PostConstruct Görevi bir nesne oluşturulduktan hemen sonra herhangi uygulanan bir metoda giriş sağlaması ve o metodu işletmesidir.

  _____________________________________________________________________________________

  - localDateTime sınıfını biz yazmadık bizim yazmadık peki bunu nasıl enjekte edeceğiz nasıl Component işaretliyeceğiz ?
çözüm -> @Bean   Bean anotasyonlarını genelikle configuration paketi altına yazıyoruz.

 - Eğer biz beanimize birden fazla değer atama yaparsak yani spring konfigürasyon dosyasında birden fazla bean alanlarına
tanımlama yaparsak Spring bu tanımlamalarının hangisinin kullanılacağına ” @Qualifier ” anotasyonu kullanılarak çözülmektedir.
 ______________________________________________________________________________________

  - @Scope("prototype) -> Gerekltiğinde nesne yaratır

  - @Scope("singleton) -> bir kere nesne yaratır.

*/
@Component
public class DateTimePrinterCtorInjection {
    private final TemporalAccessor m_temporalAccessor;
    private final DateTimeFormatter m_formatter;

    public DateTimePrinterCtorInjection(@Qualifier("dateTimeConfigCreateNow") TemporalAccessor temporalAccessor,
                                        @Qualifier(BeanName.DATETIMEFORMATTER_BEAN_NAME) DateTimeFormatter formatter) {
        m_temporalAccessor = temporalAccessor;
        m_formatter = formatter;
    }

    @PostConstruct
    public void printDateTime() {
        Console.writeLine("DateTimePrinterCtorInjection:Now:%s", m_formatter.format(m_temporalAccessor));
    }
}