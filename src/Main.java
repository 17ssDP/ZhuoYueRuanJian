import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/3 15:55
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("想要使用功能强大的本系统么？请登录先（输入1），什么，没有用户名，赶紧注册啊（输入2）：");
            int num = input.nextInt();
            if(num == 1) {
                handleLogin();
                break;
            }else if(num == 2) {
                handleSignUp();
            }
        }
    }
    private static void handleLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您的大名：");
        String name = input.next();
        System.out.println("请输入您的密码：");
        String pwd = input.next();
        User user = new NormalUser(name, pwd);
        while (!user.login()) {
            System.out.println("用户名和密码不对啊～，想想再输入！");
            System.out.println("请输入您的大名：");
            name = input.next();
            System.out.println("请输入您的密码：");
            pwd = input.next();
            user = new NormalUser(name, pwd);
            user.login();
        }
        System.out.println("验证通过！你可以使用我们系统强大的功能啦！");
    }
    private static void handleSignUp() {
        Scanner input = new Scanner(System.in);
        System.out.println("您想用的大名是?请输入用户名：");
        String name = input.next();
        while(Data.exist(name)) {
            System.out.println(name + "被别人用啦，想想别的？请输入用户名：");
            name = input.next();
        }
        System.out.println("恭喜！这个名字可用，欢迎" + name + "，请输入密码:");
        String pwd = input.next();
        User user = new NormalUser(name, pwd);
        if(user.signUp()) {
            System.out.println("注册成功！");
        } else {
            System.out.println("注册失败！");
        }
    }
}
