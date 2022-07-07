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

        if(field.getPositionList()[newY][newX].getState() == 0) {
            if (
                    ((field.getPositionList()[oldY][oldX].getState() == 1) && isWhite) ||
                            (field.getPositionList()[oldY][oldX].getState() == 2) && !isWhite
            ) {
                if (
                        (isWhite && newY > oldY && field.getPositionList()[newY][newX].getState() == 0) &&
                                (newY - oldY == 1 && Math.abs(newX - oldX) == 1)
                ) {
                    field.getPositionList()[oldY][oldX].setState(0);
                    field.getPositionList()[newY][newX].setState(1);
                    isWhite = !isWhite;
                }else if (
                        (!isWhite && newY < oldY) &&
                                (oldY - newY == 1 && Math.abs(newX - oldX) == 1)) {
                    field.getPositionList()[oldY][oldX].setState(0);
                    field.getPositionList()[newY][newX].setState(2);
                    isWhite = !isWhite;

                }else if (
                        (isWhite && newY > oldY && field.getPositionList()[newY][newX].getState() == 0) &&
                (newY - oldY == 2 && Math.abs(newX - oldX) == 2)
                ){
                    field.getPositionList()[oldY][oldX].setState(0);
                    field.getPositionList()[newY][newX].setState(1);
                    if (newX - oldX == -2){
                        field.getPositionList()[newY-1][oldX-1].setState(0);
                    }else {
                        field.getPositionList()[newY-1][oldX+1].setState(0);
                    }
                    isWhite = !isWhite;
                }else if (
                        (!isWhite && newY < oldY && field.getPositionList()[newY][newX].getState() == 0) &&
                                (oldY - newY == 2 && Math.abs(newX - oldX) == 2)
                ){
                    field.getPositionList()[oldY][oldX].setState(0);
                    field.getPositionList()[newY][newX].setState(2);
                    if (newX - oldX == -2){
                        field.getPositionList()[newY+1][oldX-1].setState(0);
                    }else {
                        field.getPositionList()[newY+1][oldX+1].setState(0);
                    }
                    isWhite = !isWhite;
                }
            }else {
                amZug();
            }
        }else {
            System.out.println("Ungültiger Zug, das neue Feld muss frei sein!");
        }
    }
}
