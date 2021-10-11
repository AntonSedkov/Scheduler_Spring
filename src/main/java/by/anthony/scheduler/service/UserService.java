package by.anthony.scheduler.service;

import by.anthony.scheduler.model.User;

public interface UserService {

    User createUser(User user);

    User getCurrentUser();

}
