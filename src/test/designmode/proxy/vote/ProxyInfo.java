package test.designmode.proxy.vote;
import java.util.List;  

/** 
 *  
 * 获取代理信息 
 * 创建一下代理的IP和端口
 *  
 * */  
public class ProxyInfo {  
	
    String proxyIP = null;  
    String proxyPort = null;  
      
    public String getProxyIP() {  
        return proxyIP;  
    }  
    public void setProxyIP(String proxyIP) {  
        this.proxyIP = proxyIP;  
    }  
    public String getProxyPort() {  
        return proxyPort;  
    }  
    public void setProxyPort(String proxyPort) {  
        this.proxyPort = proxyPort;  
    }  
    public static List<ProxyInfo> arrayList() {  
          
        return null;  
    }  
}  
