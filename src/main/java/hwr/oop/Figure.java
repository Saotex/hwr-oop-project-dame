package hwr.oop;
class Figure implements FigureFactory {

    private final boolean isBlack;

    Figure(boolean isBlack){
        this.isBlack = isBlack;
    }
    @Override
    public boolean figureColorIsBlack() {
        return isBlack;
    }
}
