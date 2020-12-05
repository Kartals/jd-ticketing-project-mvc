package com.cybertek.controller;


import com.cybertek.dto.TaskDTO;
import com.cybertek.enums.Status;
import com.cybertek.service.ProjectService;
import com.cybertek.service.TaskService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    ProjectService projectService; //to bring all projects, we should inject ProjectService interface

    @Autowired
    UserService userService; // to bring all employees, we should inject UserService interface

    @Autowired
    TaskService taskService; //to bring all tasks, we should inject TaskService interface

    @GetMapping("/create")
        public String createTask(Model model){

        model.addAttribute("task", new TaskDTO()); // empty object
        model.addAttribute("projects",projectService.findAll()); // to bring all projects, we should inject ProjectService interface(line 18-19)
        model.addAttribute("employees", userService.findEmployees()); // to bring all employees, we should inject UserService interface(line 21-22)
        model.addAttribute("tasks",taskService.findAll()); // to bring all tasks, we should inject TaskService interface(line 24-25)

        return "task/create";
    }

    @PostMapping("/create")
    public String insertTask(Model model, TaskDTO task){

        task.setTaskStatus(Status.OPEN);
        task.setAssignedDate(LocalDate.now());
        task.setId(UUID.randomUUID().getMostSignificantBits());
        taskService.save(task);

        System.out.println("Auto generator ID : " + task.getId()); // to see id on console
        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        taskService.deleteById(id);
        return "redirect:/task/create";

    }



}
