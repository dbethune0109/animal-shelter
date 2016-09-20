import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;

public class PersonTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/animal_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteAnimalQuery = "DELETE FROM animal *;";
      String deletePersonQuery = "DELETE FROM person *;";
      con.createQuery(deleteAnimalQuery).executeUpdate();
      con.createQuery(deletePersonQuery).executeUpdate();
    }
  }

}
