package utils;

import demo.business.httpresponse.ResponseConstant;
import demo.business.httpresponse.ResponseData;
import demo.business.httpresponse.Result;

/**
 * 统一封装接口结果返回
 */
public class ResponseDataUtil {

    public static ResponseData toSuccess(){
        ResponseData<String> responseData = new ResponseData<>();
        Result result = new Result();
        responseData.setResultInfo(result);
        return responseData;
    }

    public static <T> ResponseData toSuccess(T t){
        ResponseData<T> responseData = new ResponseData<>();
        Result result = new Result();
        responseData.setResultInfo(result);
        responseData.setData(t);
        return responseData;
    }

    public static ResponseData toFail(){
        ResponseData responseData = new ResponseData<>();
        Result result = new Result(ResponseConstant.RESULT_DESCRIPTION_FAILED);
        responseData.setResultInfo(result);
        return responseData;
    }

    /**
     * 声明为一个泛型方法 用来定义返回体内的数据类型
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResponseData toFail(T t){
        ResponseData responseData = new ResponseData<>();
        Result result = new Result(ResponseConstant.RESULT_DESCRIPTION_FAILED);
        responseData.setResultInfo(result);
        responseData.setData(t);
        return responseData;
    }

}
