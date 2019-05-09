package piao888.top.map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

public class JsonTest {
    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException
    {
        User user=new User();
        user.setId("01");
        user.setName("张三");
        user.setAge(33);
        user.setPay(6666.88);
        user.setValid(true);
        user.setOne('E');
        user.setBirthday(new Date(20l*366*24*3600*1000)); //1990年

        Link link = new Link();
        link.setAddress("河南省济源市");
        link.setPhone("13899995555");
        link.setQq("123456");
        user.setLink(link);

        Map map=new HashMap();
        map.put("aa", "this is aa");
        map.put("bb", "this is bb");
        map.put("cc", "this is cc");
        user.setMap(map);

        List list=new ArrayList(){};
        list.add("普洱");
        list.add("大红袍");
        user.setList(list);

        Set set=new HashSet();
        set.add("篮球");
        set.add("足球");
        set.add("乒乓球");
        user.setSet(set);

        ObjectMapper mapper = new ObjectMapper(); //转换器

        //测试01：对象--json
        String json=mapper.writeValueAsString(user); //将对象转换成json
        System.out.println(json);
        /* 结果如下：
        {"id":"01","name":"张三","age":33,"pay":6666.88,"valid":true,"one":"E","birthday":1465185448998,
        "link":{"phone":"13899995555","address":"河南省济源市","qq":"123456"},
        "map":{"aa":"this is aa","bb":"this is bb","cc":"this is cc"},
        "list":["普洱","大红袍"],
        "set":["乒乓球","足球","篮球"]}

        注意点：（1） 日期--长整型 （2）List、Set均转成数组
         */

        //测试02：json--map
        Map m = mapper.readValue(json, Map.class); //json转换成map

        System.out.println("pay："+m.get("pay").getClass().getName()); //java.lang.Double
        System.out.println("valid："+m.get("valid").getClass().getName()); //java.lang.Boolean
        System.out.println("birthday："+m.get("birthday").getClass().getName()); //java.lang.Long
        System.out.println("link："+m.get("link").getClass().getName()); //java.util.LinkedHashMap
        System.out.println("map："+m.get("map").getClass().getName()); //java.util.LinkedHashMap
        System.out.println("list："+m.get("list").getClass().getName()); //java.util.ArrayList
        System.out.println("set："+m.get("set").getClass().getName()); //java.util.ArrayList
        System.out.println("aaaaaaaaaaaaaaaaa"+m.get("pay"));
        /*  结果如下：
            pay：java.lang.Double
            valid：java.lang.Boolean
            birthday：java.lang.Long
            link：java.util.LinkedHashMap
            map：java.util.LinkedHashMap
            list：java.util.ArrayList
            set：java.util.ArrayList

            注意点：（1） 日期--长整型  （2）map、子对象均转换成了LinkedHashMap （3）List、Set均转成ArrayList
         */

        //测试03：map--json
        json=mapper.writeValueAsString(m); //map转json
        System.out.println(json); //与之前格式完全相同，说明经过map转换后，信息没有丢失

        //测试04：json--对象
        User u=mapper.readValue(json, User.class); //json转java对象。经测，转成对象后，一切恢复正常
        System.out.println("pay："+u.getPay());
        System.out.println("valid："+u.isValid());
        System.out.println("birthday："+u.getBirthday());
        System.out.println("link："+u.getLink());
        System.out.println("map："+u.getMap());
        System.out.println("list："+u.getList());
        System.out.println("set："+u.getSet());

        //测试05：其他转换
        byte[] data=mapper.writeValueAsBytes(u); //对象转成二进制数组


    }
}
