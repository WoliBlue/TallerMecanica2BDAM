import javax.swing.*;
import java.awt.*;

public class LoginScreen {
    public static void main(String[] args) {
        JFrame frame = new JFrame("DERRAP Login");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;

        // Background color
        frame.getContentPane().setBackground(new Color(243, 141, 52)); // var(--s7) color

        // Logo
        ImageIcon logoIcon = new ImageIcon("resources/icon2.png");
        JLabel logoLabel = new JLabel(logoIcon);
        frame.add(logoLabel, gbc);

        // Login Form
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints pGbc = new GridBagConstraints();
        pGbc.insets = new Insets(10, 10, 10, 10);
        pGbc.gridx = 0;
        pGbc.gridy = GridBagConstraints.RELATIVE;

        JLabel userLabel = new JLabel("DNI");
        userLabel.setForeground(new Color(242, 183, 5)); // var(--s2) color
        JTextField userText = new JTextField(20);
        JLabel passwordLabel = new JLabel("CONTRASEÑA");
        passwordLabel.setForeground(new Color(242, 183, 5)); // var(--s2) color
        JPasswordField passwordText = new JPasswordField(20);
        JCheckBox rememberMe = new JCheckBox("Recuérdame");
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBackground(new Color(242, 183, 5)); // var(--s2) color
        loginButton.setForeground(Color.WHITE);

        panel.add(userLabel, pGbc);
        panel.add(userText, pGbc);
        panel.add(passwordLabel, pGbc);
        panel.add(passwordText, pGbc);
        panel.add(rememberMe, pGbc);
        panel.add(loginButton, pGbc);

        panel.setBackground(Color.WHITE);
        frame.add(panel, gbc);

        // Contact Admin
        JLabel contactLabel = new JLabel("¿Tienes problemas? Contacte con el Administrador", SwingConstants.CENTER);
        contactLabel.setForeground(Color.RED);
        frame.add(contactLabel, gbc);

        frame.setVisible(true);
    }
}
