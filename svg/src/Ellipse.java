public class Ellipse extends Shape {
    private Point o;
    private double rx, ry;

    public Ellipse(Point o, double rx, double ry, Style style) {
        super(style);
        this.o = new Point(o);
        this.rx = rx;
        this.ry = ry;
    }

    @Override
    public String toSvg() {
        return "<ellipse rx=\""+rx+"\" ry=\""+ry+"\" cx=\""+o.getX()+"\" cy=\""+o.getY()+"\"" +
                "  "+style.toSvg()+" />";
    }

    @Override
    public BoundingBox boundingBox() {
        return new BoundingBox(o.getX()-rx, o.getY()-ry, rx*2, ry * 2);
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "o=" + o +
                ", rx=" + rx +
                ", ry=" + ry +
                '}';
    }
}
