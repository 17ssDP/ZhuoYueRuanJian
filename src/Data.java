import java.util.HashMap;

/**
 * @ClassName Data
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/3 15:56
 * @Version 1.0
 **/
public class Data {
    private static HashMap<String, String> data = new HashMap<>();

    public static boolean insert(String name, String pwd) {
        if(data.get(name) == null) {
            data.put(name, pwd);
            return true;
        }
        return false;
    }

    public static String search(String name) {
        return data.get(name);
    }

    public static boolean exist(String name) {
        return data.containsKey(name);
    }
}
