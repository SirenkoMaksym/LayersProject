/*
 * created by max$
 */


import repository.UserRepository;
import service.UserService;
import view.Menu;

public class TestApp {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        UserService service = new UserService(repository);

        Menu menu = new Menu(service);

        menu.run();
    }
}
