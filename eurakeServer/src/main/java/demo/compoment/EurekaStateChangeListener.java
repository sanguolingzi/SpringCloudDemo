package demo.compoment;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStateChangeListener {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {
        //服务断线事件
        String appName = eurekaInstanceCanceledEvent.getAppName();
        String serverId = eurekaInstanceCanceledEvent.getServerId();
        System.out.println("eurekaInstanceCanceledEvent");
        System.out.println(appName);
        System.out.println(serverId);
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.out.println("EurekaInstanceRegisteredEvent:"+instanceInfo.getAppName()+"...."+instanceInfo.getId());
        System.out.println(instanceInfo);
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        System.out.println("EurekaInstanceRenewedEvent:"+ event.getAppName()+"....."+  event.getServerId());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        System.out.println("EurekaInstanceRenewedEvent:"+ event);
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        //Server启动
        System.out.println("EurekaInstanceRenewedEvent:"+ event);
    }
}
