import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
    private Model model;
    private View view;
    private static final String FILE_NAME = "JavaKujundid.txt";

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void handleChoice(int choice) {
        switch (choice) {
            case 1:
                view.showCylinderMenu();
                break;
            case 2:
                view.showSphereMenu();
                break;
        }
    }

    public void calculateCylinder(CalculationPanel panel) {
        panel.setError(""); // Tühjendab eelmise veateate
        try {
            String radiusStr = panel.getRadius();
            String heightStr = panel.getHeightInput();

            if (radiusStr.isEmpty() || heightStr.isEmpty()) {
                throw new IllegalArgumentException("Palun täida vajalikud väljad!");
            }

            double radius = Double.parseDouble(radiusStr);
            double height = Double.parseDouble(heightStr);

            if (radius <= 0 || height <= 0) {
                throw new IllegalArgumentException("Palun sisesta positiivne number!");
            }

            Cylinder cylinder = new Cylinder(radius, height);

            panel.setRadiusInput(radiusStr);
            panel.setHeightInput(heightStr);
            panel.setLateralArea("Küljepindala: " + cylinder.calculateLateralSurfaceArea());
            panel.setTotalArea("Kogupindala: " + cylinder.calculateTotalSurfaceArea());
            panel.setVolume("Ruumala: " + cylinder.calculateVolume());

            // Kirjutab tulemused faili
            String result = String.format("Silinder;%s;%s;%f;%f;%f",
                    radiusStr, heightStr, cylinder.calculateTotalSurfaceArea(),
                    cylinder.calculateLateralSurfaceArea(), cylinder.calculateVolume());
            String filePath = writeToFile(result);
            view.setFileLocation(filePath);
        } catch (NumberFormatException ex) {
            panel.setError("Sisesta ainult numbrid!");
        } catch (IllegalArgumentException ex) {
            panel.setError(ex.getMessage());
        }
    }

    public void calculateSphere(CalculationPanel panel) {
        panel.setError(""); // Tühjendab eelneva veateate
        try {
            String radiusStr = panel.getRadius();

            if (radiusStr.isEmpty()) {
                throw new IllegalArgumentException("Palun täida vajalikud väljad!");
            }

            double radius = Double.parseDouble(radiusStr);

            if (radius <= 0) {
                throw new IllegalArgumentException("Palun sisesta positiivne number!");
            }

            Sphere sphere = new Sphere(radius);

            panel.setRadiusInput(radiusStr);
            panel.setBaseArea("Pindala: " + sphere.calculateSurfaceArea());
            panel.setVolume("Ruumala: " + sphere.calculateVolume());

            // Kirjutab tulemused faili
            String result = String.format("Kera;%s;%f;%f",
                    radiusStr, sphere.calculateSurfaceArea(), sphere.calculateVolume());
            String filePath = writeToFile(result);
            view.setFileLocation(filePath);
        } catch (NumberFormatException ex) {
            panel.setError("Sisesta ainult numbrid!");
        } catch (IllegalArgumentException ex) {
            panel.setError(ex.getMessage());
        }
    }

    private String writeToFile(String result) {
        File file = new File(FILE_NAME);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(result);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }
}
