package van.eurekaclinet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/get")
    public String getUser() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "van";
    }

    @RequestMapping("getSuccess")
    public String getSuccess() {
        return "van";
    }
}
