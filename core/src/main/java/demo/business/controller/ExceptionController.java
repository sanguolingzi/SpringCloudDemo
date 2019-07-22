package demo.business.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.LoggerUtil;
import utils.ResponseDataUtil;
import demo.business.httpresponse.ResponseData;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseData errorHandler(Exception e) {
        LoggerUtil.error(ExceptionController.class,e);
        return  ResponseDataUtil.toFail();
    }
}
