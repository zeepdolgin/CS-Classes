public class Rectangle {
    private int length;
    private int width;

    public Rectangle(){
        this.length = 1;
        this.width = 1;
    }

    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public static int rectangle_area(Rectangle a){
        for(int i = 0; i < 10; i++){
            System.out.println(a.getLength()*a.getWidth());
        }
        return a.getLength()*a.getWidth();
    }

    public static boolean square_test(Rectangle a){
        boolean answer;
        if(a.getLength() == a.getWidth()){
            answer = true;
        }else{
            answer = false;
        }
        return answer;
    }
}
