package si.inspirited.service.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import si.inspirited.error.UnexpectedReceivedDataFormatException;
import si.inspirited.service.ICollectorService;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class CollectorService implements ICollectorService {

    @Override
    public List<Object> getSnapshot(final String url) {
        JSONArray json = new JSONArray();
        try {
            json = readJsonFromUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toList();
    }
    
    private JSONArray readJsonFromUrl(final String url) throws IOException {
        try (InputStream inputStream = new URL(url).openStream()) {
            return readJsonFromInputStream(inputStream);
        }
    }

    public JSONArray readJsonFromInputStream(final InputStream inputStream) throws IOException, UnexpectedReceivedDataFormatException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String jsonText = readAll(bufferedReader);
        JSONArray json = new JSONArray();
        try {
            json = new JSONArray(jsonText);
        } catch (JSONException jsonException) {
            UnexpectedReceivedDataFormatException unexpectedReceivedDataFormatException = new UnexpectedReceivedDataFormatException(jsonException.getMessage(), jsonException.getCause());
            unexpectedReceivedDataFormatException.setStackTrace(jsonException.getStackTrace());
            throw unexpectedReceivedDataFormatException;
        }
        return json;
    }

    private String readAll(Reader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int cp;
        while ((cp = reader.read()) != -1) {
            stringBuilder.append((char) cp);
        }
        return stringBuilder.toString();
    }    
}
