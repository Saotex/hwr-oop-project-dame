package hwr.oop;
class Figure {

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

    public String getPosition() {
        return position;
    }

    public void setState(int state) {
        this.state = state;
    }
}
