package studio.thinkground.function.service;

import org.springframework.http.ResponseEntity;

import studio.thinkground.member.dto.MemberRequest;

public interface RestTemplateService {
  public String getAroundHub();

  public String getName();

  public String getName2();

  public ResponseEntity<MemberRequest> postDto();

  public ResponseEntity<MemberRequest> addHeader();
}
