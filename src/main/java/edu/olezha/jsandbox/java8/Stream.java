package edu.olezha.jsandbox.java8;

import edu.olezha.jsandbox.model.Person;
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
        java.util.stream.Stream
                .iterate(0, i -> i + 1)
                .limit(10)
                .forEach(i ->
                        persons.add(new Person("Name" + i, new BigDecimal(15 + i))));
        log.info("{}", persons);

        List<BigDecimal> interestedRates = persons.parallelStream()
                .map(p -> {
                    log.info("{}", p);
                    return p.getRate();
                })
                .filter(r -> r.compareTo(new BigDecimal(18)) > 0)
                .collect(Collectors.toList());
        log.info("{}", interestedRates);
        interestedRates.parallelStream()
                .forEach(new MyPrint());

        System.out.println();

        persons.parallelStream()
                .map(Person::getRate)
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
