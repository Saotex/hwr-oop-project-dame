package hwr.oop;

import java.util.ArrayList;
import java.util.List;

public class Field {
    List spielfeld;

    public Field(String language) {
        boolean equalsResult = language.equals("German");
        if (equalsResult) {
            spielfeld = new ArrayList<>();
            int x = 1;
            for (int i = 0; i < 4; i++) {
                spielfeld.add(FigureFactory.createFigure(false,x,"A"));
                x += 2;
            }
            x = 2;
            for (int i = 0; i < 4; i++) {
                spielfeld.add(FigureFactory.createFigure(false,x,"B"));
                x += 2;
            }
            x = 1;
            for (int i = 0; i < 4; i++) {
                spielfeld.add(FigureFactory.createFigure(false,x,"C"));
                x += 2;
            }
            x = 1;
            for (int i = 0; i < 4; i++) {
                spielfeld.add(FigureFactory.createFigure(true,x,"H"));
                x += 2;
            }
            x = 2;
            for (int i = 0; i < 4; i++) {
                spielfeld.add(FigureFactory.createFigure(true,x,"G"));
                x += 2;
            }
            x = 1;
            for (int i = 0; i < 4; i++) {
                spielfeld.add(FigureFactory.createFigure(true,x,"F"));
                x += 2;
            }
        }
    }
    public List getList() {
        return spielfeld;
    }
}

