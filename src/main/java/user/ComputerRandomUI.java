package user;

import model.*;

import java.util.*;

public class ComputerRandomUI implements UserInterface, GameBoardObserver {

    private Random generator;
    private List<Point> availableShots;


    public ComputerRandomUI() {
        generator = new Random();
        availableShots = new ArrayList<>();
        for (int y = 0; y < 10 ; y++) {
            for (int x = 0; x < 10 ; x++) {
                availableShots.add(new Point(x,y));

            }

        }
    }

    @Override
    public void update(GameBoard gb) {

    }

    @Override
    public void printMaps() {

    }

    @Override
    public void notifyUser(String msg) {

    }

    @Override
    public Point askUserForShot() {
        int shotPosition= generator.nextInt(availableShots.size());
        Point shot = availableShots.get(shotPosition);
        availableShots.remove(shotPosition);
        return shot;
    }

    @Override
    public Ship askUserForShip(ShipType type) {

        Point point = new Point(generator.nextInt(10), generator.nextInt(10));
        Orientation shiporientation = generator.nextBoolean()
                ? Orientation.HORIZONTAL
                : Orientation.VERTICAL;
        return new Ship(type, shiporientation, point);

    }
}
