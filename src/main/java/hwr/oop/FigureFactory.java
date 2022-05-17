package hwr.oop;

public interface FigureFactory {
    static BlackFigure createBlackFigure(){
        return new BlackFigure();
    }
    static WhiteFigure createWhiteFigure(){
        return  new WhiteFigure();
    }

}
