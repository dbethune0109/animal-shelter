import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Patients {
  private String name;
  private int age;
  private int id;
  private int doctorsId;
  private String birthday;

  public Patients(String name, int age, int doctorsId, String birthday) {
    this.name = name;
    this.age = age;
    this.doctorsId = doctorsId;
    this.birthday = birthday;
  }

  public String getName() {
    return name;
  }

  public String getBirthday() {
    return birthday;
  }

  public int getAge() {
    return age;
  }

  public void delete(){
    String sql = "DELETE from patients WHERE id = :id";
    try(Connection con = DB.sql2o.open()) {
      con.createQuery(sql, true)
        .addParameter("id", this.getId())
        .executeUpdate()
        .getKey();
    }
  }

  public int getDoctorId() {
    return doctorsId;
  }

  public int getId() {
    return id;
  }

  public static List<Patients> all() {
    String sql = "SELECT id, name, age, doctorsId, birthday FROM patients";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Patients.class);
    }
  }

  @Override
  public boolean equals(Object otherPatient){
    if (!(otherPatient instanceof Patients)) {
      return false;
    } else {
      Patients newPatient = (Patients) otherPatient;
      return this.getName().equals(newPatient.getName()) &&
             this.getId() == newPatient.getId() &&
             this.getDoctorId() == newPatient.getDoctorId() &&
             this.getAge() == newPatient.getAge() &&
             this.getBirthday().equals(newPatient.getBirthday());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO Patients(name, age, doctorsId, birthday) VALUES (:name, :age, :doctorsId, :birthday)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("doctorsId", this.doctorsId)
        .addParameter("age", this.age)
        .addParameter("birthday", this.birthday)
        .executeUpdate()
        .getKey();
    }
  }

  public static Patients find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM Patients where id=:id";
      Patients Patient = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Patients.class);
      return Patient;
    }
  }
}
