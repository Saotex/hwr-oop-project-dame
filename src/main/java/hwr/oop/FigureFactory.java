package hwr.oop;

public interface FigureFactory {

    static Figure createFigure(boolean isBlack, int x, String y) {
        return new Figure(isBlack, x, y);
    }


    boolean isFigureColorBlack();

    String getPosition();

    void setPos(String newPos);
}
