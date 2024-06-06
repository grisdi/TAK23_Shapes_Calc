public class Cylinder {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double calculateBaseArea() {
        return Math.PI * radius * radius;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * Math.PI * radius * height;
    }

    public double calculateTotalSurfaceArea() {
        return 2 * calculateBaseArea() + calculateLateralSurfaceArea();
    }

    public double calculateVolume() {
        return calculateBaseArea() * height;
    }
}
