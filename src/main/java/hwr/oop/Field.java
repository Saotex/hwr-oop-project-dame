package hwr.oop;

import java.util.ArrayList;
import java.util.List;

public class Field {
    List spielfeld;

    public Field(String language) {
        boolean equalsResult = language.equals("German");
        if (equalsResult) {
            spielfeld = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                spielfeld.add(FigureFactory.createFigure(true));
            }
            for (int i = 0; i < 12; i++) {
                spielfeld.add(FigureFactory.createFigure(false));
            }
        }
    }
    public List getList() {
        return spielfeld;
    }
}

