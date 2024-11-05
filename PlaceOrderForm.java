import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PlaceOrderForm extends JFrame{
    // private JLabel lblPlaceORder;

    private JLabel lblOrderId;
    private JLabel lblOrderIdValue;
    private JLabel lblCustomerId;
    private JLabel lblSize;
    private JLabel lblSizeHint;
    private JLabel lblQty;
    private JLabel lblAmount;
    private JLabel txtAmount;

    // private JTextField txtOrderId;
    private JTextField txtCustomerId;
    private JTextField txtSize;
    private JTextField txtQty;    

    private JButton btnBack;
    private JButton btnPlaceOrder;

    private boolean isTpNumber;
    private boolean isSize;
    private boolean isQty;
	private double amount;

    // private String orderId;

    private OrdersCollection ordersCollection;
    
    // Default Construcotr
    PlaceOrderForm(OrdersCollection ordersCollection){
        this.ordersCollection=ordersCollection;
        
        setSize(400,400);
        setTitle("Place Order");
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

        // Order ID label
        lblOrderId = new JLabel("Order ID :");
        lblOrderId.setBounds(50, 60, 100, 30);
        lblOrderId.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblOrderId);

        // Order ID value label
        lblOrderIdValue = new JLabel();
        
        //set the generating order id
        lblOrderIdValue.setText(ordersCollection.generateOrderID());
        lblOrderIdValue.setBounds(150, 60, 200, 30);
        lblOrderIdValue.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblOrderIdValue);

        // Customer ID label 
        lblCustomerId = new JLabel("Customer ID :");
        lblCustomerId.setBounds(50, 100, 100, 30);
        lblCustomerId.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblCustomerId);

        //Customer ID text field
        txtCustomerId = new JTextField();
        txtCustomerId.setBounds(150, 100, 150, 30);       
        // Customer ID Validation
        txtCustomerId.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){  
                //retun the user input phone number to validation method
                isTpNumber = ordersCollection.getPhoneNumber(txtCustomerId.getText());                 
                if(!isTpNumber){
                    JOptionPane.showMessageDialog(null,"Invalid Phone Number");
                }                
            }
        });
        add(txtCustomerId);

        // Size label 
        lblSize = new JLabel("Size :");
        lblSize.setBounds(50, 140, 100, 30);
        lblSize.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblSize);

        //Size text field
        txtSize = new JTextField();
        txtSize.setBounds(150, 140, 150, 30);

        // Size Validation        
        txtSize.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                // reutn the user input size into validation method
                isSize = ordersCollection.getSize(txtSize.getText());
                if(!isSize){
                    JOptionPane.showMessageDialog(null,"Invalid Size");
                }
            }
        });
        add(txtSize);

        // Size hint label
        lblSizeHint = new JLabel("(XS/S/M/L/XL/XXL)");
        lblSizeHint.setBounds(300, 140, 100, 30);
        lblSizeHint.setFont(new Font("SansSerif", Font.BOLD, 9));
        add(lblSizeHint);

        // Quantity label 
        lblQty = new JLabel("QTY :");
        lblQty.setBounds(50, 180, 100, 30);
        lblQty.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblQty);

        // Quantity text field
        txtQty = new JTextField();
        txtQty.setBounds(150, 180, 150, 30);

        txtAmount = new JLabel("0.00");
        txtAmount.setBounds(150, 220, 150, 30);
        add(txtAmount);
        
        // Quantity Validation
        txtQty.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                isQty = ordersCollection.getQuantity(txtQty.getText());
                if(!isQty){
                    JOptionPane.showMessageDialog(null,"Quantity is Not Valid");
                }else{
					amount = ordersCollection.getAmount(txtQty.getText(),txtSize.getText());
                    txtAmount.setText(String.valueOf(amount));
				}
            }
        });
        add(txtQty);

        // Amount label and text field
        lblAmount = new JLabel("Amount :");
        lblAmount.setBounds(50, 220, 100, 30);
        lblAmount.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(lblAmount);


        // Place button
        btnPlaceOrder = new JButton("Place");
        btnPlaceOrder.setBounds(250, 280, 80, 40);
        btnPlaceOrder.setBackground(new Color(0, 150, 136)); // Teal color
        btnPlaceOrder.setForeground(Color.WHITE); // White text
        btnPlaceOrder.setFont(new Font("SansSerif", Font.BOLD, 14));

        //Place Order Action
        btnPlaceOrder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                double amount = ordersCollection.getAmount(txtQty.getText(),txtSize.getText());
                txtAmount.setText(String.valueOf(amount));
                
                //if((isTpNumber) && (isSize) && (isQty)){
                    String orderId = lblOrderIdValue.getText();
                    String phoneNumber = txtCustomerId.getText();
                    String size = txtSize.getText();
                    int qty = Integer.parseInt(txtQty.getText());                    
                    String orderStatus="Processing";                    

                    Order order = new Order(orderId,phoneNumber,size,qty,amount,orderStatus);
                    ordersCollection.addOrder(order); 
                    
                    JOptionPane.showMessageDialog(null,"Order Place Succesfull");

                    dispose();
                    new PlaceOrderForm(ordersCollection).setVisible(true);
                //}else{
                   // JOptionPane.showMessageDialog(null,"Order Place UnSuccessful");
                //}
            }
        });        
        add(btnPlaceOrder);
    }
}
