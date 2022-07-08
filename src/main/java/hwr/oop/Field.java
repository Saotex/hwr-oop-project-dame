package hwr.oop;


public class Field {
    Figure[][] spielfeld;

    public void setFigure(Figure oldFigure, int newX, int newY, Figure newFigure, int oldX, int oldY) {
        this.spielfeld[oldY][oldX] = newFigure;
        this.spielfeld[newY][newX] = oldFigure;
    }

    public Field() {
            spielfeld = new Figure[8][8];

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (i % 2 == 1 && j % 2 == 1 && i <= 2) {
                        spielfeld[i][j] = new Figure(1, false);
                    } else if (i % 2 == 0 && j % 2 == 0 && i <= 2) {
                        spielfeld[i][j] = new Figure(1, false);
                    } else if (i % 2 == 1 && j % 2 == 1 && i >= 5) {
                        spielfeld[i][j] = new Figure(2, false);
                    } else if (i % 2 == 0 && j % 2 == 0 && i >= 5) {
                        spielfeld[i][j] = new Figure(2, false);
                    } else {
                        spielfeld[i][j] = new Figure(0, false);
                    }
                }
            }


    }
    public Figure[][] getPositionList() {
        return spielfeld;
    }
}