package hwr.oop;

public interface FigureFactory {
    static Figure createFigure(boolean isBlack){
        return new Figure(isBlack);
    }

    boolean figureColorIsBlack();
}
