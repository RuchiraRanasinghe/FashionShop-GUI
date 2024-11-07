import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteOrderForm extends JFrame {
    private JButton btnBack;
    private JButton btnSearch;
    private JButton btnDelete;
	private JTextField txtOrderId;
	private JLabel lblOrderId;
	private JLabel lblCusId;
	private JLabel lblSize;
	private JLabel lblQty;
	private JLabel lblAmount;
	private JLabel lblStatus;
	private JLabel lblCusIdValue;
	private JLabel lblSizeValue;
	private JLabel lblQtyValue;
	private JLabel lblAmountValue;
	private JLabel lblStatusValue;

    private OrdersCollection ordersCollection;

    DeleteOrderForm(OrdersCollection ordersCollection){
        this.ordersCollection = ordersCollection;

        setSize(500,500);
		setTitle("Delete Form");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(0,0,80,30);
		btnBack.setBackground(new Color(240,128,128));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("SansSerif",1,14));
		btnBack.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent evt){
				dispose();
                new HomePageForm(ordersCollection).setVisible(true);
			}
		});
		add(btnBack);

		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(30,40,400,40);

		lblOrderId = new JLabel("Enter Order ID : ");
		lblOrderId.setFont(new Font("SansSerif",Font.BOLD,14));
        txtOrderId = new JTextField(15);
		txtOrderId.setPreferredSize(new Dimension(100,30));
        btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				Order order = ordersCollection.searchOrder(txtOrderId.getText());

				if (order!=null) {
					lblCusIdValue.setText(order.getCustomerID());
					lblSizeValue.setText(order.getSize());
					lblQtyValue.setText(""+order.getQuantity());
					lblAmountValue.setText(""+order.getAmount());
					lblStatusValue.setText(order.getStatus());
				}else{
					JOptionPane.showMessageDialog(null,"Order not found");
				}
			}
		});

		searchPanel.add(lblOrderId);
		searchPanel.add(txtOrderId);
		searchPanel.add(btnSearch);
		add(searchPanel);

		lblCusId = new JLabel("Customer ID : ");
		lblCusId.setBounds(30, 90, 150, 40);
		lblCusId.setFont(new Font("SansSerif",Font.BOLD,14));
		add(lblCusId);

		lblCusIdValue = new JLabel();
		lblCusIdValue.setBounds(200, 90, 150, 40);
		lblCusIdValue.setFont(new Font("SansSeerif",Font.BOLD,14));
		add(lblCusIdValue);
		
		lblSize = new JLabel("Size : ");
		lblSize.setBounds(30, 150, 150, 40);
		lblSize.setFont(new Font("SansSerif",Font.BOLD,14));
		add(lblSize);

		lblSizeValue = new JLabel();
		lblSizeValue.setBounds(200, 150, 150, 40);
		lblSizeValue.setFont(new Font("SansSeerif",Font.BOLD,14));
		add(lblSizeValue);

		lblQty = new JLabel("QTY : ");
		lblQty.setBounds(30, 210, 150, 40);
		lblQty.setFont(new Font("SansSerif",Font.BOLD,14));
		add(lblQty);

		lblQtyValue = new JLabel();
		lblQtyValue.setBounds(200, 210, 150, 40);
		lblQtyValue.setFont(new Font("SansSeerif",Font.BOLD,14));
		add(lblQtyValue);

		lblAmount = new JLabel("Amount : ");
		lblAmount.setBounds(30, 270, 150, 40);
		lblAmount.setFont(new Font("SansSerif",Font.BOLD,14));
		add(lblAmount);

		lblAmountValue = new JLabel();
		lblAmountValue.setBounds(200, 270, 150, 40);
		lblAmountValue.setFont(new Font("SansSeerif",Font.BOLD,14));
		add(lblAmountValue);
		
		lblStatus = new JLabel("Status : ");
		lblStatus.setBounds(30, 330, 150, 40);
		lblStatus.setFont(new Font("SansSerif",Font.BOLD,14));
		add(lblStatus);

		lblStatusValue = new JLabel();
		lblStatusValue.setBounds(200, 330, 150, 40);
		lblStatusValue.setFont(new Font("SansSeerif",Font.BOLD,14));
		add(lblStatusValue);

        btnDelete = new JButton("Delete Order");
        btnDelete.setBounds(320,400,150,30);
        btnDelete.setBackground(new Color(102,178,255));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                //Status Option
               ordersCollection.deleteConfimation(ordersCollection.searchOrder(txtOrderId.getText()));
            }
        });
        add(btnDelete);
    }
}
