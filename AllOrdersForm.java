import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class AllOrdersForm extends JFrame {
    private JButton btnBack;

    private OrdersCollection ordersCollection;

    AllOrdersForm(OrdersCollection ordersCollection){
        this.ordersCollection = ordersCollection;

        setSize(800,400);
        setTitle("All Orders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Arial",Font.BOLD,15));
        btnBack.setBackground(new Color(240, 128, 128));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(0,0,80,30);
        add(btnBack);

        //back button action
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                new ReportsForm(ordersCollection).setVisible(true);
            }
        });

        //table
        String[] colNames = {"Order ID","Customer ID","Size","Quantity","Amount","Status"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        Order[] cusArray = ordersCollection.getOrderObject();
        for(int i=0; i<cusArray.length; i++){
            Object[] rowData = {cusArray[i].getOrderId(),cusArray[i].getCustomerID(),cusArray[i].getSize(),cusArray[i].getQuantity(),cusArray[i].getAmount(),cusArray[i].getStatus()};
            dtm.addRow(rowData);
        }

        JTable cusTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusTable);
        sp.setBounds(100,60,600,300);
        add(sp);
    }
}
