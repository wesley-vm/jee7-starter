package com.realdolmen.course.service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Transactional
public class FortuneService {
    @Inject
    private MessageRepository mr;

    private Random random = new Random();

    public String fortune() {
        List<String> messages = mr.readAll();
        return messages.get(random.nextInt(messages.size()));
    }
}
