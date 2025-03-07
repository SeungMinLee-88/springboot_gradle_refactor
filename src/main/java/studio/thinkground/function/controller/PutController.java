package studio.thinkground.function.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studio.thinkground.member.dto.MemberRequest;

@RestController
@RequestMapping("/api/v1/post-api")
public class PutController {

  @PutMapping(value = "/default")
  public String putDefault() {
    return "Default Value";
  }

  @PutMapping(value = "/member")
  public String postMember(@RequestBody Map<String, String> postData) {
    StringBuilder sb = new StringBuilder();

    postData
        .entrySet()
        .forEach(
            map -> {
              sb.append(map.getKey() + ":" + map.getValue() + "\n");
            });

    return sb.toString();
  }

  @PutMapping(value = "/member1")
  public String potMemberDto1(@RequestBody MemberRequest memberRequest) {
    return memberRequest.toString();
  }

  @PutMapping(value = "/member2")
  public MemberRequest potMemberDto2(@RequestBody MemberRequest memberRequest) {
    return memberRequest;
  }

  @PutMapping(value = "/member3")
  public ResponseEntity<MemberRequest> potMemberDto3(@RequestBody MemberRequest memberRequest) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(memberRequest);
  }
}
