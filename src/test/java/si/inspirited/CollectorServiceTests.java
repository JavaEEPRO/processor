package si.inspirited;

import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import si.inspirited.dto.RowDto;
import si.inspirited.error.UnexpectedReceivedDataFormatException;
import si.inspirited.service.ICollectorService;
import si.inspirited.service.impl.CollectorService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectorServiceTests {

    @Autowired
    ICollectorService collectorService;

    @Autowired
    Environment env;

    private final String MOCK_DATA_AS_ARRAY = "[{'json':'test data'},{'exit' : '0'}]";
    private final String OBVIOUSLY_INCORRECT_DATA = "['unstructured json}, test data'{]exit : 1";

    @Test
    public void getSnapshot_whenReceivedListIsNotEmpty_thenCorrect() {
        String url = env.getProperty("url.source.allCompaniesReview");
        String token = env.getProperty("token");
        List<RowDto> expectedDataFromInputStream = (List<RowDto>) collectorService.getSnapshot(url, token);

        assertNotNull(expectedDataFromInputStream);
        assertFalse(expectedDataFromInputStream.isEmpty());
    }

    @Test
    public void readJsonFromInputStream_whenReceivedDataCorrespondsToSent_thenCorrect() {
        CollectorService instance = new CollectorService();
        JSONArray res = new JSONArray();
        try {
            res = instance.readJsonFromInputStream(mockInputStream(MOCK_DATA_AS_ARRAY));
        }catch(IOException e) { e.printStackTrace(); }
        int etalonLength = MOCK_DATA_AS_ARRAY.split(",").length;
        assertEquals(etalonLength, res.length());
        String[] sentData = MOCK_DATA_AS_ARRAY.split("'");
        String[] receivedData = res.toString().split("\"");

        for (int i = 0; i < sentData.length; i++) {
            assertEquals(sentData[i].trim(), receivedData[i].trim());
        }
    }

    @Test(expected = UnexpectedReceivedDataFormatException.class)
    public void feedObviouslyIncorrectDataIntoReadJsonFromInputStream_whenThrowsUnexpectedDataFormatException_thenCorrect() {
        CollectorService instance = new CollectorService();
        try {
            instance.readJsonFromInputStream(mockInputStream(OBVIOUSLY_INCORRECT_DATA));
        }catch(IOException e) { e.printStackTrace(); }
    }

    private InputStream mockInputStream(final String dataToSent) {
        return new ByteArrayInputStream(dataToSent.getBytes());
    }
}