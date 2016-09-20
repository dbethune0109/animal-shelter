import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Person {
  private String name;
  private String phone;
  private String animalType;
  private String breedType;
  private int id;


  public Person(String name, String phone, String animalType, String breedType) {
    this.name = name;
    this.phone = phone;
    this.animalType = animalType;
    this.breedType = breedType;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public String getAnimalType() {
    return animalType;
  }

  public String getBreedType() {
    return breedType;
  }

  public static List<Person> all() {
    String sql = "SELECT id, name, phone, animalType, breedType FROM Person";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Person.class);
    }
  }

  public int getId() {
    return id;
  }

 public static Person find(int id) {
     try(Connection con = DB.sql2o.open()) {
       String sql = "SELECT * FROM Person where id=:id";
       Person category = con.createQuery(sql)
         .addParameter("id", id)
         .executeAndFetchFirst(Person.class);
       return category;
     }
   }

 public List<Animal> getAnimal() {
   try(Connection con = DB.sql2o.open()) {
     String sql = "SELECT * FROM animal where personid=:id";
     return con.createQuery(sql)
       .addParameter("id", this.id)
       .executeAndFetch(Animal.class);
   }
 }

 @Override
 public boolean equals(Object otherPerson) {
   if (!(otherPerson instanceof Person)) {
     return false;
   } else {
     Person newPerson = (Person) otherPerson;
     return this.getName().equals(newPerson.getName()) &&
            this.getId() == newPerson.getId() &&
            this.getPhone().equals(newPerson.getPhone()) &&
            this.getAnimalType().equals(newPerson.getAnimalType()) &&
            this.getBreedType().equals(newPerson.getBreedType());
   }
 }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO Person(name,phone,animalType,breedType) VALUES (:name,:phone,:animalType,:breedType)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("phone", this.phone)
        .addParameter("animalType", this.animalType)
        .addParameter("breedType", this.breedType)
        .executeUpdate()
        .getKey();
    }
  }

}
