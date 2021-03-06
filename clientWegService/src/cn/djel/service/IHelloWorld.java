
package cn.djel.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "IHelloWorld", targetNamespace = "http://service.djel.cn/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IHelloWorld {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHi", targetNamespace = "http://service.djel.cn/", className = "cn.djel.service.SayHi")
    @ResponseWrapper(localName = "sayHiResponse", targetNamespace = "http://service.djel.cn/", className = "cn.djel.service.SayHiResponse")
    public String sayHi(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "say", targetNamespace = "http://service.djel.cn/", className = "cn.djel.service.Say")
    @ResponseWrapper(localName = "sayResponse", targetNamespace = "http://service.djel.cn/", className = "cn.djel.service.SayResponse")
    public void say();

}
