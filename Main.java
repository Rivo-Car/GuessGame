public class Main {
    public static void main(String[] args) {
        // initialization of MVC elements
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // GuessGame startUp
        controller.applicationBoot();
    }
}
