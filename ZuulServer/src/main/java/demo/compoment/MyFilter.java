package demo.compoment;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class MyFilter extends  ZuulFilter {

     /*
        pre：路由之前
        routing：路由之时
        post： 路由之后
        error：发送错误调用
    */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    //过滤顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());

        //是否继续往下走
        //ctx.setSendZuulResponse(false);

        //返回body内容
        //ctx.setResponseBody("aaaaaaa");
        return null;
    }
}
