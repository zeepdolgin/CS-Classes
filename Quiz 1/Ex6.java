public class Ex6 {

    public static void main(String[] args) {
        int[] a = new int[10];
        methodOne(a);
        System.out.println(a.length);
    }
    static void methodOne(int [] a){
        int[] b = new int[5];
        a=b;
        System.out.println(a.length);
        System.out.println(b.length);
    }
}
