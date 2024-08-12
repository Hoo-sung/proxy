package hello.proxy.app.v1;


import org.springframework.web.bind.annotation.*;


/**
 * 보통 컨트롤러를 인터페이스 만드는 경우는 별로 없다. 처음 봄
 */
@RequestMapping//스프링은 1. @Controller 또는 2. @RequestMapping이 있어야 스프링 컨트롤러로 인식
@ResponseBody
public interface OrderControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}
