// import org.junit.*;
// import static org.junit.Assert.*;
// import org.sql2o.*;
// import java.util.Arrays;
// import java.util.List;
//
// public class PersonTest {
//
//   @Before
//   public void setUp() {
//     DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/animal_test", "postgres","fuku1233");
//   }
//
//   @After
//   public void tearDown() {
//     try(Connection con = DB.sql2o.open()) {
//       String deleteAnimalQuery = "DELETE FROM animal *;";
//       String deletePersonQuery = "DELETE FROM person *;";
//       con.createQuery(deleteAnimalQuery).executeUpdate();
//       con.createQuery(deletePersonQuery).executeUpdate();
//     }
//   }
//
//   @Test
//   public void category_instantiatesCorrectly_true() {
//     Person testPerson = new Person("Bob","111-111-1111", "Human", "test");
//     assertEquals(true, testPerson instanceof Person);
//   }
//
//   @Test
//   public void getName_categoryInstantiatesWithName() {
//     Person testPerson = new Person("Bob","111-111-1111", "Human", "test");
//     assertEquals("Bob", testPerson.getName());
//   }
//
//   @Test
//   public void all_returnsAllInstancesOfPerson_true() {
//     Person firstPerson = new Person("Bob","111-111-1111", "Human", "test");
//     firstPerson.save();
//     Person secondPerson = new Person("next","111-111-2222", "Human", "test");
//     secondPerson.save();
//     assertEquals(true, Person.all().get(0).equals(firstPerson));
//     assertEquals(true, Person.all().get(1).equals(secondPerson));
//   }
//
//   @Test
//   public void getId_categoriesInstantiateWithAnId_1() {
//     Person testPerson = new Person("Bob","111-111-1111", "Human", "test");
//     testPerson.save();
//     assertTrue(testPerson.getId() > 0);
//   }
//
//   @Test
//   public void find_returnsPersonWithSameId_secondPerson() {
//     Person firstPerson = new Person("Bob","111-111-1111", "Human", "test");
//     Person secondPerson = new Person("next","111-111-2222", "Human", "test");
//     firstPerson.save();
//     secondPerson.save();
//     assertEquals(Person.find(secondPerson.getId()), secondPerson);
//   }
//
//   @Test
//   public void equals_returnsTrueIfNamesAretheSame() {
//     Person firstPerson = new Person("Bob","111-111-1111", "Human", "test");
//     Person secondPerson = new Person("Bob","111-111-1111", "Human", "test");
//     assertTrue(firstPerson.equals(secondPerson));
//   }
//
//   @Test
//   public void save_savesIntoDatabase_true() {
//     Person myPerson = new Person("Bob","111-111-1111", "Human", "test");
//     myPerson.save();
//     assertTrue(Person.all().get(0).equals(myPerson));
//   }
//
//   @Test
//   public void save_assignsIdToObject() {
//     Person myPerson = new Person("Bob","111-111-1111", "Human", "test");
//     myPerson.save();
//     Person savedPerson = Person.all().get(0);
//     assertEquals(myPerson.getId(), savedPerson.getId());
//   }
//
//   @Test
//   public void getTasks_retrievesALlTasksFromDatabase_tasksList() {
//     Person myPerson = new Person("Bob","111-111-1111", "Human", "test");
//     myPerson.save();
//     Animal firstPatients = new Animal("Adam","Male", "9/20/2016", "Human", "test",  myPerson.getId());
//     firstPatients.save();
//     Animal secondPatients = new Animal("next","Male", "9/25/2016", "Human", "test",  myPerson.getId());
//     secondPatients.save();
//     Animal[] patients = new Animal[] { firstPatients, secondPatients };
//     assertTrue(myPerson.getAnimal().containsAll(Arrays.asList(patients)));
//   }
//
// }
