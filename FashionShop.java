class FashionShop{
	public static void main(String args[]){
		OrdersCollection ordersCollection = new OrdersCollection();
		new HomePageForm(ordersCollection).setVisible(true);
	}
}
