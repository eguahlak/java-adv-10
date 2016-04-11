package dk.kalhauge.lambda;

import static dk.kalhauge.lambda.Utilitities.concatenate;
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

  }
