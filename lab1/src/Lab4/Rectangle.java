package Lab4;

public class Rectangle {
    int x;
    int y;
    int height;
    int width;

    public Rectangle(int x, int y, int height, int width) {
        this.x=x; this.y=y; this.height=height; this.width = width;
    }

    public void setRectangle(int x, int y,int height, int width){
        this.x=x; this.y=y; this.height=height; this.width = width;
    }
    public int  perimeter(){
        return 2*(this.height+this.width);
    }
    public int Area(){
        return this.height*this.width;
    }

    public Rectangle Merge(Rectangle rect){
        int width = Math.max(this.width, rect.width);
        int height =Math.max(this.height, rect.height);
        int x = Math.max(this.x, rect.x);
        int y =Math.max(this.y, rect.y);
        return new Rectangle(x,y,height,width);
    }

    public String toString(){
        return " Height is "+ this.height+ " width is "+ this.width + " top left corner at ("+ this.x +","+ this.y+")";
    }



    public static void main(String[] args) {
        Rectangle rect = new Rectangle(1,2,4,5);
        Rectangle rect2 = new Rectangle(2,3,5,6);
        System.out.println(rect.Area());
        System.out.println(rect.perimeter());
        System.out.println(rect);
        System.out.println(rect.Merge(rect2));
    }
}

