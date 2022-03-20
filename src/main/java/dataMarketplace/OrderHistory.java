package dataMarketplace;

public class OrderHistory {
    private final String order_id;
    private final String description;

    public OrderHistory(String order_id, String description) {
        this.order_id = order_id;
        this.description = description;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getOrderDescription() {
        return description;
    }
}
