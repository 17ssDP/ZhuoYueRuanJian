/**
 * @ClassName User
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/3 15:58
 * @Version 1.0
 **/
public abstract class User {
    String name;
    String pwd;
    boolean status = false;
    public abstract boolean login();
    public abstract boolean signUp();
}
