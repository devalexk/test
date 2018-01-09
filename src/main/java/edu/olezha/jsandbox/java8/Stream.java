package edu.olezha.jsandbox.java8;

import edu.olezha.jsandbox.core.Person;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by oleh on 09.01.18.
 */
@Slf4j
public class Stream {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            persons.add(new Person("Name" + i, new BigDecimal(15 + i)));
        log.info("{}", persons);

        List<BigDecimal> interastedRates = persons.parallelStream()
                .map(p -> p.getRate())
                .filter(r -> r.compareTo(new BigDecimal(18)) > 0)
                .collect(Collectors.toList());
        log.info("{}", interastedRates);
        interastedRates.parallelStream()
                .forEach(new MyPrint());

        System.out.println();

        persons.parallelStream()
                .map(p -> p.getRate())
                .filter(r -> r.compareTo(new BigDecimal(18)) > 0)
                .forEach(r -> System.out.print(r + " "));
    }
}

class MyPrint implements Consumer<BigDecimal> {

    @Override
    public void accept(BigDecimal bigDecimal) {
        System.out.print(bigDecimal + " ");
    }
}
