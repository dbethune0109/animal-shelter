import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Doctor {
  private String name;
  private int id;


  public Doctor(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static List<Doctor> all() {
    String sql = "SELECT id, name FROM doctor";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Doctor.class);
    }
  }

  public int getId() {
    return id;
  }


  public void delete(){
    String sql = "DELETE from doctor WHERE id = :id";
    try(Connection con = DB.sql2o.open()) {
      con.createQuery(sql, true)
        .addParameter("id", this.getId())
        .executeUpdate()
        .getKey();
    }
    String sql2 = "DELETE from tasks WHERE categoryId = :id";
    try(Connection con = DB.sql2o.open()) {
      con.createQuery(sql2, true)
        .addParameter("id", this.getId())
        .executeUpdate()
        .getKey();
    }
  }

 public static Doctor find(int id) {
     try(Connection con = DB.sql2o.open()) {
       String sql = "SELECT * FROM doctor where id=:id";
       Doctor category = con.createQuery(sql)
         .addParameter("id", id)
         .executeAndFetchFirst(Doctor.class);
       return category;
     }
   }

 public List<Patients> getPatients() {
   try(Connection con = DB.sql2o.open()) {
     String sql = "SELECT * FROM patients where doctorsId=:id";
     return con.createQuery(sql)
       .addParameter("id", this.id)
       .executeAndFetch(Patients.class);
   }
 }

 @Override
 public boolean equals(Object otherDoctor) {
   if (!(otherDoctor instanceof Doctor)) {
     return false;
   } else {
     Doctor newDoctor = (Doctor) otherDoctor;
     return this.getName().equals(newDoctor.getName()) &&
            this.getId() == newDoctor.getId();
   }
 }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO doctor(name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .executeUpdate()
        .getKey();
    }
  }

}
