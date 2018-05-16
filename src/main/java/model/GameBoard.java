package model;

import validaton.Validator;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
        private List<GameBoardObserver> observers;
    private PlayersBoard humanBoard;
    private PlayersBoard computerBoard;
    private Validator validator;


    public GameBoard(PlayersBoard humanBoard, PlayersBoard computerBoard, Validator validator) {
        this.validator = validator;
        observers=new ArrayList<>();
        this.humanBoard = humanBoard;
        this.computerBoard = computerBoard;


    }

    private void updateObservers() {
        observers.forEach(observer ->observer.update(this));
    }

    public BoardField shotComputerBoard(Point shootLocation) {
        BoardField shotFieldPreviousValue = getComputerBoardElement(shootLocation);
        if (shotFieldPreviousValue == BoardField.WATER)
            computerBoard=computerBoard.upDateSea(shootLocation, BoardField.MISS);
        if (shotFieldPreviousValue == BoardField.SHIP)
        computerBoard= computerBoard.upDateSea(shootLocation,BoardField.SHIP_HIT);
        updateObservers();
        return shotFieldPreviousValue;


    }

    public BoardField getComputerBoardElement(Point shootLocation) {
        return computerBoard.getSeaElement(shootLocation);

    }

 /*   public BoardField shotHumanBoard(Point shootLocation){
    BoardField shotFieldPreviousValue = getHumanBoardElement(shootLocation);

        if (shotFieldPreviousValue== BoardField.SHIP){
            humanBoard = humanBoard.upDateSea(shootLocation,BoardField.SHIP_HIT);
        }else
            if (shotFieldPreviousValue==BoardField.WATER)
        humanBoard = humanBoard.upDateSea(shootLocation,BoardField.MISS);
        return shotFieldPreviousValue;
    } */
 public BoardField shotHumanBoard(Point shootLocation) {
     BoardField shotFieldPreviousValue = getHumanBoardElement(shootLocation);
     switch (shotFieldPreviousValue) {
         case WATER:
             humanBoard = humanBoard.upDateSea(shootLocation, BoardField.MISS);
             break;
         case SHIP:
             humanBoard = humanBoard.upDateSea(shootLocation, BoardField.SHIP_HIT);
             break;
     }
     updateObservers();
     return shotFieldPreviousValue;

 }


    public BoardField getHumanBoardElement(Point shootLocation) {
        return humanBoard.getSeaElement(shootLocation);
    }

    public boolean addHumanShip(Ship ship) {
     if (validator.isValid(ship,humanBoard)) {
         humanBoard = humanBoard.addShip(ship);
         updateObservers();
         return true;
     }
     return false;
    }



    public boolean addComputerShip(Ship ship) {
     if(validator.isValid(ship,computerBoard)) {
         computerBoard = computerBoard.addShip(ship);
         updateObservers();
         return true;
     }
     return false;
        //  for (GameBoardObserver observer : observers) {
     //       observer.update(this);
     //  }
    }

    public void register(GameBoardObserver observer) {
     observers.add(observer);

    }

    public void unregister(GameBoardObserver observer) {
     observers.remove(observer);
    }
}