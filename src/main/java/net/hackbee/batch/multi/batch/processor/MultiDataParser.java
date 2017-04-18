package net.hackbee.batch.multi.batch.processor;

import net.hackbee.batch.multi.dto.EmployeeFileDto;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Hackbee on 4/18/2017.
 */
public class MultiDataParser implements ItemProcessor<String, EmployeeFileDto> {
    @Override
    public EmployeeFileDto process(String item) throws Exception {
        return null;
    }
}
