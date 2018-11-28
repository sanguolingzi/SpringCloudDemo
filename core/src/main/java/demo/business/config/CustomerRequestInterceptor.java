package demo.business.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * feign 请求拦截 可做业务处理
 */

@Component
public class CustomerRequestInterceptor implements RequestInterceptor {

    public void apply(RequestTemplate requestTemplate) {
        System.out.println("requestTemplate  work");
    }
}
