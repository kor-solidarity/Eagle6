package yut.model.vo;

public class SongPyeon extends Item {
    private int amount;

    public SongPyeon(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
