package demo.business.controller;

import demo.business.httpresponse.ResponseConstant;
import demo.business.httpresponse.ResponseData;
import demo.business.httpresponse.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.LoggerUtil;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseData errorHandler(Exception e) {
        ResponseData responseData = new ResponseData();
        Result result = new Result();
        result.setCode(ResponseConstant.RESULT_CODE_SYS_EXCEPTION);
        result.setMessage(ResponseConstant.RESULT_DESCRIPTION_EXCEPTION);
        responseData.setResultInfo(result);
        LoggerUtil.error(ExceptionController.class,e);
        return responseData;
    }
}
