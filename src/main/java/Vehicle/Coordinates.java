package Vehicle;

public class Coordinates
{
    private float x;
    private double y;

    public float getX() {
        return this.x;
    }

    public void setX( float x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY( double y) {
        this.y = y;
    }

    public Coordinates( float x,  double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
    }

    @Override
    public String toString() {
        return "x=\"" + this.x + "\" y=\"" + this.y + "\"";
    }
}
