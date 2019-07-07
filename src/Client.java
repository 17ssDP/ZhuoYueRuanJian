import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName Client
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/5 15:31
 * @Version 1.0
 **/
public class Client {
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 8000);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            Scanner input = new Scanner(System.in);
            while(true){
                System.out.println("想要使用功能强大的本系统么？请选择您的用户类型，Admin(输入1)或者NormalUser(输入2)");
                int userType = input.nextInt();
                System.out.println("请登录先（输入1），什么，没有用户名，赶紧注册啊（输入2）：");
                int num = input.nextInt();
                if(num == 1) {
                    handleLogin(userType);
                    break;
                }else if(num == 2) {
                    handleSignUp(userType);
                }
            }
        }catch (IOException io) {
            io.printStackTrace();
        }
    }
    private static void handleLogin(int userType) throws IOException{
        assert (userType == 1 || userType == 2);
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您的大名：");
        String name = input.next();
        System.out.println("请输入您的密码：");
        String pwd = input.next();
        String message = userType + "\n" + "1" + "\n" + name + "\n" + pwd;
        outputStream.writeUTF(message);
        boolean islogin = inputStream.readBoolean();
        while (!islogin) {
            System.out.println("用户名和密码不对啊～，想想再输入！");
            System.out.println("请输入您的大名：");
            name = input.next();
            System.out.println("请输入您的密码：");
            pwd = input.next();
            message = userType + "\n" + "1" + "\n" + name + "\n" + pwd;
            outputStream.writeUTF(message);
            islogin = inputStream.readBoolean();
        }
        System.out.println("验证通过！你可以使用我们系统强大的功能啦！");
    }
    private static void handleSignUp(int userType) throws IOException{
        assert (userType == 1 || userType == 2);
        Scanner input = new Scanner(System.in);
        System.out.println("您想用的大名是?请输入用户名：");
        String name = input.next();
        String message = userType + "\n" + "2" + "\n" + name;
        outputStream.writeUTF(message);
        boolean exist = inputStream.readBoolean();
        while(exist) {
            System.out.println(name + "被别人用啦，想想别的？请输入用户名：");
            name = input.next();
            message = userType + "\n" + "2" + "\n" + name;
            outputStream.writeUTF(message);
            exist = inputStream.readBoolean();
        }
        System.out.println("恭喜！这个名字可用，欢迎" + name + "，请输入密码:");
        String pwd = input.next();
        message = userType + "\n" + "2" + "\n" + name + "\n" + pwd;
        outputStream.writeUTF(message);
        System.out.println("注册成功！");
    }
}
