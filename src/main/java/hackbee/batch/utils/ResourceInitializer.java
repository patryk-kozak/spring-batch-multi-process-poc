package hackbee.batch.utils;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

/**
 * Can be anything, in ex. reading from classpath
 * Created by Hackbee on 5/8/2017.
 */
@Component
public class ResourceInitializer {

  public Resource[] getResources() throws IOException {
    return readFromResourceFolder();
  }

  private Resource[] readFromResourceFolder() throws IOException {
    return new PathMatchingResourcePatternResolver(this.getClass().getClassLoader())
        .getResources("classpath*:/csv_data/*.csv");
  }

}
