public class SolidFilledPolygon extends Polygon {
    private final String color;

    public SolidFilledPolygon(Vec2[] points, String color) {
        super(points);
        this.color = color;
    }

    @Override
    public String toSvg(String inputSvg) {
        return super.toSvg(String.format("fill=\"%s\" %s ", color, inputSvg));
    }
}