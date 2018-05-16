package model;

public class Ship {

    private final ShipType typ;
    private final Orientation orientation;
    private final Point position;




    public Ship(ShipType typ, Orientation orientation, Point position) {
        this.typ = typ;
        this.orientation = orientation;
        this.position = position;
    }

    public ShipType getTyp() {
        return typ;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Point getPosition() {
        return position;
    }
    public Point getEndPosition() {
        Integer offset = typ.size().intValue() - 1;
        if (orientation == Orientation.HORIZONTAL) {
            return new Point(position.getX() + offset, position.getY());
        } else {
            return new Point(position.getX(), position.getY() + offset);
        }
    }

}
