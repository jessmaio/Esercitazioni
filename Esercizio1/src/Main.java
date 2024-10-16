public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!\n");
        MySet s1 = new MySet(20);
        System.out.println(s1.checkElement(0));
        System.out.println(s1);
        s1.addElement(42);
        System.out.println(s1);
        s1.addElement(27);
        s1.addElement(33);
        System.out.println(s1);
        s1.removeElement(105);
        MySet s2 = new MySet(20);
        s2.addElement(142);
        s2.addElement(143);
        s2.addElement(144);
        System.out.println(s2);
    }
}