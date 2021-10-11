package by.anthony.scheduler.service.impl;

import by.anthony.scheduler.model.Task;
import by.anthony.scheduler.repository.TaskRepository;
import by.anthony.scheduler.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task updateTask(Task task, long id) {
        task.setId(id);
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void markAsDone(long id, Task task) {
        if (task.isDone()) {
            taskRepository.markAsDone(id);
        }
    }

    @Override
    public void markAsDone(long id) {
        taskRepository.markAsDone(id);
    }
}
