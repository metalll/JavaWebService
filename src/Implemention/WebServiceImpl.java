package Implemention;

import Interfaces.IWebService;

import javax.jws.WebService;
// таже аннотация, что и при описании интерфейса,


@WebService(endpointInterface = "Interfaces.IWebService")
public class WebServiceImpl implements IWebService {
    @Override
    public String getHelloString(String name) {
        // просто возвращаем приветствие
        return "Hello, " + name + "!";
    }
}

