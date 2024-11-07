import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class CatByQtyForm extends JFrame {
    private JButton btnBack;

    private OrdersCollection ordersCollection;
    
    CatByQtyForm(OrdersCollection ordersCollection){
        this.ordersCollection = ordersCollection;

        setSize(400,400);
        setTitle("Items By Qty");
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

        // table
        String[] colNames = {"Size","QTY","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        Sorting[] sortQty = ordersCollection.sortByQty();
        for(int i=0; i<sortQty.length; i++){
            Object[] rowData = {sortQty[i].getSize(),sortQty[i].getQuantity(),sortQty[i].getAmount()};
            dtm.addRow(rowData);
        }

        JTable cusTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusTable);
        sp.setBounds(50,50,300,200);
        add(sp);
    }
}
