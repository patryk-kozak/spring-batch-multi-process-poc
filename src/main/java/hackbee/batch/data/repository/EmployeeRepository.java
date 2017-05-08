package hackbee.batch.data.repository;

import hackbee.batch.data.model.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Hackbee on 5/8/2017.
 */
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

}
