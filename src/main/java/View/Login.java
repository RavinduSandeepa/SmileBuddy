/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.DB_Connection;
import Model.User;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ravin
 */
public class Login extends javax.swing.JFrame {
    
    User user = new User();
    /**
     * Creates new form Login
     */
    public Login() {
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

        jLabel2 = new javax.swing.JLabel();
        loginUsername = new javax.swing.JTextField();
        loginPassowrd = new javax.swing.JPasswordField();
        loginBtnSubmit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(826, 676));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        loginUsername.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loginUsername.setForeground(new java.awt.Color(204, 204, 204));
        loginUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        loginUsername.setText("Username");
        loginUsername.setToolTipText("");
        loginUsername.setBorder(null);
        loginUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        loginUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginUsernameMouseClicked(evt);
            }
        });
        getContentPane().add(loginUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 220, 70));

        loginPassowrd.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loginPassowrd.setForeground(new java.awt.Color(204, 204, 204));
        loginPassowrd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        loginPassowrd.setText("Password");
        loginPassowrd.setBorder(null);
        loginPassowrd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginPassowrdMouseClicked(evt);
            }
        });
        getContentPane().add(loginPassowrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 220, 70));

        loginBtnSubmit.setBackground(new java.awt.Color(0, 0, 255));
        loginBtnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        loginBtnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        loginBtnSubmit.setText("Submit");
        loginBtnSubmit.setBorder(null);
        loginBtnSubmit.setBorderPainted(false);
        loginBtnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(loginBtnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 200, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ravin\\Documents\\NetBeansProjects\\SmileBuddy\\src\\main\\java\\resources\\Login.png")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 826, 676));

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 826, 676));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUsernameMouseClicked
        loginUsername.setText(null);
        loginUsername.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_loginUsernameMouseClicked

    private void loginPassowrdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginPassowrdMouseClicked
       loginPassowrd.setText(null);
       loginPassowrd.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_loginPassowrdMouseClicked

    private void loginBtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnSubmitActionPerformed
        String username = loginUsername.getText();
        String password = String.valueOf(loginPassowrd.getPassword());
        
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please Enter All Fields",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            user = getAuthenticatedUser(username,password);
        } catch (SQLException ex) {
            System.out.println("Some error in Authentication");
        }
        if (user != null) {
            System.out.println("Successfull Authentication of : "+user.getUsername());
            System.out.println("        Email:"+user.getEmail() );
            //navigation here
            //String name = user.getUsername();
            int attempt = 1;
            GamePage smileGame = new GamePage(user,attempt);
            smileGame.setVisible(true);
            dispose();
        }else{
            System.out.println("Unsuccessful Login attempt");
            JOptionPane.showMessageDialog(this,
                    "Username or Password Invalid",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginBtnSubmitActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginBtnSubmit;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField loginPassowrd;
    private javax.swing.JTextField loginUsername;
    // End of variables declaration//GEN-END:variables

    private User getAuthenticatedUser(String username, String password) throws SQLException {
        
        User newUser = null;
        DB_Connection obj = new DB_Connection();
        Connection connection = obj.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                newUser = new User();
                newUser.setUsername(rs.getString("username"));
                newUser.setEmail(rs.getString("email"));
                newUser.setPassword(rs.getString("password"));
            }
            
        } catch (Exception e) {
            System.out.println("Some Error when Reading Login Details From DB :");
            System.err.println(e);
            
        }
        connection.close();
        ps.close();
        rs.close();
        
        return newUser;
    }
}
