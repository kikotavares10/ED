class Rectangle{
    Point infesq, supdir;
    public Rectangle(int x1, int y1, int x2, int y2){
        infesq= new Point(x1,y1);
        supdir= new Point(x2,y2);
    }

    public Rectangle(Point p1, Point p2){
        infesq=p1;
        supdir=p2;
    }

    public int area(){
        int largura=supdir.x - infesq.x;
        int altura=supdir.y - infesq.y;

        return largura*altura;
    }

    public int perimeter(){
        int largura=supdir.x-infesq.x;
        int altura=supdir.y - infesq.y;
        return 2*(largura+altura);
    }

    public boolean pointInside(Point p){
        return(p.x>=infesq.x && p.x<=supdir.x && p.y>=infesq.y && p.y<=supdir.y);
    }

    public boolean rectangleInside(Rectangle r){
        return(r.infesq.x >= infesq.x && r.infesq.y>= infesq.y && r.supdir.x <= supdir.x && r.supdir.y <= supdir.y);
    }
}

