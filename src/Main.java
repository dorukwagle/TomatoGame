import views.LoginPage;
import views.MainWindow;

public class Main {
    public static void main(String[] args) {
        var window = MainWindow.getInstance();
        window.setContent(new LoginPage());
    }
}