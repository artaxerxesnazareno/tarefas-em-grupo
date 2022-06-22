package com.task.controllers;

import com.task.entities.Project;
import com.task.entities.User;
import com.task.repositories.ProjectRepository;
import com.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("form")
    public String projectForm(Project project, Model model) {

        model.addAttribute("users", this.userRepository.findAll());
        return "projectForm";

    }

    @PostMapping("add")
    private String addProject(@Valid Project project, BindingResult result, Model model, @RequestParam(name = "user") String user_id) {
        if (result.hasErrors()) {
            return "projectForm";
        }

        User user = this.userRepository.getReferenceById(Long.valueOf(user_id));
        project.setUser(user);
        this.projectRepository.save(project);
        return "redirect:list";
    }

    private String projectList(Model model) {
        model.addAttribute("project",this.projectRepository.findAll());

        return "projectList";
    }
}
