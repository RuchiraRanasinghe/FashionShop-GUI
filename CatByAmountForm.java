import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class CatByAmountForm extends JFrame {
    private JButton btnBack;

    private OrdersCollection ordersCollection;

    CatByAmountForm(OrdersCollection ordersCollection){
        this.ordersCollection = ordersCollection;

        setSize(400,400);
        setTitle("Items By Amount");
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

        String[] colNames = {"Size","QTY","Amount"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0);

        Sorting[] sortAmount = ordersCollection.sortByAmount();
        for(int i=0; i<sortAmount.length; i++){
            Object[] rowData = {sortAmount[i].getSize(),sortAmount[i].getQuantity(),sortAmount[i].getAmount()};
            dtm.addRow(rowData);
        }

        JTable cusTable = new JTable(dtm);
        JScrollPane sp = new JScrollPane(cusTable);
        sp.setBounds(50,50,300,300);
        add(sp);
    }
}
