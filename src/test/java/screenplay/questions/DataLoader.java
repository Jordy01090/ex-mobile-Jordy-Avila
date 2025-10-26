package screenplay.questions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DataLoader {

    public static Map<String, String> loadCredentials() {
        Map<String, String> creds = fromJson("/data/credentials.json");
        if (creds != null && creds.containsKey("user") && creds.containsKey("pass")) {
            return creds;
        }
        Map<String, String> csv = fromCsv("/data/credentials.csv");
        if (csv != null) return csv;

        // fallback defaults (visible en la app)
        Map<String, String> def = new HashMap<>();
        def.put("user", "standard_user");
        def.put("pass", "secret_sauce");
        return def;
    }

    private static Map<String, String> fromJson(String path) {
        try (InputStream is = DataLoader.class.getResourceAsStream(path)) {
            if (is == null) return null;
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(is);
            Map<String, String> map = new HashMap<>();
            if (root.has("user")) map.put("user", root.get("user").asText());
            if (root.has("pass")) map.put("pass", root.get("pass").asText());
            return map;
        } catch (Exception e) {
            return null;
        }
    }

    private static Map<String, String> fromCsv(String path) {
        try (InputStream is = DataLoader.class.getResourceAsStream(path)) {
            if (is == null) return null;
            CSVReader reader = new CSVReader(new InputStreamReader(is));
            String[] header = reader.readNext();
            String[] row = reader.readNext();
            if (header == null || row == null) return null;
            Map<String, Integer> idx = new HashMap<>();
            for (int i = 0; i < header.length; i++) idx.put(header[i].trim().toLowerCase(), i);
            Map<String, String> map = new HashMap<>();
            if (idx.containsKey("user")) map.put("user", row[idx.get("user")]);
            if (idx.containsKey("pass")) map.put("pass", row[idx.get("pass")]);
            return map;
        } catch (Exception e) {
            return null;
        }
    }
}
