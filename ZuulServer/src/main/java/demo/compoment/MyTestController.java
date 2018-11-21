package demo.compoment;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用来捕获 未到controller 的404错误 然后统一编码
 */
@RestController
public class MyTestController implements ErrorController{
    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping(value="error")
    public String error(HttpServletRequest request){
        StringBuilder stringBuilder = new StringBuilder("{");
        stringBuilder.append("\"").append("code\":9999");
        stringBuilder.append(",");
        Object uri = request.getAttribute("javax.servlet.error.request_uri");
        Object code = request.getAttribute("javax.servlet.error.status_code");
        Integer codeIntValue = Integer.parseInt(code.toString());
        HttpStatus httpStatus = HttpStatus.valueOf(codeIntValue);
        stringBuilder.append("\"").
                append("msg\":\"uri:")
                .append(uri)
                .append("..")
                .append(httpStatus.getReasonPhrase())
                .append("\"")
                .append(",");
        stringBuilder.append("\"httpStatus\":").append(httpStatus.value());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
