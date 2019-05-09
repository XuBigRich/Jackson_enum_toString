package piao888.top.toString;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class TestTostring {
    private String name="大富";    //姓名
    private int age=21;    //年龄

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "TestTostring{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public String objConstructJson(Object obj){
        String json ="";
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        try {
            json = mapper.writeValueAsString(obj);
            System.out.println(json);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  json;
    }
}
