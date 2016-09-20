// import org.junit.*;
// import static org.junit.Assert.*;
// import org.sql2o.*;
// import java.util.Arrays;
// import java.util.List;
//
// public class PatientsTest {
//
//   @Before
//   public void setUp() {
//     DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/doctors_test", null, null);
//   }
//
//   @After
//   public void tearDown() {
//     try(Connection con = DB.sql2o.open()) {
//       String deletePatientQuery = "DELETE FROM patients *;";
//       String deleteDoctorQuery = "DELETE FROM doctor *;";
//       con.createQuery(deletePatientQuery).executeUpdate();
//       con.createQuery(deleteDoctorQuery).executeUpdate();
//     }
//   }
//
//   @Test
//   public void Patients_instantiatesCorrectly_true() {
//     Patients myPatients = new Patients("Adam",23, 1, "1999");
//     assertEquals(true, myPatients instanceof Patients);
//   }
//
//   @Test
//   public void Patients_instantiatesWithName_String() {
//     Patients myPatients = new Patients("Adam",23, 1, "1999");
//     assertEquals("Adam", myPatients.getName());
//   }
//
//   @Test
//   public void Patients_instantiatesWithAge_String() {
//     Patients myPatients = new Patients("Adam",23, 1, "1999");
//     assertEquals(23, myPatients.getAge());
//   }
//
//   @Test
//   public void all_returnsAllInstancesOfPatients_true() {
//     Patients firstPatients = new Patients("Adam",23, 1, "1999");
//     firstPatients.save();
//     Patients secondPatients = new Patients("bob",23, 2, "1992");
//     secondPatients.save();
//     assertEquals(true, Patients.all().get(0).equals(firstPatients));
//     assertEquals(true, Patients.all().get(1).equals(secondPatients));
//   }
//
//   @Test
//   public void getId_tasksInstantiateWithAnID_1() {
//     Patients myPatients = new Patients("Adam",23, 1, "1999");
//     myPatients.save();
//     assertTrue(myPatients.getId() > 0);
//   }
//
//   @Test
//   public void find_returnsPatientsWithSameId_secondPatients() {
//     Patients firstPatients = new Patients("Adam",23, 1, "1999");
//     firstPatients.save();
//     Patients secondPatients = new Patients("bob",23, 2, "1992");
//     secondPatients.save();
//     assertEquals(Patients.find(secondPatients.getId()), secondPatients);
//   }
//
//   @Test
//   public void equals_returnsTrueIfDescriptionsAretheSame() {
//     Patients firstPatients = new Patients("Adam",23, 1, "1999");
//     Patients secondPatients = new Patients("Adam",23, 1, "1999");
//     assertTrue(firstPatients.equals(secondPatients));
//   }
//
//   @Test
//   public void save_returnsTrueIfDescriptionsAretheSame() {
//     Patients myPatients = new Patients("Adam",23, 1, "1999");
//     myPatients.save();
//     assertTrue(Patients.all().get(0).equals(myPatients));
//   }
//
//   @Test
//   public void save_assignsIdToObject() {
//     Patients myPatients = new Patients("Adam",23, 1, "1999");
//     myPatients.save();
//     System.out.println(Patients.all().get(0).getName());
//     Patients savedPatients = Patients.all().get(0);
//     assertEquals(myPatients.getId(), savedPatients.getId());
//   }
//
//   // @Test
//   // public void save_savesCategoryIdIntoDB_true() {
//   //   Category myCategory = new Category("Household chores");
//   //   myCategory.save();
//   //   Patients myPatients = new Patients("Mow the lawn", myCategory.getId());
//   //   myPatients.save();
//   //   Patients savedPatients = Patients.find(myPatients.getId());
//   //   assertEquals(savedPatients.getCategoryId(), myCategory.getId());
//   // }
//
// }
