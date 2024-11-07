import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class BestInCusForm extends JFrame {
    private JButton btnBack;

    private OrdersCollection ordersCollection;
    
    BestInCusForm(OrdersCollection ordersCollection){
        this.ordersCollection = ordersCollection;

        setSize(400,400);
        setTitle("Best In Customers");
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

        // making the table
        String[] colNames = {"Customer ID","Quantity","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        Order[] bInCus = ordersCollection.bestInCusSort();
        for(int i=0; i<bInCus.length; i++){
            if(bInCus[i]!=null){
                if(bInCus[i].getQuantity()!=0){
                    Object[] rowData = {bInCus[i].getCustomerID(),bInCus[i].getQuantity(),bInCus[i].getAmount()};
                    dtm.addRow(rowData);
                }
            }
        }

        JTable cusTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusTable);
        sp.setBounds(50,50,300,200);       
        add(sp);
    }
}
