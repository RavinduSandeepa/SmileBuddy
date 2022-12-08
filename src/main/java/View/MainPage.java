/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.DB_Connection;
import Model.User;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ravin
 */
public class MainPage extends javax.swing.JFrame {

    private static boolean connectToDatabase() {
        boolean hasRegisteredUsers = false;
        
        DB_Connection obj = new DB_Connection();
        
        
        //Connection connection3 = obj.getConnection();
        
        final String DB_URL = "jdbc:mysql://localhost:3308/";
        final String USERNAME = "root";
        final String PASSWORD= "";
        PreparedStatement ps = null, ps1 = null, ps2 = null;
        ResultSet rs = null;
        
        try {
            Connection connection = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                String createDataBase = "CREATE DATABASE IF NOT EXISTS mygame;";
                ps = connection.prepareStatement(createDataBase);  
                ps.executeUpdate();
                ps.close();
                connection.close();
                
                System.out.println("DB Creation is Ok");
        } catch (Exception e) {
            System.out.println("Some error when Creating New DB :");
            System.out.println(e);
        }
        try {
            Connection connection1 = obj.getConnection();
            String createTable = "CREATE TABLE IF NOT EXISTS users ("
                    +"Id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    +"username VARCHAR(200) NOT NULL UNIQUE,"
                    +"email VARCHAR(200) NOT NULL,"
                    +"password VARCHAR(200) NOT NULL"
                    +")";
            
            ps1 = connection1.prepareStatement(createTable);
            ps1.executeUpdate();
            ps1.close();
            connection1.close();
            
        } catch (Exception e) {
            System.out.println("Some error when Creating Table in New DB :");
            System.out.println(e);
        }
       
        try {
            Connection connection2 = obj.getConnection();
            String query = "SELECT COUNT(*) FROM users";
            ps2 = connection2.prepareStatement(query);
            rs = ps2.executeQuery();
            if (rs.next()) {
                int numUsers = rs.getInt(1);
                if (numUsers>0) {
                    hasRegisteredUsers = true;
                }
                else{
                    hasRegisteredUsers = false;
                }
            }
            ps2.close();
            connection2.close();
            
        } catch (Exception e) {
            System.out.println("Some error when Counting in new DB :");
            System.out.println(e);
        }
        System.err.println(" Has Registration? :"+hasRegisteredUsers);
        return hasRegisteredUsers;
    }

    /**
     * Creates new form MainPage
     */
    public MainPage() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPagePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BtnLogin = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Kristen ITC", 1, 70)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Smile Buddy");
        mainPagePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        BtnLogin.setBackground(new java.awt.Color(0, 0, 255));
        BtnLogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BtnLogin.setForeground(new java.awt.Color(255, 255, 255));
        BtnLogin.setText("Login");
        BtnLogin.setActionCommand("");
        BtnLogin.setBorder(null);
        BtnLogin.setBorderPainted(false);
        BtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoginActionPerformed(evt);
            }
        });
        mainPagePanel.add(BtnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 200, 50));

        btnSignUp.setBackground(new java.awt.Color(0, 0, 255));
        btnSignUp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(255, 255, 255));
        btnSignUp.setText("SignUp");
        btnSignUp.setBorder(null);
        btnSignUp.setBorderPainted(false);
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        mainPagePanel.add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 200, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ravin\\Documents\\NetBeansProjects\\SmileBuddy\\src\\main\\java\\resources\\mainPageBG.png")); // NOI18N
        jLabel2.setText("jLabel2");
        mainPagePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 826, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoginActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_BtnLoginActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        this.dispose();
        Registration registration = new Registration();
        registration.setVisible(true);
    }//GEN-LAST:event_btnSignUpActionPerformed

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        boolean hasRegistration = connectToDatabase();
        if (hasRegistration) {
            System.out.println("Registration Found");
            Login login = new Login();
            //User user = login.user;
            login.setVisible(true);
        }
        else{
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLogin;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainPagePanel;
    // End of variables declaration//GEN-END:variables
}
