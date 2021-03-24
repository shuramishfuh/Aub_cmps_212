//public class App {
//
//    public static void main(String[] args) {
//        Polynomial P1=new Polynomial();
//
//        if(P1.isEmpty())
//            System.out.println("The Polynomial list is empty");
//
//        P1.insert(10, 3);
//        P1.insert(5, 2);
//        P1.insert(3, 1);
//        P1.insert(5, 0);
//
//        if(!P1.isEmpty())
//            System.out.println("The Polynomial list is not empty");
//
//        System.out.println("Given the following generated polynimial: " + P1.toString());
//
//        //3x^3-7x^2+3x-6
//        Polynomial P2=new Polynomial();
//        P2.insert(3, 3);
//        P2.insert(7, 2);
//        P2.insert(3, 1);
//        P2.insert(6, 0);
//
//        System.out.print(P1.toString() +" + "+P2.toString()+" = ");
//        P1.add(P2);
//        System.out.println(P1.toString());
//
//        System.out.print("For x=4, "+P1.toString()+" = "+P1.evaluate(4));
//
//        System.out.println("The derivative of "+P2.toString()+" is "+ P2.derivate().toString());
//
//    }
//}
