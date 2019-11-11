package si.inspirited.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomPropertiesIntegrationTest {

    @Autowired
    Environment env;

    @Test
    public void getCustomProperty_whenReceivedPropertyIsNotEmpty_thenCorrect() {
        String expectedProperty = env.getProperty("url.source.allCompaniesReview");

        assertNotNull(expectedProperty);
        assertNotEquals("", expectedProperty);
    }
}
