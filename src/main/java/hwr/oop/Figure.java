package hwr.oop;
class Figure {

    private int state;
    // 0=empty; 1=white; 2=black
    private int x;
    private int y;
    private boolean isDame;

    public Figure(int state, int x, int y, boolean dame) {
        this.state = state;
        this.x = x;
        this.y = y;
        this.isDame = dame;
    }

    public int getState() {
        return state;
    }
    public boolean isDame() {
        return isDame;
    }

    public String getPosition() {
        return (Integer.toString(x)+Integer.toString(y));
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setDame() {
        isDame = true;
    }
}
