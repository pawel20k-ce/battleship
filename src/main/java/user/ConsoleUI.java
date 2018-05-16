package user;

import model.*;

public class ConsoleUI implements UserInterface, GameBoardObserver{

    private JavaConsoleDelegate console;

    public ConsoleUI(JavaConsoleDelegate console) {
        this.console=console;
    }


    @Override
    public void update(GameBoard gb) {

    }

    @Override
    public void printMaps() {
        System.out.print(" ");
        for (char i = 65; i < 75; i++) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 1; i < 11; i++) {
            System.out.println(i);

        }

    }

    @Override
    public void notifyUser(String msg) {

    }

    @Override
    public Point askUserForShot() {
        return null;
    }

    @Override
    public Ship askUserForShip(ShipType type) {
        return null;
    }
}
