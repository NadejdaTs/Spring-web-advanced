package bg.softuni.errors.web;

import bg.softuni.errors.exception.ObjectNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NotFound3Controller {

  @GetMapping("/not-found3/{id}")
  public String notFound1(@PathVariable("id") String id) {
    throw new ObjectNotFoundException("Object with id " + id + " was not found!", id);
  }

}
