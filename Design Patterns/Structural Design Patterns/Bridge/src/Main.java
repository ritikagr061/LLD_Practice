public class Main {
    public static void main(String[] args) {
        Shape blueSphere = new Sphere(new Blue());
        blueSphere.printShape();
        Shape redCube = new Cube(new RedColor());
        redCube.printShape();
    }
}