package com.cybertek.service;

import com.cybertek.dto.TaskDTO;

public interface TaskService extends CrudService<TaskDTO, Long>{ // unique type long olduğundan onu yazdık. Yani TaskDTO'da primary key olarak Long id field yapmıştık ondan
}
