public class FashionShop {
    public static void main(String[] args) {
        List ordersCollection = new List(100, 0.5);
        new HomePageForm(ordersCollection).setVisible(true);
    }
}
