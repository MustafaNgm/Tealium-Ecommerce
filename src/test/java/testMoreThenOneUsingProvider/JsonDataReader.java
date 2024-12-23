package testMoreThenOneUsingProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {
	public List<Object[]> JsonReader() throws IOException, ParseException {
       
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/UserData.json";

       
        File srcFile = new File(filePath);
		
        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));

        List<Object[]> data = new ArrayList<>();

        for (Object jsonObj : jarray) {
            JSONObject person = (JSONObject) jsonObj;

		
		String firstname = (String) person.get("firstname");
            String middlename = (String) person.get("middlename");
            String lastname = (String) person.get("lastname");
            String email = (String) person.get("email");
            String password = (String) person.get("password");

            // إضافة البيانات إلى القائمة
            data.add(new Object[]{firstname, middlename, lastname, email, password});
        }

        return data;
    }
}
