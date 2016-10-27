package com.realdolmen.course.service;

import javax.enterprise.inject.Produces;
import java.util.Arrays;
import java.util.List;

public class MessagesFactory {
    @Produces
    public List<String> niceMessages() {
        return Arrays.asList(
            "Have a N.I.C.E day",
            "You will meet an interesting person today",
            "Chuck Norris never sleeps, he just closes his eyes to think harder"
        );
    }
}
