package data;

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
    public String firstname, middlename, lastname, email, password;

    public List<Object[]> JsonReader() throws IOException, ParseException {
        // تحديد مسار ملف JSON
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/UserData.json";

        // إنشاء ملف للقراءة
        File srcFile = new File(filePath);

        // قراءة JSON باستخدام JSONParser
        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));

        // إنشاء قائمة لتخزين البيانات
        List<Object[]> dataList = new ArrayList<>();

        // قراءة كل عنصر في المصفوفة JSON
        for (Object jsonObj : jarray) {
            JSONObject person = (JSONObject) jsonObj;

            // قراءة القيم من JSON
            firstname = (String) person.get("firstname");
            middlename = (String) person.get("middlename");
            lastname = (String) person.get("lastname");
            email = (String) person.get("email");
            password = (String) person.get("password");

            // إضافة القيم إلى القائمة
            dataList.add(new Object[] { firstname, middlename, lastname, email, password });

            // طباعة القيم للتحقق
            System.out.println("First Name: " + firstname);
            System.out.println("Middle Name: " + middlename);
            System.out.println("Last Name: " + lastname);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
        }

        // إرجاع القائمة
        return dataList;
    }
}
