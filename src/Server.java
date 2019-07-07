import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/5 15:31
 * @Version 1.0
 **/
public class Server {

    public static void main(String[] args) {
        new Server();
    }

    Server() {
        try{
            ServerSocket serverSocket = new ServerSocket(8000);
            while(true) {
                Socket socket = serverSocket.accept();
                HandleThread handleThread = new HandleThread(socket);
                handleThread.start();
            }
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    class HandleThread extends Thread {
        Socket socket;
        HandleThread(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try{
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                while(true) {
                    String[] strs = inputStream.readUTF().split("\n");
                    assert("1".equals(strs[0]) || "2".equals(strs[0]));
                    assert("1".equals(strs[1]) || "2".equals(strs[1]));
                    if(strs.length == 3) {
                        if(Data.exist(Integer.parseInt(strs[0]), strs[2])) {
                            outputStream.writeBoolean(true);
                        }else {
                            outputStream.writeBoolean(false);
                        }
                    }else {
                        User user = getUser(strs);
                        if(strs[1].equals("1")) {
                            outputStream.writeBoolean(user.login());
                            if(user.status)
                                break;
                        }
                        else
                            user.signUp();
                    }
                }
            }catch(IOException io){
                io.printStackTrace();
            }
        }

        private User getUser(String[] strs) {
            if(strs[0].equals("1"))
                return new Admin(strs[2], strs[3]);
            else
                return new NormalUser(strs[2], strs[3]);
        }
    }
}
