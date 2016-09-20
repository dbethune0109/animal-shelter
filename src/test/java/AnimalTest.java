import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;

public class AnimalTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/animal_test", postgres, fuku1233);
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

    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
      Animal firstAnimal = new Animal("Adam","Male", "9/20/2016", "Human", "test", -1);
      firstAnimal.save();
      Animal secondAnimal = new Animal("bob","Male", "9/24/2016", "one", "three", -1);
      secondAnimal.save();
      assertEquals(true, Animal.all().get(0).equals(firstAnimal));
      assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void getId_AnimalInstantiateWithAnID_1() {
      Animal firstAnimal = new Animal("Adam","Male", "9/20/2016", "Human", "test", -1);
      firstAnimal.save();
      assertTrue(firstAnimal.getId() > 0);
    }

    @Test
    public void find_returnsPatientsWithSameId_secondPatients() {
      Animal firstAnimal = new Animal("Adam","Male", "9/20/2016", "Human", "test", -1);
      firstAnimal.save();
      Animal secondAnimal = new Animal("bob","Male", "9/24/2016", "one", "three", -1);
      secondAnimal.save();
      assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }

    @Test
    public void equals_returnsTrueIfDescriptionsAretheSame() {
      Animal firstAnimal = new Animal("Adam","Male", "9/20/2016", "Human", "test", -1);
      Animal secondAnimal = new Animal("Adam","Male", "9/20/2016", "Human", "test", -1);
      assertTrue(firstAnimal.equals(secondAnimal));
    }

    @Test
    public void save_returnsTrueIfDescriptionsAretheSame() {
      Animal firstAnimal = new Animal("Adam","Male", "9/20/2016", "Human", "test", -1);
      firstAnimal.save();
      assertTrue(Animal.all().get(0).equals(firstAnimal));
    }

    @Test
    public void save_assignsIdToObject() {
      Animal firstAnimal = new Animal("Adam","Male", "9/20/2016", "Human", "test", -1);
      firstAnimal.save();
      Animal savedAnimal = Animal.all().get(0);
      assertEquals(firstAnimal.getId(), savedAnimal.getId());
    }

    // @Test
    // public void save_savesCategoryIdIntoDB_true() {
    //   Category myCategory = new Category("Household chores");
    //   myCategory.save();
    //   Patients myPatients = new Patients("Mow the lawn", myCategory.getId());
    //   myPatients.save();
    //   Patients savedPatients = Patients.find(myPatients.getId());
    //   assertEquals(savedPatients.getCategoryId(), myCategory.getId());
    // }

}
