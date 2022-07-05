package hwr.oop;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Game {

    List spielfeld;
    Game(String game){
        if(game.equals("German")){
            Field field = new Field("German");
            spielfeld = field.getList();
        }
    }
    public FigureFactory getValueAt(String xy) {
        int x = 0;
        for (int i = 0; i < 24; i++) {
            FigureFactory figure = (FigureFactory) spielfeld.get(x);
            if(figure.getPosition().equals(xy)){
                return figure;
            }
            x += 1;
        }
        return null;
    }

    public void move(String oldPos, String newPos) {
        FigureFactory figure = getValueAt(oldPos);
        figure.setPos(newPos);
    }
}
