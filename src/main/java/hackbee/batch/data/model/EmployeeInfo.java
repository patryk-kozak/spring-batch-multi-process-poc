package hackbee.batch.data.model;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created by Hackbee on 5/8/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class EmployeeInfo {

  @Id
  private Long id;
  private String emergencyContactNumber;
  private String emergencyContactName;
  private Long salary;
  private Double score;
}
