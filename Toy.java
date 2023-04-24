package Classes;

public class Toy {

    public Toy(int id, String name, int quantity, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    private int id;
    private String name;
    private int quantity;
    private int weight;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void reduceQuantity() {
        setQuantity(getQuantity() - 1);
    }

    public void print() {
        System.out.println("ID: " + this.getId()
                + " Название: " + this.getName()
                + " Количество: " + this.getQuantity()
                + " Вес: " + this.getWeight());
    }

}
