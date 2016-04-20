package dk.cphbusiness.stream;

public class Person {
  private final String firstName;
  private final String lastName;
  private final int age;

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    }

  @Override
  public String toString() {
    return firstName+" "+lastName+" is "+age+" years old";
    }
  
  

  public String getFirstName() {
    return firstName;
    }

  public String getLastName() {
    return lastName;
    }

  public int getAge() {
    return age;
    }
  
  

  }
