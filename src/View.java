import javax.swing.*;
import java.awt.*;

public class View {
    private Controller controller;
    private JFrame frame;
    private CalculationPanel calculationPanel;
    private JLabel fileLocationLabel;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void showMainMenu() {
        frame = new JFrame("Kujundite kalkulaator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 425);
        frame.setLocationRelativeTo(null);

        MainPanel mainPanel = new MainPanel(e -> controller.handleChoice(1), e -> controller.handleChoice(2));
        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);

        fileLocationLabel = new JLabel();
        fileLocationLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        frame.add(fileLocationLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void showCylinderMenu() {
        frame.getContentPane().removeAll();
        calculationPanel = new CalculationPanel(true, e -> controller.calculateCylinder(calculationPanel));
        frame.add(calculationPanel, BorderLayout.CENTER);
        frame.add(fileLocationLabel, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
    }

    public void showSphereMenu() {
        frame.getContentPane().removeAll();
        calculationPanel = new CalculationPanel(false, e -> controller.calculateSphere(calculationPanel));
        frame.add(calculationPanel, BorderLayout.CENTER);
        frame.add(fileLocationLabel, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
    }

    public void setFileLocation(String filePath) {
        fileLocationLabel.setText("Faili asukoht: " + filePath);
    }
}
