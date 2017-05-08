package hackbee.batch.data.repository;

import hackbee.batch.data.model.EmployeeInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Hackbee on 5/8/2017.
 */
public interface EmployeeInfoRepository extends MongoRepository<EmployeeInfo, Long> {
}
