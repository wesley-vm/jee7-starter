package com.realdolmen.course.service.jms;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.junit.Test;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.domain.RegularPerson;
import com.realdolmen.course.utilities.integration.RemoteJmsTest;

public class PersonMessageDrivenBeanTest extends RemoteJmsTest {
    @Test
    public void shouldSendAPersonMessage() throws JMSException {
        ObjectMessage message = session.createObjectMessage(new RegularPerson("Theo", "Tester"));
        producer.send(message);
        assertPatiently(() -> assertEquals(3, count(Person.class)));
    }
}
