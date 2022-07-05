package hwr.oop;

public class Game {
    Field field;
    boolean isWhite = true;

    Game(String game){
        if(game.equals("German")){
            field = new Field("German");
        }
    }

    void gameLife(){
        spielfeld();
        isGameWon();
        amZug();
        //move();
    }

    void spielfeld() {
        for (int i = 7; i >= 0; i--) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                System.out.print(field.getPositionList()[i][j].getState()+"  ");
            }
        }
    }

    private void isGameWon() {

    }

    private void amZug() {
        if(!isWhite){
            System.out.println("Schwarz ist am Zug!");
        } else {
            System.out.println("Weiß ist am Zug!");
        }
    }
   /* public FigureFactory getValueAt(String xy) {
        int x = 0;
        for (int i = 0; i < 24; i++) {
            FigureFactory figure = (FigureFactory) spielfeld.get(x);
            if(figure.getPosition().equals(xy)){
                return figure;
            }
            x += 1;
        }
        return null;
    }*/

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
                } else {
                    System.out.println("Falscher Zug");
                }
                if (
                        (!isWhite && newY < oldY) &&
                                (oldY - newY == 1 && Math.abs(newX - oldX) == 1)) {
                    field.getPositionList()[oldY][oldX].setState(0);
                    field.getPositionList()[newY][newX].setState(2);
                    isWhite = !isWhite;

                } else {
                    System.out.println("Falscher Zug");
                }
                /*if (
                        isWhite && newY > oldY &&
                ) {

                }*/
            }else {
                System.out.println("Falscher Zug");
            }
        }else {
            System.out.println("Falscher Zug");
        }
    }
}
