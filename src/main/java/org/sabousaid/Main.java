package org.sabousaid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
/*
@ComponentScan(basePackages = "org.sabousaid")
@EnableAutoConfiguration
@Configuration
* */
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public GreetRecord greet() {
        GreetRecord greetRecord = new GreetRecord(
                "Hello World !!",
                List.of("JAVA", "JS", "NODEJS"),
                new Person("Ali", 29, 70_000)
        );
        return greetRecord;
    }

    record Person(String name, int age, double savings) {

    }
    record GreetRecord(String greet, List<String> favProgrammingLanguages, Person person) {}

   /* class GreetRecord {
        private final String greet;

        GreetRecord(String greet) {
            this.greet = greet;
        }

        public String getGreet() {
            return greet;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof GreetRecord that)) return false;
            return Objects.equals(getGreet(), that.getGreet());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getGreet());
        }
    }*/
}
