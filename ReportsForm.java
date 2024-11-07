import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ReportsForm extends JFrame{
    private JButton btnBack;
    private JButton btnViewCus;
    private JButton btnBestInCus;
    private JButton btnAllCus;
    private JButton btnCatByQty;
    private JButton btnCatByAmount;
    private JButton btnOrderByAmount;
    private JButton btnAllOrders;

    private OrdersCollection ordersCollection;

    ReportsForm(OrdersCollection ordersCollection){
        this.ordersCollection = ordersCollection;

        setSize(650,280);
        setTitle("View Reports");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Back button
        btnBack = new JButton("Back");
        btnBack.setBounds(10, 10, 80, 30);
        btnBack.setBackground(new Color(240, 128, 128)); // Light red background
        btnBack.setForeground(Color.WHITE); // White text
        btnBack.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				//Back to homepage
				dispose();
				new HomePageForm(ordersCollection).setVisible(true); 
			}
		});
        add(btnBack);

        btnViewCus = new JButton("View Customers");
        btnViewCus.setBounds(25, 80, 170, 30);
        btnViewCus.setBackground(new Color(0,204,51));
        btnViewCus.setForeground(Color.WHITE);
        btnViewCus.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnViewCus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                dispose();
                new ViewCustomersForm(ordersCollection).setVisible(true);
            }
        });
        add(btnViewCus);

        btnBestInCus = new JButton("Best In Customers");
        btnBestInCus.setBounds(25, 130, 170, 30);
        btnBestInCus.setBackground(new Color(0,204,51));
        btnBestInCus.setForeground(Color.WHITE);
        btnBestInCus.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnBestInCus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                dispose();
                new BestInCusForm(ordersCollection).setVisible(true);
            }
        });
        add(btnBestInCus);

        btnAllCus = new JButton("All Customers");
        btnAllCus.setBounds(25, 180, 170, 30);
        btnAllCus.setBackground(new Color(0,204,51));
        btnAllCus.setForeground(Color.WHITE);
        btnAllCus.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnAllCus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                dispose();
                new AllCustomersForm(ordersCollection).setVisible(true);
            }
        });
        add(btnAllCus);

        btnCatByQty = new JButton("Categorized By QTY");
        btnCatByQty.setBounds(220, 100, 200, 30);
        btnCatByQty.setBackground(Color.BLUE);
        btnCatByQty.setForeground(Color.WHITE);
        btnCatByQty.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnCatByQty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                dispose();
                new CatByQtyForm(ordersCollection).setVisible(true);
            }
        });
        add(btnCatByQty);

        btnCatByAmount = new JButton("Categorized By Amount");
        btnCatByAmount.setBounds(220, 160, 200, 30);
        btnCatByAmount.setBackground(Color.BLUE);
        btnCatByAmount.setForeground(Color.WHITE);
        btnCatByAmount.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnCatByAmount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                dispose();
                new CatByAmountForm(ordersCollection).setVisible(true);
            }
        });
        add(btnCatByAmount);

        btnOrderByAmount = new JButton("Orders By Amount");
        btnOrderByAmount.setBounds(440, 100, 170, 30);
        btnOrderByAmount.setBackground(Color.GRAY);
        btnOrderByAmount.setForeground(Color.WHITE);
        btnOrderByAmount.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnOrderByAmount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                dispose();
                new OByAmountForm(ordersCollection).setVisible(true);
            }
        });
        add(btnOrderByAmount);

        btnAllOrders = new JButton("All Orders");
        btnAllOrders.setBounds(440, 160, 170, 30);
        btnAllOrders.setBackground(Color.GRAY);
        btnAllOrders.setForeground(Color.WHITE);
        btnAllOrders.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnAllOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                dispose();
                new AllOrdersForm(ordersCollection).setVisible(true);
            }
        });
        add(btnAllOrders);
    }
}
