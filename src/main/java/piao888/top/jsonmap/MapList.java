package piao888.top.jsonmap;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import piao888.top.meijv.AAA;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapList {

public static void main(String[] args) {
//    List类型接收
    String jsonStringList="[{\"id\":1},{\"id\":2}]";
//    Map类型接收
    String jsonStringMap="{\"id\":1}";
    ObjectMapper mapper = new ObjectMapper();
    //如果是List类型
    JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, Bs.class);
    //如果是Map类型
//        一：复杂方法
//             1）
//    JavaType javaType= mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, Object.class);
    try {
        //List类型接收
        List<Bs> list =  (List<Bs>)mapper.readValue(jsonStringList, javaType);
        System.out.println(list.get(1).getId());
        //Map类型接收
//          2)
//          Map map= mapper.readValue(jsonStringMap, javaType);
//
//         二：第二种简便方法
            Map map= mapper.readValue(jsonStringMap, Map.class);
        System.out.println(map.get("id"));
    } catch (IOException e) {
        e.printStackTrace();
    }
}


}
