package hackbee.batch.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import hackbee.batch.data.model.EmployeeEntity;
import hackbee.batch.data.repository.EmployeeRepository;
import hackbee.batch.process.CsvPartitioner;
import hackbee.batch.process.JobCustomExecutionListener;
import hackbee.batch.process.read.CsvFileReader;
import hackbee.batch.process.write.EmployeeWriter;
import hackbee.batch.utils.ResourceInitializer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * Created by Hackbee on 5/8/2017.
 */
@Configuration
@EnableBatchProcessing
public class BatchJobConfig {

  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  @Autowired
  public ResourceInitializer resourceInitializer;

  @Autowired
  public EmployeeRepository employeeRepository;

  public final static String CSV_DATA_PROVIDER_JOB = "CSV_DATA_PROVIDER_JOB";

  @Bean
  public Job csvDataProviderJob() throws IOException, URISyntaxException {
    return jobBuilderFactory.get(CSV_DATA_PROVIDER_JOB).start(csvPartitionerStep()).listener(jobExecutionListener()).build();
  }

  @Bean
  public JobExecutionListener jobExecutionListener() {
    return new JobCustomExecutionListener();
  }

  @Bean
  public Step csvPartitionerStep() throws IOException, URISyntaxException {
    return stepBuilderFactory.get("csvPartitioner").partitioner(csvReadAndWriteStep())
        .partitioner("csvPartitioner", csvPartitioner())
        .taskExecutor(new SimpleAsyncTaskExecutor()).build();
  }

  @Bean
  public Step csvReadAndWriteStep() throws FileNotFoundException, MalformedURLException, URISyntaxException {
    return stepBuilderFactory.get("csvReadAndWriteStep")
        .<EmployeeEntity, EmployeeEntity>chunk(100)
        .reader(csvFileReader())
        .writer(employeeWriter())
        .build();
  }

  @Bean
  public CsvPartitioner csvPartitioner() throws IOException {
    return new CsvPartitioner(resourceInitializer.getResources());
  }

  @Bean
  @StepScope
  public CsvFileReader csvFileReader() throws FileNotFoundException, URISyntaxException, MalformedURLException {
    return new CsvFileReader();
  }

  @Bean
  public EmployeeWriter employeeWriter() {
    return new EmployeeWriter(employeeRepository);
  }
}
