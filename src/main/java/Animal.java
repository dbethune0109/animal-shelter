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

}
