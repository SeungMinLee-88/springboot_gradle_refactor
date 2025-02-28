package studio.thinkground.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import studio.thinkground.data.dto.MemberDTO;

import java.util.Map;

@RestController

@RequestMapping("/api/v1/get-api")

public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        LOGGER.info("call getHello");
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {

        LOGGER.info("call getName");
        return "Flature";
    }

    @RequestMapping(value = "/varialb1/{variable}")
    public String varialb1(@PathVariable("variable") String variable) {
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String variable2(@PathVariable("variable") String variable) {
        return variable;
    }

    @GetMapping(value = "/variable3/{variable}")
    public String variable3(@PathVariable("variable") String variable1, @PathVariable("variable") String variable2, @PathVariable("variable") String variable3) {
        return variable1;
    }

    @GetMapping("/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ) {
        return name + " " + email + " " + organization;
    }

    @GetMapping("/request2")
    public String getRequestParam2(
            @RequestParam Map <String, String> param
            ) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDTO memberDTO)
    {
        return memberDTO.toString();
    }

}
