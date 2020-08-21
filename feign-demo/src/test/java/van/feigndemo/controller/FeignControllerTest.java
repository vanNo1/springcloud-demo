package van.feigndemo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import van.feigndemo.client.UserRemoteClient;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FeignControllerTest {
    @Resource
    private UserRemoteClient userRemoteClient;

    @Test
    public void testSuccess() {
        String result = userRemoteClient.getSuccess();
        System.out.println(result);
        assert(result).equals("van");
    }
    @Test
    public void testWithHystrix(){
        String result= userRemoteClient.getUser();
        System.out.println(result);
        assert(result).equals("失败");
    }
}