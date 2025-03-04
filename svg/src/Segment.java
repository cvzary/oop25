import static java.lang.Math.pow;

public class Segment {
    public Point a, b;

    public double length() {
        return Math.sqrt(pow(a.x-b.x, 2) + pow(a.y-b.y, 2));
    }

    public String toString() {
        return "("+a.x+","+a.y+") ("+b.x+";"+b.y+")";
    }

    public String toSvg() {
        return "<circle r=\"5\" cx=\""+a.x+"\" cy=\""+a.y+"\" fill=\"black\"/>"+" "+"<circle r=\"5\" cx=\""+b.x+"\" cy=\""+b.y+"\" fill=\"black\"/>";
    }

    public static Segment maxSegment(Segment[] arr) {
        if(arr.length == 0)
            return null;

        Segment max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i].length() > max.length())
                max = arr[i];
        }
        return max;
    }
}