package by.anthony.scheduler.service;

import by.anthony.scheduler.model.Task;

public interface TaskService {

    Task createTask(Task task);

    Iterable<Task> getAllTasks();

    Task getTaskById(long id);

    Task updateTask(Task task, long id);

    void deleteTask(long id);

    void markAsDone(long id, Task task);

    void markAsDone(long id);
}
