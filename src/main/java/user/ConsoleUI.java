package user;

import model.*;

import java.util.function.Function;

public class ConsoleUI implements UserInterface, GameBoardObserver{

    private JavaConsoleDelegate console;
    private GameBoard board;
    public ConsoleUI(JavaConsoleDelegate console) {
        this.console=console;
    }


    @Override
    public void update(GameBoard gb) {
        this.board = gb;
    }

    @Override
    public void printMaps() {
        console.printToConsole("     YOU         OPPONENT");
        console.printToConsole("");
        console.printToConsole("  | A B C D E F G H I J |   | A B C D E F G H I J |");
        for (int y = 0; y < 10; y++) {
            String humanLine = createHumanPlayerLine(y);
            String otherLine = createComputerPlayerLine(y);
            console.printToConsole(humanLine + " " + otherLine);
        }
        console.printToConsole("  +---------------------+   +---------------------+");
    }

    private String createHumanPlayerLine(int y) {
        return createLineForSource(y, board::getHumanBoardElement);
    }

    private String createComputerPlayerLine(int y) {
        return createLineForSource(y, board::getComputerBoardElement).replace("O", " ");
    }

    private String createLineForSource(int y, Function<Point, BoardField> loadBoardFieldFunction) {
        StringBuilder builder = new StringBuilder();
        int lineNumber = y + 1;
        if (lineNumber < 10) {
            builder.append(" ");
        }
        builder.append(lineNumber).append("|");
        for (int x = 0; x < 10; x++) {
            Point address = new Point(x, y);
            BoardField mapElement = loadBoardFieldFunction.apply(address);
            builder.append(" ").append(decodeElement(mapElement));
        }
        return builder.append(" |").toString();
    }

    private String decodeElement(BoardField mapElement) {
        switch (mapElement) {
            case SHIP:
                return "O";
            case SHIP_HIT:
                return "X";
            case MISS:
                return "*";
            default:
                return " ";
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
