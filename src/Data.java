import java.util.HashMap;

/**
 * @ClassName Data
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/3 15:56
 * @Version 1.0
 **/
public class Data {
    private static HashMap<String, String> normalUserData = new HashMap<>();
    private static HashMap<String, String> adminData = new HashMap<>();
    public static boolean insert(int type, String name, String pwd) {
        HashMap<String, String> data = type == 1? adminData : normalUserData;
        if(data.get(name) == null) {
            data.put(name, pwd);
            return true;
        }
        return false;
    }

    public static String search(int type, String name) {
        HashMap<String, String> data = type == 1? adminData : normalUserData;
        return data.get(name);
    }

    public static boolean exist(int type, String name) {
        HashMap<String, String> data = type == 1? adminData : normalUserData;
        return data.containsKey(name);
    }
}
