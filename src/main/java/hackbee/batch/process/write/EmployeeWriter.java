package hackbee.batch.process.write;

import hackbee.batch.data.model.EmployeeEntity;
import hackbee.batch.data.repository.EmployeeRepository;
import org.springframework.batch.item.data.RepositoryItemWriter;

/**
 * Created by Hackbee on 5/8/2017.
 */
public class EmployeeWriter extends RepositoryItemWriter<EmployeeEntity> {

  public EmployeeWriter(EmployeeRepository employeeRepository) {
    super.setRepository(employeeRepository);
    super.setMethodName("save");
  }

}
