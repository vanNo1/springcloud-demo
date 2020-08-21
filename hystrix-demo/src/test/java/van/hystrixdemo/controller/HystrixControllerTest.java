package van.hystrixdemo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import van.hystrixdemo.service.HystrixService;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class HystrixControllerTest {
    @Resource
    private HystrixService hystrixService;
    @Test
    public void success(){
        String result=hystrixService.getSuccess();
        System.out.println(result);
        assert(result).equals("van");
    }
    @Test
    public void fail(){
        String result=hystrixService.getFail();
        System.out.println(result);
        assert(result).equals("失败");
    }

}