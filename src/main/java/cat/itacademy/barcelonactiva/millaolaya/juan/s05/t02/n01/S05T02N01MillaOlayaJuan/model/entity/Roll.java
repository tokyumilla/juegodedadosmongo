package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity;





public class Roll {





    private Integer firstRoll;

    private Integer secondRoll;

    private boolean win;



    public Roll(){}

    public Roll(Integer firstRoll, Integer secondRoll, boolean win) {

        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;

        this.win = win;
    }



    public Integer getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(Integer firstRoll) {
        this.firstRoll = firstRoll;
    }

    public Integer getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(Integer secondRoll) {
        this.secondRoll = secondRoll;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }





    @Override
    public String toString() {
        return "Roll{" +
                ", firstRoll=" + firstRoll +
                ", secondRoll=" + secondRoll +
                '}';
    }
}
