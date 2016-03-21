package Controller.Interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by lexa on 21.03.16.
 */
@WebService
// говорим, что веб-сервис будет использоваться для вызова методов
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IWebService {

    // говорим, что этот метод можно вызывать удаленно
    @WebMethod
    public String getHelloString(String name);
//
}