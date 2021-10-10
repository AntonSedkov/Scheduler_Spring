package by.anthony.scheduler.controller;

import by.anthony.scheduler.model.Task;
import by.anthony.scheduler.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @PutMapping("/tasks/{id}")
    public Task update(@RequestBody Task task,
                       @PathVariable long id) {
        task.setId(id);
        return taskRepository.save(task);
    }

    @DeleteMapping("tasks/{id}")
    public void delete(@PathVariable long id) {
        taskRepository.deleteById(id);
    }

    @PatchMapping("/tasks/{id}")
    public void patchTask(@PathVariable long id,
                          @RequestBody Task task) {
        if (task.isDone()) {
            taskRepository.markAsDone(id);
        }
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void patchTask(@PathVariable long id) {
        taskRepository.markAsDone(id);
    }

}
