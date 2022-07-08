package hwr.oop;
class Figure {

    private int state;
    // 0=empty; 1=white; 2=black
    private boolean isDame;

    public Figure(int state, boolean dame) {
        this.state = state;
        this.isDame = dame;
    }

    public int getState() {
        return state;
    }
    public boolean isDame() {
        return isDame;
    }
    public void setState(int state) {
        this.state = state;
    }

    public void setDame() {
        isDame = true;
    }
}
