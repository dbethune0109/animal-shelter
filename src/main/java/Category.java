// import java.util.List;
// import java.util.ArrayList;
// import org.sql2o.*;
//
// public class Category {
//   private String name;
//   private int id;
//
//   public Category(String name) {
//     this.name = name;
//   }
//
//   public String getName() {
//     return name;
//   }
//
//   public static List<Category> all() {
//     String sql = "SELECT id, name FROM categories";
//     try(Connection con = DB.sql2o.open()) {
//       return con.createQuery(sql).executeAndFetch(Category.class);
//     }
//   }
//
//   public int getId() {
//     return id;
//   }
//
//   public void delete(){
//     String sql = "DELETE from categories WHERE id = :id";
//     try(Connection con = DB.sql2o.open()) {
//       con.createQuery(sql, true)
//         .addParameter("id", this.getId())
//         .executeUpdate()
//         .getKey();
//     }
//     String sql2 = "DELETE from tasks WHERE categoryId = :id";
//     try(Connection con = DB.sql2o.open()) {
//       con.createQuery(sql2, true)
//         .addParameter("id", this.getId())
//         .executeUpdate()
//         .getKey();
//     }
//   }
//
//  public static Category find(int id) {
//      try(Connection con = DB.sql2o.open()) {
//        String sql = "SELECT * FROM categories where id=:id";
//        Category category = con.createQuery(sql)
//          .addParameter("id", id)
//          .executeAndFetchFirst(Category.class);
//        return category;
//      }
//    }
//
//  public List<Task> getTasks() {
//    try(Connection con = DB.sql2o.open()) {
//      String sql = "SELECT * FROM tasks where categoryId=:id";
//      return con.createQuery(sql)
//        .addParameter("id", this.id)
//        .executeAndFetch(Task.class);
//    }
//  }
//
//  @Override
//  public boolean equals(Object otherCategory) {
//    if (!(otherCategory instanceof Category)) {
//      return false;
//    } else {
//      Category newCategory = (Category) otherCategory;
//      return this.getName().equals(newCategory.getName()) &&
//             this.getId() == newCategory.getId();
//    }
//  }
//
//   public void save() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "INSERT INTO categories(name) VALUES (:name)";
//       this.id = (int) con.createQuery(sql, true)
//         .addParameter("name", this.name)
//         .executeUpdate()
//         .getKey();
//     }
//   }
//
// }
