import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @ClassName Internet
 * @Description TODO
 * @Author Peng Deng
 * @Date 2019/7/5 14:27
 * @Version 1.0
 **/
public class Internet extends Application {
    public static final String defaultURL = "http://mail.fudan.edu.cn";
    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        final WebEngine engine = webView.getEngine();
        engine.load(defaultURL);
        try{
            Scene scene = new Scene(webView);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
