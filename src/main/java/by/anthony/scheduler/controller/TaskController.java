package by.anthony.scheduler.controller;

import by.anthony.scheduler.model.Task;
import by.anthony.scheduler.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return service.createTask(task);
    }

    @GetMapping("/tasks")
    public Iterable<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable long id) {
        return service.getTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@RequestBody Task task,
                           @PathVariable long id) {
        return service.updateTask(task, id);
    }

    @DeleteMapping("tasks/{id}")
    public void deleteTask(@PathVariable long id) {
        service.deleteTask(id);
    }

    @PatchMapping("/tasks/{id}")
    public void patchTask(@PathVariable long id,
                          @RequestBody Task task) {
        service.markAsDone(id, task);
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void patchTask(@PathVariable long id) {
        service.markAsDone(id);
    }

}
