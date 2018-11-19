package demo.compoment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyZuulFallBackProvider implements ZuulFallbackProvider{
    /**
     * 指定路由 如 CustomerServer/OrderServer  * 代表所有路由
     * @return
     */
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "asdasdasdasdasdasds";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {

                ObjectMapper objectMapper = new ObjectMapper();
                Map<String,String> msg = new HashMap<>();
                msg.put("errorCode","9999");
                msg.put("message","服务不可用");
                byte[] b = objectMapper.writeValueAsString(msg).getBytes();
                return new ByteInputStream(b,b.length);
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
                return httpHeaders;
            }
        };
    }
}
