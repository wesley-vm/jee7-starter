package com.realdolmen.course.service;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name="RealDolmenFortunePortType", portName = "RealDolmenFortunePort", serviceName = "RealdolmenFortuneService", targetNamespace = "http://www.realdolmen.com/fortune")
public class FortuneWebService {
    @Inject
    private FortuneService service;

    @WebMethod(operationName = "FortuneSayer")
    public String fortune() {
        return service.fortune();
    }
}
