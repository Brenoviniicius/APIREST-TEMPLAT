package REST.API.demo.service;

import REST.API.demo.models.repositories.TaskRepository;
import REST.API.demo.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;
}
