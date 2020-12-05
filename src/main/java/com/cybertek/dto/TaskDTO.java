package com.cybertek.dto;

import com.cybertek.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.UUID;


@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {

    private Long id; // bunu yazmamızın sebebi bir id yi primary key olarak kullanmak
    private ProjectDTO project;
    private UserDTO assignedEmployee;
    private String taskSubject;
    private String taskDetail;
    private Status taskStatus;
    private LocalDate assignedDate;

    //manually creating constructor. @AllArgsConstructor ı kaldırdık, id için custom constructors oluşturmak için.
    public TaskDTO(ProjectDTO project, UserDTO assignedEmployee, String taskSubject, String taskDetail, Status taskStatus, LocalDate assignedDate) {
        this.project = project;
        this.assignedEmployee = assignedEmployee;
        this.taskSubject = taskSubject;
        this.taskDetail = taskDetail;
        this.taskStatus = taskStatus;
        this.assignedDate = assignedDate;
        this.id= UUID.randomUUID().getMostSignificantBits(); //burada yukarda id'imiz Long olduğundan lon return yapan UUID methodu seçtik
        //UUID, bir java functiondur ve bize uniq identifier sağlar
    }
}
