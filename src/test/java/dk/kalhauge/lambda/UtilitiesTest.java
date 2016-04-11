package dk.kalhauge.lambda;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static dk.kalhauge.lambda.Utilitities.concatenate;
import static org.hamcrest.CoreMatchers.is;

public class UtilitiesTest {
  
  @Test
  public void testConcatenatePeople() {
    List<Person> people = new ArrayList<Person>() {{
      add(new Person("Kurt", "Hansen", 23));
      add(new Person("Sonja", "Hansen", 35));
      add(new Person("Ib", "Hansen", 80));
      add(new Person("Maj", "Petersen", 7));
      add(new Person("Kaj", "Nielsen", 9));
      }};
    String result = concatenate(
        p -> true,
        p -> p.getFirstName(),
        ";",
        people
        );
    System.out.println(result);
    assertThat(result, is("Kurt;Sonja;Ib;Maj;Kaj"));
    
    }
  
}
