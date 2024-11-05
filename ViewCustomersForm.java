import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

class ViewCustomersForm extends JFrame{
    private JButton btnBack;

    private OrdersCollection ordersCollection;

    ViewCustomersForm(OrdersCollection ordersCollection){
        this.ordersCollection = ordersCollection;

        setSize(400,400);
        setTitle("View Customers");
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

        String[] colNames = {"Customer ID","QTY","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        Order[] order = ordersCollection.viewCustomer();
        for(int i=0; i<order.length; i++){
            if (order[i]!=null) {
                Object[] rowData = {order[i].getCustomerID(),order[i].getQuantity(),order[i].getAmount()};
                dtm.addRow(rowData);
            }
        }

        JTable cusJTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusJTable);
        sp.setBounds(50,50,300,200);
        add(sp);
    }
}
