package validaton;

import model.PlayersBoard;
import model.Ship;

public interface Validator {

    boolean isValid(Ship ship, PlayersBoard board);



}
