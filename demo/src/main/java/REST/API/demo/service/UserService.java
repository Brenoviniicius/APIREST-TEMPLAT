package REST.API.demo.service;

import REST.API.demo.models.User;
import REST.API.demo.models.repositories.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Setter
@Getter
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //read
    public User findById (Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not find by this id:" + id));
    }

    //create
    @Transactional
    public User create(User obj) {
        obj.setId(null);
        obj = this.userRepository.save(obj);
        return obj;
    }

    //update
    @Transactional
    public User update(User obj) {
        User newObj = findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userRepository.save(newObj);
    }

    //delete
    public void delete(Long id) {
        findById(id);
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("It is not possible to delete this type of data");
        }

    }


}
