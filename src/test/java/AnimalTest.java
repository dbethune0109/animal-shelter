import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;

public class AnimalTest {

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

  @Test
  public void makeAnimal() {
    Animal myAnimal = new Animal("Adam","Male", "9/20/2016", "Human", "test",  -1);
    assertEquals(true, myAnimal instanceof Animal);
  }

  @Test
  public void AnimalgetName() {
    Animal myAnimal = new Animal("Adam","Male", "9/20/2016", "Human", "test", -1);
    assertEquals("Adam", myAnimal.getName());
  }

  @Test
  public void AnimalgetGender() {
    Animal myAnimal = new Animal("Adam","Male", "9/20/2016", "Human", "test", -1);
    assertEquals("Male", myAnimal.getGender());
  }

  @Test
  public void AnimalgetType() {
    Animal myAnimal = new Animal("Adam","Male", "9/20/2016", "Human", "test", -1);
    assertEquals("test", myAnimal.getType());
  }

  @Test
  public void AnimalgetBreed() {
    Animal myAnimal = new Animal("Adam","Male", "9/20/2016", "Human", "test", -1);
    assertEquals("Human", myAnimal.getBreed());
  }

  @Test
  public void AnimalgetPersonId() {
    Animal myAnimal = new Animal("Adam","Male", "9/20/2016", "Human", "test", -1);
    assertEquals(-1, myAnimal.getPersonid());
  }

  @Test
  public void AnimalgetDta() {
    Animal myAnimal = new Animal("Adam","Male", "9/20/2016", "Human", "test", -1);
    assertEquals("9/20/2016", myAnimal.getDta());
  }

}
