import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculationPanel extends JPanel {
    private JTextField radiusField;
    private JTextField heightField;
    private JButton calculateButton;
    private JLabel baseAreaLabel;
    private JLabel lateralAreaLabel;
    private JLabel totalAreaLabel;
    private JLabel volumeLabel;
    private JLabel errorLabel;
    private JLabel radiusInputLabel;
    private JLabel heightInputLabel;

    public CalculationPanel(boolean showHeightField, ActionListener calculateListener) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel radiusLabel = new JLabel("Sisesta raadius:");
        radiusLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Määrab kirjasuuruse
        radiusField = new JTextField();
        radiusField.setFont(new Font("Arial", Font.PLAIN, 14)); // Määrab kirjasuuruse

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(radiusLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(radiusField, gbc);

        if (showHeightField) {
            JLabel heightLabel = new JLabel("Sisesta kõrgus:");
            heightLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            heightField = new JTextField();
            heightField.setFont(new Font("Arial", Font.PLAIN, 14));

            gbc.gridx = 0;
            gbc.gridy = 1;
            add(heightLabel, gbc);
            gbc.gridx = 1;
            gbc.gridy = 1;
            add(heightField, gbc);
        }

        calculateButton = new JButton("Arvuta");
        calculateButton.setFont(new Font("Arial", Font.PLAIN, 14));
        calculateButton.addActionListener(calculateListener);

        errorLabel = new JLabel();
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        errorLabel.setForeground(Color.RED);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(calculateButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(errorLabel, gbc);

        radiusInputLabel = new JLabel();
        radiusInputLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(radiusInputLabel, gbc);

        if (showHeightField) {
            heightInputLabel = new JLabel();
            heightInputLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Määrab kirjasuuruse
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 2;
            add(heightInputLabel, gbc);
        }

        baseAreaLabel = new JLabel();
        baseAreaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(baseAreaLabel, gbc);

        lateralAreaLabel = new JLabel();
        lateralAreaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        add(lateralAreaLabel, gbc);

        totalAreaLabel = new JLabel();
        totalAreaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        add(totalAreaLabel, gbc);

        volumeLabel = new JLabel();
        volumeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        add(volumeLabel, gbc);
    }

    public String getRadius() {
        return radiusField.getText();
    }

    public String getHeightInput() {
        return heightField != null ? heightField.getText() : null;
    }

    public void setError(String error) {
        errorLabel.setText(error);
    }

    public void setRadiusInput(String radius) {
        radiusInputLabel.setText("Sisestatud raadius: " + radius);
    }

    public void setHeightInput(String height) {
        if (heightInputLabel != null) {
            heightInputLabel.setText("Sisestatud kõrgus: " + height);
        }
    }

    public void setBaseArea(String baseArea) {
        baseAreaLabel.setText(baseArea);
    }

    public void setLateralArea(String lateralArea) {
        lateralAreaLabel.setText(lateralArea);
    }

    public void setTotalArea(String totalArea) {
        totalAreaLabel.setText(totalArea);
    }

    public void setVolume(String volume) {
        volumeLabel.setText(volume);
    }
}
