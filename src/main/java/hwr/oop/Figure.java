package hwr.oop;
class Figure implements FigureFactory {

    private final boolean isBlack;
    private String position;

    public Figure(boolean isBlack, int x, String y) {
        this.isBlack = isBlack;
        String zahl = Integer.toString(x);
        position = zahl+y;
    }

    @Override
    public boolean isFigureColorBlack() {
        return isBlack;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setPos(String newPos) {
        position = newPos;
    }
}
