package com.realdolmen.course.service;


import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class MessageRepository {
    @Inject
    private List<String> messages;

    List<String> readAll() {
        return new ArrayList<>(messages);
    }
}
