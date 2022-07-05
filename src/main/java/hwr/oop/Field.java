package hwr.oop;


public class Field {
    List spielfeld;

    public Field(String language) {
        boolean equalsResult = language.equals("German");
        if (equalsResult) {
            spielfeld = new Figure[8][8];

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (i % 2 == 1 && j % 2 == 1 && i <= 2) {
                        spielfeld[i][j] = new Figure(1, j, i, false);
                    } else if (i % 2 == 0 && j % 2 == 0 && i <= 2) {
                        spielfeld[i][j] = new Figure(1, j, i, false);
                    } else if (i % 2 == 1 && j % 2 == 1 && i >= 5) {
                        spielfeld[i][j] = new Figure(2, j, i, false);
                    } else if (i % 2 == 0 && j % 2 == 0 && i >= 5) {
                        spielfeld[i][j] = new Figure(2, j, i, false);
                    } else {
                        spielfeld[i][j] = new Figure(0, j, i, false);
                    }
                }
            }

        }
    }
    public Figure[][] getPositionList() {
        return spielfeld;
    }
}