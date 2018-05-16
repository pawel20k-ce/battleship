import model.*;
import user.ConsoleUI;
import user.JavaConsoleDelegate;
import validaton.AndRuleValidator;

public class TestMain {
    public static void main(String[] args) {
        JavaConsoleDelegate consoleDelegate = new JavaConsoleDelegate();
        ConsoleUI ui = new ConsoleUI(consoleDelegate);
        GameBoard gameBoard = new GameBoard(
                PlayersBoard.fresh().fresh(),
                PlayersBoard.fresh(),
                new AndRuleValidator());

        //human player

        Ship humanShip1 = new Ship(
                ShipType.DESTROYER,
                Orientation.HORIZONTAL,
                new Point(1,1));

        Ship humanShip2 = new Ship(
                ShipType.BATTLESHIP,
                Orientation.HORIZONTAL,
                new Point(4,5));
        gameBoard.addHumanShip(humanShip1);
        gameBoard.addHumanShip(humanShip2);
        gameBoard.shotHumanBoard(new Point(1,1));
        gameBoard.shotHumanBoard(new Point(8,7));
        //Computer player
        Ship computerShip1 = new Ship(
                ShipType.BATTLESHIP,
                Orientation.HORIZONTAL,
                new Point(1, 1));

        Ship computerShip2 = new Ship(
                ShipType.DESTROYER,
                Orientation.VERTICAL,
                new Point(5, 5));
        gameBoard.addComputerShip(computerShip1);
        gameBoard.addComputerShip(computerShip2);
        gameBoard.shotComputerBoard(new Point(1,1));
        gameBoard.shotComputerBoard(new Point(8,7));

        ui.update(gameBoard);
        ui.printMaps();

    }
}
