package hackbee.batch.process.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import hackbee.batch.data.model.EmployeeEntity;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * Created by Hackbee on 5/8/2017.
 */
public class CsvFileReader extends FlatFileItemReader<EmployeeEntity> implements StepExecutionListener {

  private File file = null;

  @BeforeStep
  public void beforeStep(StepExecution stepExecution) {
    try {
      file = new File(new URL((String) stepExecution.getExecutionContext().get("csv-file-per-context")).toURI());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    setResource(new FileSystemResource(file));
  }

  @Override
  public ExitStatus afterStep(StepExecution stepExecution) {
    return null;
  }

  @Override
  public void setResource(Resource resource) {
    System.out.println("Setting up reader with resource: #### " + resource.getFilename());
    super.setResource(resource);
  }

  public CsvFileReader() throws MalformedURLException, URISyntaxException, FileNotFoundException {
    super.setSaveState(false);
    super.setLinesToSkip(1);
    super.setLineMapper(new CsvLineMapper());
  }
}
