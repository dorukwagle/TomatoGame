package controllers;

import views.LoginPage;
import views.MainWindow;

public class WindowController {
    private MainWindow window;

    public WindowController() {
        this.window = MainWindow.getInstance();

        window.setContent(new LoginPage());

    }


}
