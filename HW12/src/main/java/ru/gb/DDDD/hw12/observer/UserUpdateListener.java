package ru.gb.DDDD.hw12.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.gb.DDDD.hw12.service.FileLoggerGateway;

@Component
public class UserUpdateListener implements ApplicationListener<UserCreateEvent> {
    @Autowired
    FileLoggerGateway fileLoggerGateway;
    @Override
    public void onApplicationEvent(UserCreateEvent event) {
        fileLoggerGateway.writeToFile("addUsers_log.txt", event.getUser());
        System.out.println("Добавлен пользователь: " + event.getUser().toString());
    }
}
