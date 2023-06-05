package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.dto;

public class RollDTO {
    private Integer firstRoll;
    private Integer secondRoll;

    private boolean win;

    public RollDTO(){}


    public RollDTO(Integer firstRoll, Integer secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        setWin();
    }

    public void setWin() {
        if (firstRoll+secondRoll==7) {
            this.win=true;
        } else {
            this.win=false;
        }
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

    @Override
    public String toString() {
        return "RollDTO{" +
                ", firstRoll=" + firstRoll +
                ", secondRoll=" + secondRoll +
//                ", player=" + player +
                ", win=" + win +
                '}';
    }
}
