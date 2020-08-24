package van.apollo.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import van.apollo.config.RedisConfig;
import van.apollo.entity.Student;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Value("${username:van}")
    private String username;
    @Resource
    private RedisConfig redisConfig;
    @ApolloConfig
    private Config config;
    @ApolloJsonValue("${stus:[]}")
    private List<Student> stus;

    @RequestMapping("/getUsername")
    private String getUsername() {
        return config.getProperty("username", "van");
    }

    @RequestMapping("/getUsername2")
    private String getUsername2() {
        return username;
    }

    @RequestMapping("/getRedisConfig")
    private String getRedisConfig() {
        return redisConfig.getHost();
    }

    @RequestMapping("/stus")
    private List<Student> getStus() {
        return stus;
    }

    @ApolloConfigChangeListener
    private void someOnChange(ConfigChangeEvent event) {
        if (event.isChanged("username")) {
            System.out.printf("username has changed");
        }
    }
}
