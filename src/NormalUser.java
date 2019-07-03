/**
 * @ClassName NormalUser
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/3 15:58
 * @Version 1.0
 **/
public class NormalUser extends User{

    public NormalUser(String name, String password) {
        this.name = name;
        this.pwd = password;
    }

    public boolean login() {
        status = pwd.equals(Data.search(name));
        return  status;
    }

    public boolean signUp() {
        return Data.insert(name, pwd);
    }
}
