package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component {//proxy이다.

    private Component component;

    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {//데코레이터 패턴은 프록시를 사용하는데, 접근 제어가 아닌, 부가 기능에 주 목적이 있다.
        log.info("MessageDecorator 실행");

        //data -> ****data****
        String result = component.operation();
        String decoResult = "****" + result + "****";
        log.info("MessageDecorator 꾸미기 적용 전={}, 적용 후={}", result, decoResult);
        return decoResult;
    }
}
