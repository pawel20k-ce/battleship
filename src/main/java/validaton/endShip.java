package validaton;

import model.*;

public class endShip implements Validator {

    public boolean isValid(Ship ship, PlayersBoard playersBoard) {
                  if (ship.getOrientation() == Orientation.HORIZONTAL) {
            Long x = ship.getPosition().getX() + ship.getTyp().size()-1;
            if (x > 0 || x < 10) return true;
                return false;

        } else
             {
                Long x = ship.getPosition().getY() + ship.getTyp().size() - 1;
                if (x > 0 || x < 10) return true;
                return false;


            }


    }
}