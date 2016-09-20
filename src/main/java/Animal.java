import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Animal {
  private String name;
  private String gender;
  private String dta;
  private String breed;
  private String type;
  private int personid;
  private int id;

  public Animal (String name, String gender, String dta, String breed, String type, int personid) {
    this.name = name;
    this.gender = gender;
    this.dta = dta;
    this.breed = breed;
    this.personid = personid;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public String getGender() {
    return gender;
  }

  public String getDta() {
    return dta;
  }

  public String getBreed() {
    return breed;
  }

  public String getType() {
    return type;
  }

  public int getId() {
    return id;
  }

  public int getPersonid () {
    return personid;
  }

  public static List<Animal> all() {
    String sql = "SELECT id, name, gender, dta, breed, type, personid FROM animal";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Animal.class);
    }
  }

  @Override
  public boolean equals(Object otherAnimal){
    if (!(otherAnimal instanceof Animal)) {
      return false;
    } else {
      Animal newAnimal = (Animal) otherAnimal;
      return this.getName().equals(newAnimal.getName()) &&
             this.getId() == newAnimal.getId() &&
             this.getPersonid() == newAnimal.getPersonid() &&
             this.getGender().equals(newAnimal.getGender()) &&
             this.getDta().equals(newAnimal.getDta()) &&
             this.getBreed().equals(newAnimal.getBreed()) &&
             this.getType().equals(newAnimal.getType());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animal(name, gender, dta, type, breed, personid) VALUES (:name, :gender, :dta, :type, :breed, :personid)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("personid", this.personid)
        .addParameter("gender", this.gender)
        .addParameter("dta", this.dta)
        .addParameter("type", this.type)
        .addParameter("breed", this.breed)
        .addParameter("personid", this.personid)
        .executeUpdate()
        .getKey();
    }
  }

  public static Animal find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animal where id=:id";
      Animal found = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Animal.class);
      return found;
    }
  }

}
