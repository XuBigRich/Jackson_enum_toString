package piao888.top.jsonlist;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.JavaType;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main<T> {
    static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws JsonParseException,
            JsonMappingException, IOException
    {

        String josn = "{\"userID\":1,\"loginname\":\"唐工\",\"truename\":\"超级\",\"nickname\":null,\"loginPwd\":\"E10ADC3949BA59ABBE56E057F20F883E\",\"qq\":\"\",\"phone\":\"\",\"email\":null,\"remark\":\"\",\"account_Non_Locked\":0,\"telelephone\":null,\"isDelete\":0}";
        User u = mapper.readValue(josn, User.class);
        // User u=new Main<User>().jsonStreamConverObject(josn, User.class);
        System.out.println("转对象:" + u);

        //  String转化为json格式
        /**
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
         //x转json的mapper方法
        josn = mapper.writeValueAsString(u);
        System.out.println(josn);
        **/

        // 转集合   ||||||  json 传过来 一个集合（List） 用 集合（List）接收  ||| json集合 转集合
        String josn2 = "[{\"userID\":1,\"loginname\":\"唐工\",\"truename\":\"超级\",\"nickname\":null,\"loginPwd\":\"E10ADC3949BA59ABBE56E057F20F883E\",\"qq\":\"\",\"phone\":\"\",\"email\":null,\"remark\":\"\",\"account_Non_Locked\":0,\"telelephone\":null,\"isDelete\":0},{\"userID\":1,\"loginname\":\"大富\",\"truename\":\"超级\",\"nickname\":null,\"loginPwd\":\"E10ADC3949BA59ABBE56E057F20F883E\",\"qq\":\"\",\"phone\":\"\",\"email\":null,\"remark\":\"\",\"account_Non_Locked\":0,\"telelephone\":null,\"isDelete\":0}]";
        JavaType javatype = mapper.getTypeFactory().constructParametricType(
                List.class, User.class);
        List<User> me = mapper.readValue(josn2, javatype);
        System.out.println("转集合me:" + me);

        // 对象里有 集合 转换 ||||||   json传过来 一个数据 其中 包含一个集合（List） 用对象 接收  |||  含有集合的 json  转对象
        String josn3 = "{\"userID\":1,\"loginname\":\"唐工\",\"truename\":\"超级\",\"nickname\":null,\"loginPwd\":\"E10ADC3949BA59ABBE56E057F20F883E\",\"qq\":\"\",\"phone\":\"\",\"email\":null,\"remark\":\"\",\"account_Non_Locked\":0,\"telelephone\":null,\"isDelete\":0,\"roleList\":[{\"roleid\":0,\"name\":\"超级管理员\",\"show_name\":\"超级管理员\",\"remark\":null,\"type\":1},{\"pp\":0,\"df\":\"大富\"}]}";

        User u3 = mapper.readValue(josn3, User.class); // 简单方式
        // User u3=new Main<User>().jsonConverObject(josn3, User.class); 流方式
        System.out.println("转对象里有集合u3:" + u3);

        // 集合 对象 集合 转换   |||||| json传过来一个集合2个数据 每个数据中 还包含一个集合（List）   用List接收   ||| json  集合 转 集合
        String josn4 = "[{\"userID\":1,\"loginname\":\"唐工\",\"truename\":\"超级\",\"nickname\":null,\"loginPwd\":\"E10ADC3949BA59ABBE56E057F20F883E\",\"qq\":\"\",\"phone\":\"\",\"email\":null,\"remark\":\"\",\"account_Non_Locked\":0,\"telelephone\":null,\"isDelete\":0,\"roleList\":[{\"roleid\":0,\"name\":\"超级管理员\",\"show_name\":\"超级管理员\",\"remark\":null,\"type\":1}]},{\"userID\":2,\"loginname\":\"大富\",\"truename\":\"超级\",\"nickname\":null,\"loginPwd\":\"E10ADC3949BA59ABBE56E057F20F883E\",\"qq\":\"\",\"phone\":\"\",\"email\":null,\"remark\":\"\",\"account_Non_Locked\":0,\"telelephone\":null,\"isDelete\":0,\"roleList\":[{\"roleid\":0,\"name\":\"超级管理员\",\"show_name\":\"超级管理员\",\"remark\":null,\"type\":1}]}]";
        JavaType javatype4 = mapper.getTypeFactory().constructParametricType(
                List.class, User.class);
        List<User> list = mapper.readValue(josn4, javatype4);
        System.out.println("集合里是对象 对象里有集合转换:" + list.get(1).getUserID());

    }

    /***
     * 转对象
     * @param josn
     * @param clz
     * @return
     */
    public T jsonStreamConverObject(String josn, Class<T> clz)
    {

        T t = null;
        // ObjectMapper jacksonMapper = new ObjectMapper();
        InputStreamReader in = new InputStreamReader(new ByteArrayInputStream(
                josn.getBytes()));
        BufferedReader streamReader = new BufferedReader(in);
        StringBuilder buff = new StringBuilder();
        String inputStr;
        try
        {
            while ((inputStr = streamReader.readLine()) != null)
                buff.append(inputStr);
            // ObjectMapper mapper = new ObjectMapper();
            t = mapper.readValue(buff.toString(), clz);

        } catch (IOException e)
        {

            e.printStackTrace();
        }

        return t;
    }

    /***
     * 转对象
     * @param josn
     * @param clz
     * @return
     */
    public T jsonConverObject(String josn, Class<T> clz)
    {

        T t = null;
        try
        {
            t = mapper.readValue(josn, clz);
        } catch (JsonParseException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return t;
    }

    /**
     * 转集合
     * @param josn
     * @param clz
     * @return
     */
    public List<T> jsonConverList(String josn, Class<T> clz)
    {

        List<T> me = null;
        try
        {
            // jacksonMapper
            // .disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
            // jacksonMapper.enableDefaultTyping();
            // jacksonMapper.setVisibility(JsonMethod.FIELD,JsonAutoDetect.Visibility.ANY);
            // jacksonMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT,
            // false);//格式化
            // jacksonMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
            // jacksonMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,
            // false);

            JavaType javatype = mapper.getTypeFactory()
                    .constructParametricType(List.class, clz);// clz.selGentype().getClass()

            me = mapper.readValue(josn,javatype);
        } catch (JsonParseException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return me;
    }
}
