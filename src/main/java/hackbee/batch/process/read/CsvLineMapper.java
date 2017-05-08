package hackbee.batch.process.read;


import hackbee.batch.data.model.EmployeeEntity;
import hackbee.batch.utils.GenericBuilder;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created by Hackbee on 5/8/2017.
 */
public class CsvLineMapper implements LineMapper<EmployeeEntity> {

  private FieldSetMapper<EmployeeEntity> wrapperFieldSetMapper = new FieldSetMapper<EmployeeEntity>() {
    @Override
    public EmployeeEntity mapFieldSet(FieldSet fieldSet) throws BindException {
      return GenericBuilder.of(EmployeeEntity::new)
          .with(EmployeeEntity::setFirstName, fieldSet.readString(1))
          .with(EmployeeEntity::setLastName, fieldSet.readString(2))
          .with(EmployeeEntity::setAlias, fieldSet.readString(3))
          .with(EmployeeEntity::setEmployeeNumber, fieldSet.readString(4))
          .with(EmployeeEntity::setCreditCardNumber, fieldSet.readString(5))
          .build();
    }
  };
  private DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

  @Override
  public EmployeeEntity mapLine(String line, int lineNumber) throws Exception {
    return wrapperFieldSetMapper.mapFieldSet(lineTokenizer.tokenize(line));
  }
}
