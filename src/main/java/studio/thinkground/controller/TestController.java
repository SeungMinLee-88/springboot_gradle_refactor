package studio.thinkground.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studio.thinkground.data.dto.MemberDTO;


@RestController
@RequestMapping("/api/server")
public class TestController {
    private final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping(value = "/aroundhub")
    public String getTest1() {
        LOGGER.info("getTest11111111 call!");
        return "Hello studio!";
    }

    @GetMapping(value = "/name")
    public String getTest2(@RequestParam String name){
        LOGGER.info("getTest222222222222 call!");
        return "Hello " + name;
    }

    @GetMapping(value = "/path-variable/{name}")
    public String getTest3(@PathVariable String name){
        LOGGER.info("getTest 3333333 call!");
        return "Hello " + name;
    }

    @PostMapping(value = "/member")
    public ResponseEntity<MemberDTO> getMmember(
        @RequestBody MemberDTO memberDTO,
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organization
        ){

        LOGGER.info("getMember call");

        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }

    @PostMapping(value = "/add-header")
    public ResponseEntity<MemberDTO> addHeader(@RequestHeader("ardheader") String header
    , @RequestBody MemberDTO memberDTO)
    {
        LOGGER.info("add header call");
        LOGGER.info("add header : " + header);

        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }
}
