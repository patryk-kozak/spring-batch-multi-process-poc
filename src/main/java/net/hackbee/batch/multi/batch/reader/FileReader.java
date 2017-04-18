package net.hackbee.batch.multi.batch.reader;

import lombok.RequiredArgsConstructor;
import net.hackbee.batch.multi.batch.EmployeeFieldSetMapper;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Hackbee on 4/18/2017.
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileReader extends FlatFileItemReader<String> {

    private EmployeeFieldSetMapper employeeFieldSetMapper;

    public FileReader(int linesToSkip) {
        super();
        super.setLinesToSkip(linesToSkip);
        instanceLineMapper();
    }

    public DefaultLineMapper<String> instanceLineMapper() {
        DefaultLineMapper<String> defaultLineMapper = new DefaultLineMapper<>();
        defaultLineMapper.setLineTokenizer(new DelimitedLineTokenizer(","));
        defaultLineMapper.setFieldSetMapper(new BeanWrapperFieldSetMapper<>());
        return defaultLineMapper;
    }

}
