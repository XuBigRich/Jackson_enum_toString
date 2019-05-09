package piao888.top.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Test {
    private String name;
    private int age;

    public Test() {
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Test [ name: " + name + ", age: " + age + " ]";
    }
}
    class JacksonTester{
    public static void main(String[] args) {
          ObjectMapper mapper = new ObjectMapper();
          String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
        try {
            Test test = mapper.readValue(jsonString, Test.class);
            System.out.println(test);
            // 转换为格式化的json
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(test);
            System.out.println(jsonString);


            // 如果json中有新增的字段并且是实体类类中不存在的，不报错
//            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

