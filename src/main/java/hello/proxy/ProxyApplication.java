package hello.proxy;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)// 해당 클래스를 Spring Bean으로 등록한다.
@Import({AppV1Config.class, AppV2Config.class})
@SpringBootApplication(scanBasePackages = "hello.proxy.app") //주의
//hello.proxy.app으로 한 이유는 hello.proxy.config를 componentscan하고 싶지 않아서이다. @configuration은 컴포턴트 스캔의 대상이된다.
//내부에 @component가 들어있음을 잊지 말자. 이렇게 안하면, 모든 configV1,configV2...이 다 자동으로 component scan되는 문제가 발생함.

public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

}
