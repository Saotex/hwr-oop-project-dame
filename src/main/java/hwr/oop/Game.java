package hwr.oop;

import java.util.Scanner;

public class Game {
    Field field;
    boolean isWhite = true;

    Game(String game){
        if(game.equals("German")){
            field = new Field("German");
        }
        spielfeld();
    }
/*
    void gameLife(){
        while(!isGameWon()) {
            amZug();
            String[] positionen = getPositionFromPlayer();
            move(Integer.parseInt(positionen[0]),Integer.parseInt(positionen[1]),Integer.parseInt(positionen[2]),Integer.parseInt(positionen[3]));
            spielfeld();
        }
    }  ist im manuellen Test */

    String[] getPositionFromPlayer() {
        Scanner scan = new Scanner(System.in);
        String positionen = scan.next();
        return positionen.split(",");
    }

    void spielfeld() {
        for (int i = 7; i >= 0; i--) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                System.out.print(field.getPositionList()[i][j].getState()+"  ");
            }
        }
    }

    boolean isGameWon() {
        boolean wonBlack = false;
        boolean wonWhite = false;
        for (int i = 0; i < field.getPositionList().length; i++) {
            for (int j = 0; j < field.getPositionList().length; j++) {
                if(field.getPositionList()[j][i].getState() == 1){
                    wonWhite = true;
                } else if(field.getPositionList()[j][i].getState() == 2){
                    wonBlack = true;
                }
            }
            if (wonBlack && wonWhite){
                return false;
            }
        }
        return false;
    }

    void amZug() {
        if(isWhite){
            System.out.println("Weiß ist am Zug!");
        } else {
            System.out.println("Schwarz ist am Zug!");
        }
    }

    public void move(int oldX, int oldY, int newX, int newY) {
        Figure oldPosition = field.getPositionList()[oldY][oldX];
        Figure newPosition = field.getPositionList()[newY][newX];
        if(newPosition.getState() == 0) {                               //?neues Feld leer
            if (
                    ((oldPosition.getState() == 1) && isWhite) ||
                            (oldPosition.getState() == 2) && !isWhite
            ) {                                                                                 //?richtiger Spieler am Zug
                if (!oldPosition.isDame()){
                    if (
                            (isWhite && newY > oldY) &&
                                    (newY - oldY == 1 && Math.abs(newX - oldX) == 1)
                    ) {                                                                             //?gültiger Zug Weiß
                        oldPosition.setState(0);
                        newPosition.setState(1);
                        isWhite = !isWhite;
                    }else if (                                                                      //?gültiger Zug Schwarz
                            (!isWhite && newY < oldY) &&
                                    (oldY - newY == 1 && Math.abs(newX - oldX) == 1)) {
                        oldPosition.setState(0);
                        newPosition.setState(2);
                        isWhite = !isWhite;

                    }else if (                                                                      //?gültiger Zug Weiß Schlagen
                            (isWhite && newY > oldY) &&
                                    (newY - oldY == 2 && Math.abs(newX - oldX) == 2)
                    ){
                        oldPosition.setState(0);
                        newPosition.setState(1);
                        if (newX - oldX == -2){
                            field.getPositionList()[newY-1][oldX-1].setState(0);
                        }else {
                            field.getPositionList()[newY-1][oldX+1].setState(0);
                        }
                        isWhite = !isWhite;
                    }else if (                                                                         //?gültiger Zug Schwarz Schlagen
                            (!isWhite && newY < oldY) &&
                                    (oldY - newY == 2 && Math.abs(newX - oldX) == 2)
                    ){
                        oldPosition.setState(0);
                        newPosition.setState(2);
                        if (newX - oldX == -2){
                            field.getPositionList()[newY+1][oldX-1].setState(0);
                        }else {
                            field.getPositionList()[newY+1][oldX+1].setState(0);
                        }
                        isWhite = !isWhite;
                    }if (newPosition.getState()==1 && newY == 7) {  //wird Weiß Dame
                        newPosition.setDame();
                    } else if (newPosition.getState()==2 && newY == 0) {  //wird Schwarz Dame
                        newPosition.setDame();
                    }
                }else {                 //Damen-Logik
                    if (Math.abs(newX-oldX) == 1 && Math.abs(newY-oldY) == 1){              //gültiger Zug
                        newPosition.setState(oldPosition.getState());
                        oldPosition.setState(0);
                    } else if ((Math.abs(newX-oldX) == 2 && Math.abs(newY-oldY) == 2)) // gültiger Zug schlagen
                    {
                        if (oldY<newY && oldX>newX && !(field.getPositionList()[oldY+1][oldX-1].getState() == oldPosition.getState()) && field.getPositionList()[oldY+1][oldX-1].getState() != 0){ //Gegner links-oben
                            newPosition.setState(oldPosition.getState());
                            oldPosition.setState(0);
                            field.getPositionList()[oldY+1][oldX-1].setState(0);
                        } else if (oldY>newY && oldX>newX && !(field.getPositionList()[oldY-1][oldX-1].getState() == oldPosition.getState()) && field.getPositionList()[oldY-1][oldX-1].getState() != 0) { //Gegner links-unten
                            newPosition.setState(oldPosition.getState());
                            oldPosition.setState(0);
                            field.getPositionList()[oldY-1][oldX-1].setState(0);
                        } else if (oldY<newY && oldX<newX && !(field.getPositionList()[oldY+1][oldX+1].getState() == oldPosition.getState()) && field.getPositionList()[oldY+1][oldX+1].getState() != 0) { //Gegner rechts-oben
                            newPosition.setState(oldPosition.getState());
                            oldPosition.setState(0);
                            field.getPositionList()[oldY+1][oldX+1].setState(0);
                        } else if (oldY>newY && oldX<newX && !(field.getPositionList()[oldY-1][oldX+1].getState() == oldPosition.getState()) && field.getPositionList()[oldY-1][oldX+1].getState() != 0) { //Gegner rechts-unten
                            newPosition.setState(oldPosition.getState());
                            oldPosition.setState(0);
                            field.getPositionList()[oldY-1][oldX+1].setState(0);
                        } else {
                            System.out.println("Kein gegner zu schlagen");
                        }
                    } else {
                        System.out.println("Ungültiger Zug!");
                    }
                }

            }else {
                System.out.println("Falscher Spieler:");
                amZug();
            }
        }else {
            System.out.println("Ungültiger Zug, das neue Feld muss frei sein!");
        }
    }
}
