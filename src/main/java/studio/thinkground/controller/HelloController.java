package studio.thinkground.controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import studio.thinkground.common.annotation.FieldAnnotation;
import studio.thinkground.common.annotation.MethodAnnotation;
import studio.thinkground.common.annotation.TypeAnnotation;
import studio.thinkground.common.valid.TempDto;

@RestController
@TypeAnnotation(name = "type name ", value = "type value")
public class HelloController {
  /*@GetMapping("hello")*/

  @FieldAnnotation(name = "filed hello", value = "field value")
  public String returnValue = "returnValue";

  private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String hello() {
    return "Hello World";
  }

  @RequestMapping("/hello1")
  @MethodAnnotation(name = "MethodHello1")
  public String hello1() throws NoSuchMethodException {
    Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    Method method = this.getClass().getMethod("hello1");
    Annotation[] annotations = method.getDeclaredAnnotations();
    LOGGER.info("method.getDeclaredAnnotations() : " + method.getDeclaredAnnotations().toString());

    for (Annotation annotation : annotations) {
      if (annotation instanceof MethodAnnotation) {
        MethodAnnotation methodAnnotation = (MethodAnnotation) annotation;
        return methodAnnotation.name() + ",||| " + methodAnnotation.value();
      }
    }
    return "Hello World!";
  }

  @RequestMapping("/hello2")
  public String hello2(@RequestBody @Valid TempDto dto) {

    // LOGGER.info("dto : " + dto.getValue());
    LOGGER.info("call hello2");
    return "Valid value : " + dto.getValue();
  }

  /*@PostMapping("/exception")
  public void exceptionTest() throws Exception {
      throw new Exception("Exception test", new ClassFormatError());
  }
  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
      HttpHeaders responseHeaders = new HttpHeaders();
      // responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
      HttpStatus httpStatus = HttpStatus.CONFLICT;


      LOGGER.info("getMessage : " + e.getMessage() + " | getCause: " + e.getCause());
      LOGGER.info("Controller 내 ExceptionHandler 호출");

      Map<String, String> map = new HashMap<>();
      map.put("error type", httpStatus.getReasonPhrase());
      map.put("code", String.valueOf(HttpStatus.CONFLICT.value()));
      map.put("message", "에러 발생test ");

      return new ResponseEntity<>(map, responseHeaders, httpStatus);
  }*/
}
