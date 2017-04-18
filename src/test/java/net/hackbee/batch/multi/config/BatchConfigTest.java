package net.hackbee.batch.multi.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Hackbee on 4/18/2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BatchConfig.class})
public class BatchConfigTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void checkConfig_jobBeans_stepBeans_arePresent() {
        assertThat(applicationContext.getBean(Job.class)).isNotNull();
        assertThat(applicationContext.getBean("multiReadAndParse")).isNotNull();
        assertThat(applicationContext.getBean("validate")).isNotNull();
        assertThat(applicationContext.getBean("persist")).isNotNull();
    }

    @Test
    public void checkConfig_multiReadAndParseStep_hasReadWriteProcessorBeans() {
        assertThat(applicationContext.getBean("multiResourceReader")).isNotNull();
        assertThat(applicationContext.getBean("multiDataParser")).isNotNull();
        assertThat(applicationContext.getBean("multiDataWriter")).isNotNull();
    }

}
