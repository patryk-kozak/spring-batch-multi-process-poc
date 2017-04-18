package net.hackbee.batch.multi.config;

import lombok.RequiredArgsConstructor;
import net.hackbee.batch.multi.batch.processor.MultiDataParser;
import net.hackbee.batch.multi.batch.reader.MultiResourceReader;
import net.hackbee.batch.multi.batch.writer.MultiDataWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Hackbee on 4/18/2017.
 */
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BatchConfig {

    private JobBuilderFactory jobBuilder;
    private StepBuilderFactory stepBuilder;

    @Bean
    public Job testJob() {
        return jobBuilder.get("testJob").start(multiReadAndParse()).next(validate()).next(persist()).build();
    }

    /**
     * Beans - Steps
     */

    @Bean
    public Step multiReadAndParse() {
        return stepBuilder.get("multiReadAndParse").chunk(500)
                .reader(multiResourceReader())
                .processor(multiDataParser())
                .writer(multiDataWriter())
                .build();
    }

    @Bean
    public Step validate() {
        return stepBuilder.get("validate").chunk(500)
//                .reader()
//                .processor()
                .build();
    }

    @Bean
    public Step persist() {
        return stepBuilder.get("persist").chunk(500)
//                .reader()
//                .writer()
                .build();
    }

    /**
     * Beans - Readers/Writers/Processors
     */

    @Bean
    public MultiResourceReader multiResourceReader() {
        return new MultiResourceReader();
    }

    @Bean
    public MultiDataParser multiDataParser() {
        return new MultiDataParser();
    }

    @Bean
    public MultiDataWriter multiDataWriter() {
        return new MultiDataWriter();
    }
}
