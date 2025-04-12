public class Cube extends Shape{
    public Cube(Color col) {
        super(col);
    }

    public void printShape(){
        System.out.println("This is a cube with color "+color.printColor());
    }
}
