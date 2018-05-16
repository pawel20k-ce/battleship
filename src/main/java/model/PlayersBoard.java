package model;

import java.util.ArrayList;
import java.util.List;

public class PlayersBoard {

    private BoardField[][] sea;
    private List<Ship> ships;


    private PlayersBoard(Builder builder) {

        this.sea = builder.seaToBeAdjusted;
        this.ships = builder.shipListToBeAdjusted;

    }


    public static PlayersBoard fresh() {


        BoardField[][] freashShips = new BoardField[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                freashShips[x][y] = BoardField.WATER;
            }
        }
        List<Ship> freashSea = new ArrayList<Ship>();
        return new Builder(freashShips, freashSea).build();
    }

    public List<Ship> getShips() {
        return ships;
    }

    public BoardField getSeaElement(Point point) {
        if (!isValid(point)) {
            return BoardField.NONE;
        } else {
            return sea[point.getX()][point.getY()];
        }
    }
    private boolean isValid(Point point) {
        return point != null
                && point.getX() >= 0 && point.getX() < 10
                && point.getY() >= 0 && point.getY() < 10;
    }


    public PlayersBoard upDateSea(Point point, BoardField newSeaValue) {
        return new Builder(sea, ships).seaElement(point, newSeaValue).build();

    }

    public PlayersBoard addShip(Ship ship) {
        return new Builder(sea,ships).ship(ship).build();
    }

    private static class Builder {


        private final BoardField[][] seaToBeAdjusted;
        private final List<Ship> shipListToBeAdjusted;

        Builder(BoardField[][] oryginalSea, List<Ship> orignalShips) {
            this.seaToBeAdjusted = new BoardField[10][10];
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    this.seaToBeAdjusted[x][y] = oryginalSea[x][y];
                }
                }
            this.shipListToBeAdjusted = new ArrayList<>(orignalShips);

        }

        private Builder seaElement(Point p, BoardField newSeaValue) {
            if (p == null || p.getX() < 0 || p.getX() >= 10 || p.getY()<0 || p.getY()>=10 ) {
                return this;
            }
                seaToBeAdjusted[p.getX()][p.getY()] = newSeaValue;

                return this;


        }
        public Builder ship(Ship ship){
            shipListToBeAdjusted.add(ship);
            for (int i = 0 ; i<ship.getTyp().size();i++){
             Integer x =   ship.getPosition().getX();
              Integer y =  ship.getPosition().getY();
              if (ship.getOrientation() == Orientation.HORIZONTAL){
                  x +=i;
              }else{
                  y+=i;
              }
                seaToBeAdjusted[x][y]= BoardField.SHIP;
            }
            return this;
        }

        private PlayersBoard build() {
            return new PlayersBoard(this);
        }

    }


}
