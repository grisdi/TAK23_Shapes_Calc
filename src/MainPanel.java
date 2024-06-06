import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    public MainPanel(ActionListener cylinderListener, ActionListener sphereListener) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel cylinderLabel = new JLabel("SILINDER");
        cylinderLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(cylinderLabel, gbc);

        // Lisa silindri pilt ja muuda selle suurust
        ImageIcon originalCylinderIcon = new ImageIcon("cylinder.jpg");
        Image cylinderImage = originalCylinderIcon.getImage();
        Image resizedCylinderImage = cylinderImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedCylinderIcon = new ImageIcon(resizedCylinderImage);
        JLabel cylinderImageLabel = new JLabel(resizedCylinderIcon);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(cylinderImageLabel, gbc);

        JButton cylinderButton = new JButton("Silindri arvutamine");
        cylinderButton.addActionListener(cylinderListener);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(cylinderButton, gbc);

        JLabel sphereLabel = new JLabel("KERA");
        sphereLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(sphereLabel, gbc);

        // Lisa kera pilt ja muuda selle suurust
        ImageIcon originalSphereIcon = new ImageIcon("sphere.jpg");
        Image sphereImage = originalSphereIcon.getImage();
        Image resizedSphereImage = sphereImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedSphereIcon = new ImageIcon(resizedSphereImage);
        JLabel sphereImageLabel = new JLabel(resizedSphereIcon);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(sphereImageLabel, gbc);

        JButton sphereButton = new JButton("Kera arvutamine");
        sphereButton.addActionListener(sphereListener);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(sphereButton, gbc);
    }
}
