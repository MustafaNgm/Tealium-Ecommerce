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
        // تحديد مسار ملف JSON
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/UserData.json";

        // إنشاء ملف للقراءة
        File srcFile = new File(filePath);

        // قراءة JSON باستخدام JSONParser
        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));

        // إنشاء قائمة لتخزين البيانات
        List<Object[]> data = new ArrayList<>();

        // قراءة كل عنصر في المصفوفة JSON
        for (Object jsonObj : jarray) {
            JSONObject person = (JSONObject) jsonObj;

            // قراءة القيم من JSON
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