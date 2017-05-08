package hackbee.batch.process;

import java.io.IOException;

import org.springframework.batch.core.partition.support.MultiResourcePartitioner;
import org.springframework.core.io.Resource;

/**
 * Created by Hackbee on 5/8/2017.
 */
public class CsvPartitioner extends MultiResourcePartitioner {

  public CsvPartitioner(Resource[] resources) throws IOException {
    super.setResources(resources);
    super.setKeyName("csv-file-per-context");
  }

}
