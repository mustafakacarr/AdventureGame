public class Armor {
    private int id;
    private String name;
    private int block;
    private int price;

    public Armor(int id, String name,int block,int price){
       this.setId(id);
       this.setName(name);
       this.setBlock(block);
       this.setPrice(price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
