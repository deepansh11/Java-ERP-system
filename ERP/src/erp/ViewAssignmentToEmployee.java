/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author VATSAL AJMERA
 */
public class ViewAssignmentToEmployee extends javax.swing.JFrame {

    /**
     * Creates new form ViewAssignment
     */
    public ViewAssignmentToEmployee() {
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.lightGray);
           DefaultTableModel model = new DefaultTableModel()
        {
        public Class<?> getColumnClass(int column){
         switch(column)
            {
             case 0:
                 return Boolean.class;
                 default: 
                     return String.class;
             }
          }
        };
            jTable1.setModel(model);
            JTableHeader header = jTable1.getTableHeader();
            header.setOpaque(false);
            header.setBackground(Color.BLACK);
            model.addColumn("Select");
            model.addColumn("ASSIGNMENT ID"); //1
            model.addColumn("FACULTY");//2
            model.addColumn("BRANCH");//3
            model.addColumn("SEMESTER");//4
            model.addColumn("SUBJECT");//14
            model.addColumn("ASSINGMENT");//5
            model.addColumn("PUBLISH DATE");//5
            model.addColumn("DUE DATE");//5
            try
        {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:51586;databaseName=bios1;user=sa;password=fastrack3");
       
            String sql = "select * from Assignment " ;
         
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            int p=0;
            while(rs.next())
           {
           String a = rs.getString(1);
           String b = rs.getString(2);
           String c = rs.getString(3);
           String d = rs.getString(4);
           String e = rs.getString(5);
           String f = rs.getString(6);
           String g = rs.getString(7);
           String h = rs.getString(8);
            model.addRow(new Object[]{a,b,c,d,e,f,g,h});
             model.setValueAt(false, p, 0);
            model.setValueAt(rs.getObject("AssignmentId"), p, 1);
            model.setValueAt(rs.getObject("faculty"), p, 2);
            model.setValueAt(rs.getObject("Branch"), p, 3);
            model.setValueAt(rs.getObject("semester"), p, 4);
            model.setValueAt(rs.getObject("subject"), p, 5);
            model.setValueAt(rs.getObject("Assignment"), p, 6);
            model.setValueAt(rs.getObject("PublishDate"), p, 7);
            model.setValueAt(rs.getObject("DueDate"), p, 8);
            p++;
           }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Assignment");
        setBackground(new java.awt.Color(153, 153, 153));

        jTable1.setBackground(new java.awt.Color(153, 153, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setPreferredSize(new java.awt.Dimension(300, 350));
        jTable1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Back/Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeHomePage().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for(int i=0; i<jTable1.getRowCount();i++){
           Boolean checked = Boolean.valueOf(jTable1.getValueAt(i,0).toString());
           if(checked){
            DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
        //model1.removeRow(jTable1.getSelectedRow());
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //System.out.println(jTable1.getSelectedRow());
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:51586;databaseName=bios1;user=sa;password=fastrack3");
        while(jTable1.getSelectedRow() >= 0 )
        {
            PreparedStatement pst = con.prepareStatement("delete AdminNotice where noticeid = ?");
           //System.out.println((String)(jTable1.getValueAt(jTable1.getSelectedRow(),0)));
            pst.setString(1,jTable1.getValueAt(i,1).toString());
            int rs = pst.executeUpdate();
            model1.removeRow(i);
            if(rs>=0)
            {
                
            }
        }
        JOptionPane.showMessageDialog(null,"Assignment removed successfully");
        }
        catch(Exception e){
        System.out.println(e);}
        }   
        if(!checked){
          JOptionPane.showMessageDialog(null,"Please Select Something");
        }
        };
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewAssignmentToEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAssignmentToEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAssignmentToEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAssignmentToEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAssignmentToEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
