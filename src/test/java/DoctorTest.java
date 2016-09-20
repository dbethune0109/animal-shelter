// import org.junit.*;
// import static org.junit.Assert.*;
// import org.sql2o.*;
// import java.util.Arrays;
//
// public class DoctorTest {
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
//     @Test
//     public void category_instantiatesCorrectly_true() {
//       Doctor testDoctor = new Doctor("Home");
//       assertEquals(true, testDoctor instanceof Doctor);
//     }
//
//     @Test
//     public void getName_categoryInstantiatesWithName_Home() {
//       Doctor testDoctor = new Doctor("Home");
//       assertEquals("Home", testDoctor.getName());
//     }
//
//    @Test
//    public void all_returnsAllInstancesOfDoctor_true() {
//      Doctor firstDoctor = new Doctor("Home");
//      firstDoctor.save();
//      Doctor secondDoctor = new Doctor("Work");
//      secondDoctor.save();
//      assertEquals(true, Doctor.all().get(0).equals(firstDoctor));
//      assertEquals(true, Doctor.all().get(1).equals(secondDoctor));
//    }
//
//    @Test
//    public void getId_categoriesInstantiateWithAnId_1() {
//      Doctor testDoctor = new Doctor("Home");
//      testDoctor.save();
//      assertTrue(testDoctor.getId() > 0);
//    }
//
//    @Test
//    public void find_returnsDoctorWithSameId_secondDoctor() {
//      Doctor firstDoctor = new Doctor("Home");
//      firstDoctor.save();
//      Doctor secondDoctor = new Doctor("Work");
//      secondDoctor.save();
//      assertEquals(Doctor.find(secondDoctor.getId()), secondDoctor);
//    }
//
//     @Test
//     public void equals_returnsTrueIfNamesAretheSame() {
//       Doctor firstDoctor = new Doctor("Household chores");
//       Doctor secondDoctor = new Doctor("Household chores");
//       assertTrue(firstDoctor.equals(secondDoctor));
//     }
//
//     @Test
//     public void save_savesIntoDatabase_true() {
//       Doctor myDoctor = new Doctor("Household chores");
//       myDoctor.save();
//       assertTrue(Doctor.all().get(0).equals(myDoctor));
//     }
//
//     @Test
//     public void save_assignsIdToObject() {
//       Doctor myDoctor = new Doctor("Household chores");
//       myDoctor.save();
//       Doctor savedDoctor = Doctor.all().get(0);
//       assertEquals(myDoctor.getId(), savedDoctor.getId());
//     }
//
//     @Test
//     public void getTasks_retrievesALlTasksFromDatabase_tasksList() {
//       Doctor myDoctor = new Doctor("Household chores");
//       myDoctor.save();
//       Patients firstPatients = new Patients("Adam",23, myDoctor.getId(), "1999");
//       firstPatients.save();
//       Patients secondPatients = new Patients("bob",24, myDoctor.getId(), "1922");
//       secondPatients.save();
//       Patients[] patients = new Patients[] { firstPatients, secondPatients };
//       assertTrue(myDoctor.getPatients().containsAll(Arrays.asList(patients)));
//     }
//
// }
