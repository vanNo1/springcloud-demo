package van.feigndemo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "client", fallback = UserRemoteClientFallback.class)
public interface UserRemoteClient {
    @RequestMapping("/user/get")
    String getUser();

    @RequestMapping("/user/getSuccess")
    String getSuccess();
}


