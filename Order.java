class Order {
    private String orderId;
    private String size;
    private int quantity;
    private double amount;
    private String customerID;
    private String status;

	public Order(){}

    public Order(String orderId, String customerID, String size, int quantity, double amount, String status) {
        this.orderId = orderId;
        this.customerID = customerID;
        this.size = size;
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
    }

	// Getters
    public String getOrderId() {
        return orderId;
    }
    
    public String getCustomerID() {
        return customerID;
    }

    public String getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setcustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    // View Customer 
	public void setViewCustomer(String customerID,int quantity,double amount){
		this.customerID=customerID;
		this.quantity=quantity;
		this.amount=amount;
	}
}

