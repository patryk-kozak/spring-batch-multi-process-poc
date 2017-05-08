package hackbee.batch.process;

import java.time.ZonedDateTime;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * Created by Hackbee on 5/9/2017.
 */
public class JobCustomExecutionListener implements JobExecutionListener {

  @Override
  public void beforeJob(JobExecution jobExecution) {
    System.out.println("START JOB" + ZonedDateTime.now());
  }

  @Override
  public void afterJob(JobExecution jobExecution) {
    System.out.println("END JOB" + ZonedDateTime.now());
  }
}
