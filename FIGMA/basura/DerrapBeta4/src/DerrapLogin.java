import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class DerrapLogin {
    public static void main(String[] args) {
        JFrame frame = new JFrame("DERRAP Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false); // Prevent resizing

     // Load and register the custom fonts
        try {
            Font martianMono = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/MartianMono-Variable.ttf")).deriveFont(16f);
            Font outfit = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Outfit-SemiBold.ttf")).deriveFont(32f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(martianMono);
            ge.registerFont(outfit);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }



        // Main panel with orange background
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(243, 141, 52)); // #f38d34
        mainPanel.setLayout(null); // Absolute layout to position components manually

        // White panel
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setBounds(102, 126, 588, 372); // Position and size
        whitePanel.setLayout(new BoxLayout(whitePanel, BoxLayout.Y_AXIS)); // Vertical layout

        // Adding components to white panel
        JLabel iniciarsesionLabel = new JLabel("Iniciar Sesion");
        iniciarsesionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        whitePanel.add(iniciarsesionLabel);
        whitePanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing

        // Form elements with placeholders
        JTextField dniField = new JTextField("DNI", 20);
        dniField.setForeground(Color.GRAY);
        dniField.setMaximumSize(new Dimension(449, 56));
        dniField.setBackground(new Color(250, 250, 250));
        dniField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(234, 180, 19)), 
                BorderFactory.createEmptyBorder(16, 16, 16, 16)));

        dniField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (dniField.getText().equals("DNI")) {
                    dniField.setText("");
                    dniField.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (dniField.getText().isEmpty()) {
                    dniField.setForeground(Color.GRAY);
                    dniField.setText("DNI");
                }
            }
        });

        JPasswordField passwordField = new JPasswordField("Contraseña", 20);
        passwordField.setEchoChar((char) 0); // Show placeholder text
        passwordField.setForeground(Color.GRAY);
        passwordField.setMaximumSize(new Dimension(449, 56));
        passwordField.setBackground(new Color(250, 250, 250));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(234, 180, 19)), 
                BorderFactory.createEmptyBorder(16, 16, 16, 16)));

        passwordField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("Contraseña")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                    passwordField.setEchoChar('\u2022'); // Set to default echo character
                }
            }
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                    passwordField.setForeground(Color.GRAY);
                    passwordField.setText("Contraseña");
                    passwordField.setEchoChar((char) 0); // Show placeholder text
                }
            }
        });

        JCheckBox rememberMe = new JCheckBox("Recuérdame");
        rememberMe.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Login Button
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setMaximumSize(new Dimension(449, 56));
        loginButton.setBackground(new Color(242, 183, 5)); // s2 color
        loginButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(242, 183, 5)), 
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
       

        // Help label
        JLabel helpLabel = new JLabel("¿Tienes problemas? Contacte con el Administrador.");
        helpLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add components to white panel
        whitePanel.add(dniField);
        whitePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        whitePanel.add(passwordField);
        whitePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        whitePanel.add(rememberMe);
        whitePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        whitePanel.add(loginButton);
        whitePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        whitePanel.add(helpLabel);

        // Add white panel to main panel
        mainPanel.add(whitePanel);

        // Logo
        JLabel logo = new JLabel(new ImageIcon(DerrapLogin.class.getResource("/resources/icon2.png"))); // Replace with correct path
        logo.setBounds(104, 0, 586, 121); // Position and size
        mainPanel.add(logo);

        // Add main panel to frame
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);

        
        // ZONA DE FUENTES PARA CAMBIAR FUENTES
        iniciarsesionLabel.setFont(new Font("Outfit", Font.BOLD, 40));
        dniField.setFont(new Font("Martian Mono", Font.PLAIN, 16));
        passwordField.setFont(new Font("Martian Mono", Font.PLAIN, 16));
        loginButton.setFont(new Font("Outfit", Font.BOLD, 16));
        
        
        
        // Action listener for login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dni = dniField.getText();
                String password = new String(passwordField.getPassword());

                // Add your actual authentication logic here
                if ("correctDNI".equals(dni) && "correctPassword".equals(password)) {
                    JFrame newFrame = new JFrame("Welcome");
                    newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    newFrame.setSize(400, 300);
                    newFrame.getContentPane().add(new JLabel("Welcome to the new JFrame!"));
                    newFrame.setVisible(true);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid credentials. Please try again.");
                }
            }
        });
    }
    
}
