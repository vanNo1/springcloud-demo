package van.feigndemo.client;

import org.springframework.stereotype.Component;

@Component
public class UserRemoteClientFallback implements UserRemoteClient {
    @Override
    public String getUser() {
        return "失败";
    }

    @Override
    public String getSuccess() {
        return   "失败";
    }
}
