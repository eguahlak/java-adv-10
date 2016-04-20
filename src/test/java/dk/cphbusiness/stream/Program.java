package dk.cphbusiness.stream;

import java.util.ArrayList;
import java.util.List;

public class Program {
    
  public static void main(String[] args) {
    List<Person> people = new ArrayList<Person>() {{
      add(new Person("Kurt", "Hansen", 23));
      add(new Person("Sonja", "Hansen", 35));
      add(new Person("Ib", "Hansen", 80));
      add(new Person("Maj", "Petersen", 7));
      add(new Person("Kaj", "Nielsen", 9));
      }};
    
    Stream<Person> stream = Stream.of(people);
    stream.forEach(p -> { System.out.println(p.getFirstName()); });
    System.out.println("-----");
    stream
        .filter(p -> p.getAge() > 18)
        .map(p -> p.getFirstName())
        .forEach(f -> { System.out.println(f); });
    System.out.println("-----");
    stream.map(Person::getLastName).forEach(System.out::println);
    System.out.println("-----");
    int total = Stream.of(people)
        .filter(p -> p.getLastName().equals("Hansen"))
        .map(p -> p.getAge())
        .reduce(0, (r, a) -> r + a);
    System.out.println("Total Hansen age is "+total);
    
    }
  
  }
