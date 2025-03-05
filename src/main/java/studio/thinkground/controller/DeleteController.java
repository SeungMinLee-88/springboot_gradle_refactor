package studio.thinkground.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post-api")
public class DeleteController {

  @DeleteMapping(value = "/delete/{variable}")
  public String DeleteVariable(@PathVariable("variable") String variabl) {
    return variabl;
  }
}
