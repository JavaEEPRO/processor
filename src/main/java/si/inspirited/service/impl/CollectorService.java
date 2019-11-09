package si.inspirited.service.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import si.inspirited.service.ICollectorService;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@Service
public class CollectorService implements ICollectorService {

    @Override
    public List<Object> getSnapshot() {
        JSONArray json = new JSONArray();
        try {
            json = readJsonFromUrl("https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_ee567917a6b640bb8602834c9d30e571");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toList();
    }
    
    static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        try (InputStream inputStream = new URL(url).openStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String jsonText = readAll(bufferedReader);
            JSONArray json = new JSONArray(jsonText);
            return json;
        }
    }

    private static String readAll(Reader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int cp;
        while ((cp = reader.read()) != -1) {
            stringBuilder.append((char) cp);
        }
        return stringBuilder.toString();
    }    
}
