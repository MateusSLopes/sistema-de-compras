package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    private Product item;
    public OrderItem(){
    }

    public OrderItem(Integer quantity, Product item) {
        this.quantity = quantity;
        this.price = item.getPrice();
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public double subTotal(){
        return quantity*price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(item.getName() + ", $");
        sb.append(item.getPrice() + ", Quantity: ");
        sb.append(quantity+", Subtotal: $" + String.format("%.2f",subTotal()));
        return sb.toString();
    }
}
