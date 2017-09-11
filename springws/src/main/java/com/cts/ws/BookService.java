
package com.cts.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "BookService", targetNamespace = "http://ws.cts.com/BookService/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BookService {


    /**
     * 
     * @param bookServiceRequest
     * @return
     *     returns com.cts.ws.BookServiceResponseType
     */
    @WebMethod(action = "http://www.home.com/BookService/NewOperation")
    @WebResult(name = "BookServiceResponse", targetNamespace = "http://ws.cts.com/BookService/", partName = "bookServiceResponse")
    public BookServiceResponseType findBook(
        @WebParam(name = "BookServiceRequest", targetNamespace = "http://ws.cts.com/BookService/", partName = "bookServiceRequest")
        BookServiceRequestType bookServiceRequest);

}