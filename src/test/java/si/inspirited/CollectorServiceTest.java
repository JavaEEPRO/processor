package si.inspirited;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import si.inspirited.service.ICollectorService;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectorServiceTest {

    @Autowired
    ICollectorService collectorService;

    @Autowired
    Environment env;

    @Test
    public void getSnapshot_whenReceivedListIsNotEmpty_thenCorrect() {
        String url = env.getProperty("url.source.allCompaniesReview");
        List<Object> expectedDataFromInputStream = collectorService.getSnapshot(url);

        assertNotNull(expectedDataFromInputStream);
        assertFalse(expectedDataFromInputStream.isEmpty());
    }
}
