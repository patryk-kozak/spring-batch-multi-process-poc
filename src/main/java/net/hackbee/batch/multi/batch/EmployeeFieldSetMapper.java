package net.hackbee.batch.multi.batch;

import net.hackbee.batch.multi.dto.EmployeeFileDto;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

/**
 * Created by Hackbee on 4/18/2017.
 */
@Component
public class EmployeeFieldSetMapper implements FieldSetMapper<EmployeeFileDto> {
    @Override
    public EmployeeFileDto mapFieldSet(FieldSet fieldSet) throws BindException {
        EmployeeFileDto newDto = new EmployeeFileDto();
        newDto.setId(fieldSet.readLong(0));
        newDto.setFirstName(fieldSet.readString(1));
        newDto.setLastName(fieldSet.readString(2));
        newDto.setAlias(fieldSet.readString(3));
        newDto.setPhoneNumber(fieldSet.readRawString(4));
        newDto.setCreditCardNumber(fieldSet.readRawString(5));
        return newDto;
    }
}
