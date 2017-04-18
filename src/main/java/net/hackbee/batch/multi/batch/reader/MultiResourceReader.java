package net.hackbee.batch.multi.batch.reader;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

/**
 * Created by Hackbee on 4/18/2017.
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MultiResourceReader extends MultiResourceItemReader {

    private ApplicationContext applicationContext;

    public void setDelegate() {
        super.setDelegate(new FileReader(1));
    }

    public void setResources() {
        try {
            super.setResources(applicationContext.getResources("classpath:csv_data/*.csv"));
        } catch (IOException ex) {
            //HINT: implement yours handling
        }
    }


}
