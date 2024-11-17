import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class HomePageForm extends JFrame {
    private JLabel lblTitle;
    private JLabel copyrightLabel;
    private JLabel imageLabel;
    private JButton btnSearch;
    private JButton btnViewReports;
    private JButton btnSetOrderStatus;
    private JButton btnDeleteOrder;
    private JButton btnPlaceOrder;

    HomePageForm(List ordersCollection) {
        setSize(500, 550);
        setTitle("Fashion Shop");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // ----------------- Title --------------------
        lblTitle = new JLabel("Fashion Shop", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 36));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBackground(new Color(51, 102, 255));
        lblTitle.setOpaque(true);
        lblTitle.setBounds(0, 0, 500, 50);
        add(lblTitle);
        
        // ----------------- Buttons --------------------
        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Arial", Font.BOLD, 16));
        btnSearch.setBounds(50, 80, 200, 50);
        add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Object[] options = { "Search Customer", "Search Order", "Cancel" };
                int response = JOptionPane.showOptionDialog(
                        null,
                        "Please select the option",
                        "Search Options",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);

                switch (response) {
                    case 0:
                        new SearchCustomerForm(ordersCollection).setVisible(true);
                        break;
                    case 1:
                        new SearchOrderForm(ordersCollection).setVisible(true);
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Unexpected response.");
                        break;
                }
            }
        });

        btnViewReports = new JButton("Reports");
        btnViewReports.setFont(new Font("Arial", Font.BOLD, 16));
        btnViewReports.setBounds(50, 150, 200, 50);
        add(btnViewReports);
        btnViewReports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new ReportsForm(ordersCollection).setVisible(true);
                dispose();
            }
        });

        btnSetOrderStatus = new JButton("Status");
        btnSetOrderStatus.setFont(new Font("Arial", Font.BOLD, 16));
        btnSetOrderStatus.setBounds(50, 220, 200, 50);
        add(btnSetOrderStatus);
        btnSetOrderStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new StatusForm(ordersCollection).setVisible(true);
                dispose();
            }
        });

        btnDeleteOrder = new JButton("Delete");
        btnDeleteOrder.setFont(new Font("Arial", Font.BOLD, 16));
        btnDeleteOrder.setBounds(50, 290, 200, 50);
        add(btnDeleteOrder);
        btnDeleteOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new DeleteOrderForm(ordersCollection).setVisible(true);
                dispose();
            }
        });
        
        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setFont(new Font("Arial", Font.BOLD, 20));
        btnPlaceOrder.setBackground(new Color(4, 203, 201));
        btnPlaceOrder.setBounds(50, 360, 200, 80);
        add(btnPlaceOrder);
        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new PlaceOrderForm(ordersCollection).setVisible(true);
                dispose();
            }
        });

        // ----------------- Image --------------------
        imageLabel = new JLabel(new ImageIcon("Images\\fashionShop1.png"));
        imageLabel.setBounds(250, 80, 230, 360);
        add(imageLabel);

        // ----------------- Footer Label --------------------
        copyrightLabel = new JLabel("Copyrights © Ruchira 2024", SwingConstants.CENTER);
        copyrightLabel.setBounds(0, 470, 500, 20);
        add(copyrightLabel);
    }
}