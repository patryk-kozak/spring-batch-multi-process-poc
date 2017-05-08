package hackbee.batch.data.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import static hackbee.batch.data.model.EmployeeEntity.TABLE_NAME;

/**
 * Created by Hackbee on 5/8/2017.
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@Table(name = TABLE_NAME)
public class EmployeeEntity implements Serializable {

  public final static String TABLE_NAME = "DATA_RECORDS";
  public final static String SEQUENCE_NAME = "DATA_RECORDS_DATARECORDS_ID_SEQ";

  @Id
  @Column(name = "DATARECORDS_ID")
  @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, initialValue = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
  private Long id;
  @Column(name = "FIRST_NAME")
  private String firstName;
  @Column(name = "LAST_NAME")
  private String lastName;
  @Column(name = "ALIAS")
  private String alias;
  @Column(name = "EMPLOYEE_NUMBER")
  private String employeeNumber;
  @Column(name = "CREDIT_CARD_NUMBER")
  private String creditCardNumber;

}
