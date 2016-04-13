package dk.cphbusiness.stream;

import java.util.ArrayList;
import java.util.List;

public class Program {
  
  // Implementation class
  // Internal representation
  //    ArrayList?
  //    Linked stuff
  // when to execute
  
  
  
  public static void main(String[] args) {
    List<Person> people = new ArrayList<Person>() {{
      add(new Person("Kurt", "Hansen", 23));
      add(new Person("Sonja", "Hansen", 35));
      add(new Person("Ib", "Hansen", 80));
      add(new Person("Maj", "Petersen", 7));
      add(new Person("Kaj", "Nielsen", 9));
      }};
    
    Stream<Person> stream = Stream.of(people);
    Stream<String> nameStream = 
        stream.filter(p -> p.getAge() > 17).map(Person::getFirstName);
    
    }
  
  }
