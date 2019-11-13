package si.inspirited;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import si.inspirited.service.IAdvancedCollectorService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdvancedCollectorServiceTests {

    @Autowired
    IAdvancedCollectorService advancedCollectorService;

    @Autowired
    Environment env;

    final String STOCK_CODE_STUB = "MSFT";

    @Test
    public void getExtendedCompanySnapshot_WhenReceivedObjectIsNotNull_thenCorrect() {
        Object expectedData = advancedCollectorService.getExtendedCompanySnapshot(env.getProperty("url.source.extendedCompanyReview"), STOCK_CODE_STUB);
        assertNotNull(expectedData);
    }
}
