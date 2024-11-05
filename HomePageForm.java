import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class HomePageForm extends JFrame{
	private JLabel lblTitle;
	private JLabel copyrightLabel;
	private JLabel imageLabel;
	
	private JButton btnSearch;
	private JButton btnStatus;
	private JButton btnReports;
	private JButton btnDelete;
	private JButton btnPlaceOrder;
	
	private OrdersCollection ordersCollection;

	HomePageForm(OrdersCollection ordersCollection){
		this.ordersCollection = ordersCollection;
		
		setSize(600,600);
		setTitle("Fashion Shop");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		//------------Add Title Label-----------------
		lblTitle=new JLabel("Fashion Shop");
		lblTitle.setBounds(0, 0, 600, 50);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setOpaque(true);
		lblTitle.setBackground(new Color(33, 150, 243));
		lblTitle.setFont(new Font("SansSerif",1,50));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add(lblTitle);
		
		//------------Add Button----------------------
		JPanel buttonPanel = new JPanel(null);
		buttonPanel.setPreferredSize(new Dimension(500,400));
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(50, 100, 200, 40);
		btnSearch.setFont(new Font("",1,20));
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				searchOptionAlert();
				//dispose();
			}
		});
		buttonPanel.add(btnSearch);
		
		btnStatus = new JButton("Status");
		btnStatus.setBounds(50, 160, 200, 40);
		btnStatus.setFont(new Font("",1,20));
		btnStatus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				//Status Option
			}
		});
		buttonPanel.add(btnStatus);
		
		btnReports = new JButton("Reports");
		btnReports.setBounds(50, 220, 200, 40);
		btnReports.setFont(new Font("",1,20));
		btnReports.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				//Reports Action
			}
		});
		buttonPanel.add(btnReports);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(50,280,200,40);
		btnDelete.setFont(new Font("",1,20));
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				//Delete Action
			}
		});
		buttonPanel.add(btnDelete);
		
		btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBounds(50, 360, 200, 50);
		btnPlaceOrder.setBackground(new Color(0, 200, 200));
		btnPlaceOrder.setFont(new Font("",1,20));
		btnPlaceOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				new PlaceOrderForm(ordersCollection).setVisible(true);
			}
		});
		buttonPanel.add(btnPlaceOrder);

		// Image label
        ImageIcon fashionImage = new ImageIcon("E:\\ICET\\FashionShop - GUI\\Images\\fashionShop1.png"); // Replace with your image path
        imageLabel = new JLabel(fashionImage);
        imageLabel.setBounds(320, 100, 200, 350); // Position image on the right
        buttonPanel.add(imageLabel);

		add(buttonPanel,BorderLayout.CENTER);
		
		// Copyright label
        copyrightLabel = new JLabel("Copyrights @ Ruchira 2024", SwingConstants.CENTER);
        copyrightLabel.setBounds(0, 440, 500, 30);
        copyrightLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        add(copyrightLabel,BorderLayout.SOUTH);

        // Display the frame
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);

	}
	public void searchOptionAlert(){
		Object[] options = {"Search Customer", "Search Order", "Cancel"};
        
        // Show the option dialog
        int choice = JOptionPane.showOptionDialog(null,
                "Please select the option", // Message
                "Search Options", // Title
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]); // Default option is "Cancel"

        // Handle the user's choice
        switch (choice) {
            case 0:
				new SearchCustomerForm(ordersCollection).setVisible(true);
                break;
            case 1:
                new SearchOrderForm(ordersCollection).setVisible(true);
                break;
            case 2:
                //Alert Canceled
				// ((AbstractButton) options[2]).addActionListener(new ActionListener(){
				// 	public void actionPerformed(ActionEvent evt){
				// 		new HomePageForm(ordersCollection);
				// 	}
				// });
                break;
            default:
                System.out.println("Alert closed without selection");
                break;
        }
	}
}
