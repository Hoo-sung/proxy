package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject {

    private Subject target;//프록시 입장에서 호출해야하는 실제 객체를 target 이라고 한다.
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");
        if (cacheValue == null) {
            cacheValue = target.operation();//real server에 들어가서 데이터 가져와 저장.
        }
        return cacheValue;
    }
}
