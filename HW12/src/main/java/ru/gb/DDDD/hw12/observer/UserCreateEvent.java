package ru.gb.DDDD.hw12.observer;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.gb.DDDD.hw12.model.User;

@Getter
public class UserCreateEvent extends ApplicationEvent {
    private User user;

    public UserCreateEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
