package styleomega.cb006456.styleomega.Model;

/**
 * Created by Nadeem on 8/30/2017.
 */

public class Product {
    private int id;
    private String type;
    private String pic;
    private String name;
    private String size;
    private int price;

    public Product(int id, String pic, String name, String size, int price, String type) {
        this.id = id;
        this.type = type;
        this.pic = pic;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
