package dk.kalhauge.lambda;

import static dk.kalhauge.lambda.Utilitities.concatenate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class Program {
  
  private static void test1(List<Person> people) {
    List<String> texts = new ArrayList<String>() {{
      add("Abel");
      add("Spendabel");
      add("can I");
      add("boorow your");
      add("Sabre");
      }};
    String result = concatenate(
        p -> p.getAge() > 18 && p.getAge() < 75,
        p -> p.getFirstName()+" "+p.getLastName(),
        ",",
        people
        );
    System.out.println(result);
    
    result = concatenate(
        p -> true,
        p -> p.getFirstName(),
        ";",
        people
        );
    System.out.println(result);
    
    result = concatenate(s -> s.startsWith("S"), s -> s.toString(), " - ", texts);
    System.out.println(result);
    }
  
  private static void test2(List<Person> people) {
    String result = concatenate(p -> true, Person::getFirstName, (p, q) -> ";", people);
    System.out.println(result);
    BiFunction<Person,Person,String> delimiter = 
        (p, q) -> { int c = p.getFirstName().compareTo(q.getFirstName());
                    if (c < 0) return "<";
                    else if (c > 0) return ">";
                    else return "=";
                    };
    result = concatenate(p -> true, Person::getFirstName, delimiter, people);
    System.out.println(result);
    }
  
  private static void test3(List<Person> people) {
    String result = concatenate(
        p -> true, 
        Person::getFirstName, 
        (p, q, c) -> ";", 
        (p, q) -> 0,
        people);
    System.out.println(result);
    ComparativeDelimiter<Person> delimiter = 
        (p, q, comparator) -> {  
                        int c = comparator.compare(p, q);
                        if (c < 0) return "<";
                        else if (c > 0) return ">";
                        else return "=";
                        };
    Comparator<Person> comparator =
        (p, q) -> {
            if (p.getAge() < q.getAge()) return -1;
            else if (p.getAge() == q.getAge()) return 0;
            else return 1;
            };
    result = concatenate(
        p -> true, 
        Person::getFirstName, 
        delimiter, 
        comparator,
        people
        );
    System.out.println(result);
    }
  
  public static void main(String[] args) {
    List<Person> people = new ArrayList<Person>() {{
      add(new Person("Kurt", "Hansen", 23));
      add(new Person("Sonja", "Hansen", 35));
      add(new Person("Ib", "Hansen", 80));
      add(new Person("Maj", "Petersen", 7));
      add(new Person("Kaj", "Nielsen", 9));
      }};
    // test1(people);
    // test2(people);
    test3(people);
    }

  }
