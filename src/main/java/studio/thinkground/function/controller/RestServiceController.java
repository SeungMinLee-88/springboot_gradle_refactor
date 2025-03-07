package studio.thinkground.function.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studio.thinkground.member.dto.MemberRequest;
import studio.thinkground.function.service.RestTemplateService;

@RestController
@RequestMapping("/resttemplate")
public class RestServiceController {

  RestTemplateService restTemplateService;

  @Autowired
  public RestServiceController(RestTemplateService restTemplateService) {
    this.restTemplateService = restTemplateService;
  }

  @GetMapping(value = "/aroundhub")
  public String getAroundHub() {
    return restTemplateService.getAroundHub();
  }

  @GetMapping(value = "/name")
  public String getName() {
    return restTemplateService.getName();
  }

  @GetMapping(value = "/{name}")
  public String getName2() {
    return restTemplateService.getName2();
  }

  @PostMapping(value = "/member")
  public ResponseEntity<MemberRequest> postDto() {
    return restTemplateService.postDto();
  }

  @PostMapping(value = "/add-header")
  public ResponseEntity<MemberRequest> addHeader() {
    return restTemplateService.addHeader();
  }
}
