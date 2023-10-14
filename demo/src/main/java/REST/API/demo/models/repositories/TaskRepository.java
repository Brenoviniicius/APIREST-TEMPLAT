package REST.API.demo.models.repositories;

import REST.API.demo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {

    List<Task> findByUser_id(long id);
}
