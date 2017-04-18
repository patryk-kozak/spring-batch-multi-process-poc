package net.hackbee.batch.multi.batch.writer;

import net.hackbee.batch.multi.dto.EmployeeFileDto;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by Hackbee on 4/18/2017.
 */
public class MultiDataWriter implements ItemWriter<EmployeeFileDto> {
    @Override
    public void write(List<? extends EmployeeFileDto> items) throws Exception {

    }
}
