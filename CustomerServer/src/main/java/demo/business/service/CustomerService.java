package demo.business.service;

import java.util.Map;

public interface CustomerService {

    public String OrderMessage(String message);

    public String saveOrderMessage(Map<String,Object> map);
}
