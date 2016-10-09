package wdsr.exercise3.hr.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2016-04-24T18:06:01.798+02:00
 * Generated source version: 3.1.6
 * 
 */
@WebServiceClient(name = "HumanResourceService", 
                  wsdlLocation = "file:hr.wsdl",
                  targetNamespace = "http://exercise3.wdsr/hr/definitions") 
public class HumanResourceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://exercise3.wdsr/hr/definitions", "HumanResourceService");
    public final static QName HumanResourcePort = new QName("http://exercise3.wdsr/hr/definitions", "HumanResourcePort");
    static {
        URL url = null;
        try {
            url = new URL("file:hr.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(HumanResourceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:hr.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public HumanResourceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public HumanResourceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HumanResourceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public HumanResourceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public HumanResourceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public HumanResourceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns HumanResource
     */
    @WebEndpoint(name = "HumanResourcePort")
    public HumanResource getHumanResourcePort() {
        return super.getPort(HumanResourcePort, HumanResource.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HumanResource
     */
    @WebEndpoint(name = "HumanResourcePort")
    public HumanResource getHumanResourcePort(WebServiceFeature... features) {
        return super.getPort(HumanResourcePort, HumanResource.class, features);
    }

}
