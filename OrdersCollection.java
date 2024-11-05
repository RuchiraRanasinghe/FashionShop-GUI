class OrdersCollection{
	private Order[] orderArray;
	
	OrdersCollection(){
		orderArray  = new Order[0];
	}
	
	public int getOrderArraySize(){
		return orderArray.length;
	}
	
	// Order id generate
    public String generateOrderID() {
		if(getOrderArraySize()==0){
			return "ODR#00001";
		}else{
			int lastNumber=Integer.parseInt(orderArray[orderArray.length-1].getOrderId().substring(4));
			return String.format("ODR#%05d",lastNumber+1);
		}
	}

    // View Customers
    public Order[] viewCustomer(){
        Order[] viewCustomer = new Order[orderArray.length];
        boolean[] equalPass = new boolean [orderArray.length];
        int count=0;

        for(int i=0; i<orderArray.length; i++){
            if(equalPass[i]){
                continue;
            }

            viewCustomer[count]=new Order();

            int tempQty = orderArray[i].getQuantity();
            double tempAmount=orderArray[i].getAmount();
            equalPass[i]=true;

            for(int j=i+1; j<orderArray.length; j++){
                if(orderArray[i].getCustomerID().equals(orderArray[j].getCustomerID())){
                    tempQty+=orderArray[i].getQuantity();
                    tempAmount+=orderArray[i].getAmount();
                    equalPass[j]=true;
                }
            }

            String cusPhoneNumber = orderArray[i].getCustomerID();
            viewCustomer[count].setViewCustomer(cusPhoneNumber, tempQty, tempAmount);
            count++;
        }
        return viewCustomer;
    }

    public Order[] getOrderObject(){
		Order[] tempOrderArray=new Order[orderArray.length];
		for (int i = 0; i < orderArray.length; i++){
			tempOrderArray[i]=orderArray[i];
		}
		return tempOrderArray;
	}

    public Order searchOrder(String orderId){
        for(int i=0; i<orderArray.length; i++){
            if(orderArray[i].getOrderId().equalsIgnoreCase(orderId)){
                return orderArray[i];
            }
        }
        return null;
    }

    public Order[] searchCustomerID(String custId) {
        int count = 0;
        for (Order order : orderArray) {
            if (order.getCustomerID().equalsIgnoreCase(custId)) {
                count++;
            }
        }
        if (count == 0) {
            return new Order[0];
        }
        Order[] foundOrders = new Order[count];
        int index = 0;
        for (Order order : orderArray) {
            if (order.getCustomerID().equalsIgnoreCase(custId)) {
                foundOrders[index++] = order;
            }
        }
        return foundOrders;
    }

	// Phone Number Validation
	public boolean getPhoneNumber(String cusPhoneNumber) {
        if (cusPhoneNumber.length() != 10 || cusPhoneNumber.charAt(0) != '0') {
            return false;
        } else {
            return true;
        }
    }

	// Size Validation
	public boolean getSize(String tShirtSize) {
        tShirtSize = tShirtSize.toUpperCase();
        if (tShirtSize.equals("XS") || tShirtSize.equals("S") || tShirtSize.equals("M")
                || tShirtSize.equals("L") || tShirtSize.equals("XL")
                || tShirtSize.equals("XXL")) {
            return true;
        } else {
            return false;
        }

    }

	 // Quantiity Validation
	public boolean getQuantity(String qty){
		if (Integer.parseInt(qty) > 0) {
			return true;
		}else{
			return false;
		}
	}

	// Amount Calculation
    public double getAmount(String qty, String tShirtSize) {
        tShirtSize = tShirtSize.toUpperCase();

        double amount=0;
        int quantiity = Integer.parseInt(qty);
        switch (tShirtSize) {
            case "XS":
                amount = quantiity * 600;
                break;
            case "S":
                amount = quantiity * 800;
                break;
            case "M":
                amount = quantiity * 900;
                break;
            case "L":
                amount = quantiity * 1000;
                break;
            case "XL":
                amount = quantiity * 1100;
                break;
            case "XXL":
                amount = quantiity * 1200;
                break;
        }        
        return amount;
    }
	
	public boolean addOrder(Order order) {
        Order[] tempOrderArray = new Order[orderArray.length + 1];

        for (int i = 0; i < orderArray.length; i++) {
            tempOrderArray[i] = orderArray[i];
        }

        tempOrderArray[tempOrderArray.length-1] = order;
        orderArray = tempOrderArray;
        return true;
    }
}
