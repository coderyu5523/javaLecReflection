import Controller.UserController;
import dao.UserDAO;

public class App {
    public static void main(String[] args) {

        String url = "/delete" ;

        UserDAO dao = new UserDAO();
        UserController con = new UserController(dao);
        Dispatcher dis = new Dispatcher(con);
        dis.route(url);

    }
}
