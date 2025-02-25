
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        Point p1 = new Point();
        p1.x = 5.0;
        p1.y = 4.0;

        System.out.println(p1);
        System.out.println(p1.toSvg());

        p1.translate(-6, 5);
        System.out.println(p1);
        Point tr = p1.translated(6,-5);
        System.out.println(tr);

        Segment segment = new Segment();
        segment.a = new Point();
        segment.a.x = 0.0;
        segment.a.y = 0.0;
        segment.b = new Point();
        segment.b.x = 4.0;
        segment.b.y = 3.0;

        System.out.println(segment.length());
    }
}