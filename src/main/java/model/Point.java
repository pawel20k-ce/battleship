package model;

public class Point {

   public final Integer x;
    public final Integer y;

    public Integer getX() {
        return x;
    }



    public Integer getY() {
        return y;
    }



    public  Point(Integer x, Integer y){
        if (x== null || y ==null){
            throw new IllegalArgumentException();
        }
            this.x=x;
            this.y=y;

}

public Point(Point p){
        if (p == null || p.getX() == null || p.getY() == null){
            throw new IllegalArgumentException();
        }
    this.x=p.getX();
    this.y=p.getY();
}



}
