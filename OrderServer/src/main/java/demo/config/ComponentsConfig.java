package demo.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by Administrator
 * on 2018/1/30.
 */
@Configuration
// core包中的内置实现，基础框架使用时可以使用，也可以自己实现接口定制
@MapperScan(basePackages = {"" +
        //"mybaties.mapper",
        "demo.business.mapper"})
/*
@ComponentScan(basePackages = {
        "com.yinhetianze.common.business",
        "com.yinhetianze.security",
        "com.yinhetianze.business"
})
*/
//@ServletComponentScan("com.yinhetianze.web")
public class ComponentsConfig
{

    /*
    @Bean
    public FilterRegistrationBean filterRegistrationBean()
    {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        CustomAccessLimitFilter filter = new CustomAccessLimitFilter();

        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setAsyncSupported(true);
        return filterRegistrationBean;
    }
    */

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("PUT", "DELETE","GET","POST","OPTIONS")
                        .allowedHeaders("*")
                        .exposedHeaders("access-control-allow-headers",
                                "access-control-allow-methods",
                                "access-control-allow-origin",
                                "access-control-max-age",
                                "X-Frame-Options")
                        .allowCredentials(false).maxAge(3600);
            }
        };

    }

    /**
     * 开启客户端负载均衡
     * restTemplate 是springboot服务间调用的基础
     * 即使是定义了feign也是以restTemplate为基础做的高层次的封装和调用
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 定义ribbon的负载均衡策略
     * @return
     */
    @Bean
    public IRule ribbonRule(){
        //随机负载
        //return new RandomRule();
        //轮询负载
        return new RoundRobinRule();
    }
    /*
    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                new DispatcherServlet(), "/");
        registration.setAsyncSupported(true);
        return registration;
    }
    */
}
