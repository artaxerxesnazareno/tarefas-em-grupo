package com.task.controllers;

import com.task.entities.Project;
import com.task.entities.Task;
import com.task.entities.User;
import com.task.repositories.ProjectRepository;
import com.task.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("list")
    public String taskList(Model model) {
        model.addAttribute("tasks", this.taskRepository.findAll());
        return "tasksList";
    }

    @GetMapping("form")
    public String taskForm(Task task, Model model) {
        model.addAttribute("projects", this.projectRepository.findAll());
        return "formTask";
    }

    @PostMapping("add")
    public String addTask(@Valid Task task, BindingResult result, Model model, @RequestParam(name = "project_nome") String project_id) {

        if (result.hasErrors()) {
            return "formTask";
        }
//        Optional<Project> project = this.projectRepository.findById(Long.parseLong(project_id));
        Project project = this.projectRepository.getReferenceById(Long.parseLong(project_id));
        task.setProject(project);
        this.taskRepository.save(task);

        return "redirect:list";
    }
}
