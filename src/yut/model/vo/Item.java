package yut.model.vo;

public class Item {
    // 아이템은 맵상에 올라갈 템, 그리고 바로 사용될 일회성 스킬 둘로 나눠진다.
    // 올라갈 템: 송편, 벽, 순간이동, 지뢰
    // 일회성 스킬:

    // 템 가격. 송편인 경우 얻는 양
    private int price;
    // 템이름
    private String name;


    public Item() {
    }

    public Item(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param player
     * @param itemNum
     * @return
     */
    public boolean buy(Player player, int itemNum){
        if (player.getSongP() >= price){
            player.setSongP(player.getSongP() - price);
            // 구매까진 완료, 이제 생성.
            // 생성을 ???????????????????????????????
            // TODO: 2019-11-12 이 메소드로 새 아이템 생성은 곤란한걸로 판단. 별도 방법 강구요망.
            return true;
        }
        return false;
    };


}
