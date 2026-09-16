package ru.algobank.algo.step03;


import java.util.List;
import java.util.Optional;

public class OptionalPlayground {
    public static void main(String[] args) {

        //Так не делаем, поле String, в геттере возвращаем Optional<String>
        Optional<String> a = Optional.of("hello");
        Optional<String> b = Optional.ofNullable(null);
        Optional<String> c = Optional.empty();

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        System.out.println(a.get());
        System.out.println(b.orElse("default"));
        System.out.println(c.orElseGet(() -> "lazy"));

        long start = System.nanoTime();
        String s1 = a.orElseGet(() -> {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            return "computed";
        });
        long elapsed1 = (System.nanoTime() - start) / 1_000_000;
        System.out.println("orElseGet на непустом: " + s1 + " (" + elapsed1 + " мс)");

        start = System.nanoTime();
        String s2 = b.orElseGet(() -> {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            return "computed";
        });
        long elapsed2 = (System.nanoTime() - start) / 1_000_000;
        System.out.println("orElseGet на пустом: " + s2 + " (" + elapsed2 + " мс)");

        a.ifPresent(System.out::println);
        b.ifPresent(System.out::println);

        Optional<Integer> len = a.map(String::length);
        System.out.println("Длина hello: " + len);

        Optional<Integer> lenEmpty = b.map(String::length);
        System.out.println("Длина null: " + lenEmpty);

        Optional<String> longWord = a.filter(s -> s.length() > 3);
        System.out.println("Длинное: " + longWord);

        Optional<String> shortWord = a.filter(s -> s.length() > 10);
        System.out.println("Длиннее 10: " + shortWord);

        // Без Optional — "пирамида смерти"
        User user = new User(null);
        String city1 = null;
        if (user != null && user.getAddress() != null && user.getAddress().getCity() != null) {
            city1 = user.getAddress().getCity().toUpperCase();
        }
        System.out.println("City (old way): " + city1);  // null

        String city2 = Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getCity)
                .map(String::toUpperCase)
                .orElse("Unknow");
        System.out.println("City (Optional): " + city2);

        List<String> users = List.of("alice", "bob", "carol");
        Optional<String> found = users.stream()
                .filter(s -> s.startsWith("c"))
                .findFirst();
        System.out.println("found: " + found.orElse("not found"));

        try {
            Optional.of(null);
        } catch (NullPointerException e) {
            System.out.println("Optional.of(null) → NPE ✅");
        }
    }

    //Вспомогательные классы
    static class User {
        private final Address address;

        User(Address address) {
            this.address = address;
        }

        public Address getAddress() {
            return address;
        }
    }

    static class Address {
        private final String city;

        Address(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }
    }

}
