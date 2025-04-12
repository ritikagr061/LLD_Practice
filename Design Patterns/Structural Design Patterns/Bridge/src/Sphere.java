public class Sphere extends Shape{
    public Sphere(Color col) {
        super(col);
    }

    @Override
    public void printShape() {
        System.out.println("This is a Sphere with color "+color.printColor());
    }
}
