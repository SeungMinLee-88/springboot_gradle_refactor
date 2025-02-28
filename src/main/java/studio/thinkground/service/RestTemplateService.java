package studio.thinkground.service;

import org.springframework.http.ResponseEntity;
import studio.thinkground.data.dto.MemberDTO;

public interface RestTemplateService {
    public String getAroundHub();

    public String getName();

    public String getName2();

    public ResponseEntity<MemberDTO> postDto();

    public ResponseEntity<MemberDTO> addHeader();
}
