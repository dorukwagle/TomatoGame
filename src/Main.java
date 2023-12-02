import controllers.WindowController;
import views.GameView;
import views.LoginPage;
import views.MainWindow;

public class Main {
    public static void main(String[] args) {
        new WindowController();
    }
}

/**
 * CLIENT-SERVER ARCHITECTURE:-
 *
 * The game implements the client-server architecture to some extent.
 * All the in-game logics and business logics are coded in the Models of  game itself. However,
 * for fetching the game puzzle, the Models of the app interoperates with the remote server
 * via API.
 * Since most of the logics are written in the app itself and it relies with the remote server
 * just for fetching the puzzle image, it makes the app client-server based to some extent.
 *
 *
 * LOW-COUPLING HIGH COHESION:-
 * Since the application designed implementing the Model-View-Controller(MVC) architecture
 * pattern, and as a result, it is more modular and each modules are loosely coupled with the other.
 * Different classes with related functionality and logics are grouped together maintaining the better separation of concerns.
 * and hence exhibits high cohesion.
 *
 * The app is divided mainly into three modules and each modules are independent of each other i.e. loosely coupled
 * with each other.
 *
 * The Views handle the presentation logic, and all the classes related to presentation are places in the views.
 * View know nothing about the Controllers or the models. They just present the data that is sent by the Controllers.
 *
 * Controllers have the detailed knowledge of the implementation of the views or the internal workings of the Models.
 * They focus in handling the user input or interactions with the Views and cordinate with the flow of data from Models to
 * the Views.
 *
 * Models encapsulate the game's business logic and the data structures without being tightly coupled with the other modules.
 * Models just respond to the Controllers, perform a given task and return the result to the Controllers without worrying about
 * how the data is presented.
 *
 */