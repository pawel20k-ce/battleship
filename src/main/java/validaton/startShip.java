package validaton;

import model.BoardField;
import model.PlayersBoard;
import model.Ship;

public class startShip implements Validator{



    public boolean isValid(Ship ship, PlayersBoard playersBoard){
        BoardField seaElement = playersBoard.getSeaElement(ship.getPosition());

        if (seaElement == BoardField.WATER)

            return true; else
        return false;

    }


}
