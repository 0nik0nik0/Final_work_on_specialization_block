package Nursery;

import Nursery.controller.Controller;
import Nursery.view.View;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        View view = new View(controller);
        view.displayView();
    }
}
