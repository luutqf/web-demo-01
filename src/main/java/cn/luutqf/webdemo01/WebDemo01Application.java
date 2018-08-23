package cn.luutqf.webdemo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@SpringBootApplication
@RestController
public class WebDemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(WebDemo01Application.class, args);
    }

    @GetMapping("test")
    public Object test(){
        LocalTime now = LocalTime.now();
        return now;
    }
}
