package van.hystrixdemo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class HystrixService {
    private RestTemplate restTemplate = new RestTemplate();

    //这里的超时时间大于调用的时间，所以可以正常返回
    @HystrixCommand(commandKey = "getUser", groupKey = "user", fallbackMethod = "fallback", threadPoolKey = "tpk1",
            commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000"))
    public String getSuccess() {
        System.err.println(Thread.currentThread().getName());
        String user = restTemplate.getForEntity("http://localhost:8081/user/get", String.class).getBody();
        return user;
    }

    //这里的超时时间小于调用的时间，所以不能正常返回，直接调用fallback
    @HystrixCommand(commandKey = "getUser2", groupKey = "use2r", fallbackMethod = "fallback", threadPoolKey = "tpk2",
            commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"))
    public String getFail() {
        System.err.println(Thread.currentThread().getName());
        String user = restTemplate.getForEntity("http://localhost:8081/user/get", String.class).getBody();
        return user;
    }


    private String fallback() {
        return "失败";
    }
}
