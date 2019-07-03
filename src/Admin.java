/**
 * @ClassName Admin
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/3 15:59
 * @Version 1.0
 **/
public class Admin extends User{

    public Admin(String name, String password) {
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
