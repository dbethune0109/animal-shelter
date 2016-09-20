import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    get("/", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("persons", Persons.all());
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

      get("persons/:id/animals/new", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Person person = Person.find(Integer.parseInt(request.params(":id")));
        model.put("person", person);
        model.put("template", "templates/person-animals-form.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
      //
      get("animals/:id/edit", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Animal animal = Animal.find(Integer.parseInt(request.params(":id")));
        animal.complete();
        model.put("animal", animal);
        model.put("template", "templates/animal.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
      //
      // get("animals/:id/delete", (request, response) -> {
      //   Map<String, Object> model = new HashMap<String, Object>();
      //   Animal task = Animal.find(Integer.parseInt(request.params(":id")));
      //   task.delete();
      //   model.put("task", task);
      //   model.put("template", "templates/task-deleted.vtl");
      //   return new ModelAndView(model, layout);
      // }, new VelocityTemplateEngine());
      //
      // get("persons/:id/delete", (request, response) -> {
      //   Map<String, Object> model = new HashMap<String, Object>();
      //   Person person = Person.find(Integer.parseInt(request.params(":id")));
      //   person.delete();
      //   model.put("person", person);
      //   model.put("template", "templates/person-deleted.vtl");
      //   return new ModelAndView(model, layout);
      // }, new VelocityTemplateEngine());
      //
      get("/animals", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("animals", Animal.all());
        model.put("template", "templates/animals.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/animals", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Person person = Person.find(Integer.parseInt(request.queryParams("personId")));
        String description = request.queryParams("description");
        Animal newAnimal = new Animal(description, person.getId());
        newAnimal.save();
        model.put("person", person);
        response.redirect("/persons/"+ request.queryParams("personId"));
        model.put("template", "templates/person-animal-success.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
      //
      get("/animals/:id", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Animal task = Animal.find(Integer.parseInt(request.params(":id")));
        model.put("task", task);
        model.put("template", "templates/animal.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
      //
      get("/persons/new", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/person-form.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
      //
      post("/persons", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        String name = request.queryParams("name");
        Person newPerson = new Person(name);
        newPerson.save();
        response.redirect("/persons");
        //model.put("template", "templates/person-success.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
      //
      get("/persons", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("persons", Person.all());
        model.put("template", "templates/persons.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
      //
      get("/persons/:id", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Person person = Person.find(Integer.parseInt(request.params(":id")));
        model.put("person", person);
        model.put("template", "templates/person.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
  }
}
