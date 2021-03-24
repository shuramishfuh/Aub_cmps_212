package com.lab8.Ex1;



public class Polynomial {
    private PolynomialNode head;

    public Polynomial(){
        this.head =null;
    }

    public boolean isEmpty(){
        //...
        return this.head ==null;
    };

    public void insert(int coef, int exp){
        //...
        int max=0;
        if (head ==null){
            head = new PolynomialNode(coef,exp);
            max =exp;
        }
        else {
            if (coef != 0) {
                PolynomialNode current = head;
                boolean found = false;
                max= head.exp;
                while (current.next != null) {
                    if (current.exp == exp) {
                        current.coef += coef;
                        found = true;
                        break;

                    }
                    else if(current.exp>exp && current.next.exp<exp){
                        PolynomialNode n =current.next;
                        current.next = new PolynomialNode(coef,exp);
                        current.next.next = n;
                    }
                    current = current.next;
                }
                if (!found) {
                    if ( exp<max)

                        current.next = new PolynomialNode(coef, exp);

                    else if(exp>max){
                        PolynomialNode node = new PolynomialNode(coef, exp);
                        PolynomialNode temp = head;
                        head = node;
                        head.next = temp;
                    }
                }

            }
        }
    }

    public PolynomialNode getLastElement(){
        PolynomialNode current = this.head;
        while (current.next != null){
            current = current.next; // get last element
        }
        return current;
    }

    public void remove(){
        //...
        this.head = this.head.next;

    }

    public String toString(){
        //...
        StringBuilder sb = new StringBuilder();
        PolynomialNode current = this.head;
        while (current != null){
            sb.append(current.coef+"x^"+ current.exp);
            sb.append(" + ");
            current=current.next;
        }
        sb.delete(sb.length()-2,sb.length());
        return sb.toString();
    }

    public void add(Polynomial p){
        //...
        int coef,exp;
        int max=0;
        PolynomialNode gn = p.head;
        while (gn.next != null){
            coef = gn.coef;
            exp= gn.exp;
            if (head ==null){
                head = gn;
                max =exp;
            }
            else {
                if (coef != 0) {
                    PolynomialNode current = head;
                    boolean found = false;
                    max= head.exp;
                    while (current.next != null) {
                        if (current.exp == exp) {
                            current.coef += coef;
                            found = true;
                            break;

                        }
                        else if(current.exp>exp && current.next.exp<exp){
                            PolynomialNode n =current.next;
                            current.next = new PolynomialNode(coef,exp);
                            current.next.next = n;
                            found=true;
                            break;
                        }
                        current = current.next;
                    }
                    if (!found) {
                        if ( exp<max)

                            current.next = new PolynomialNode(coef, exp);

                        else if(exp>max){
                            PolynomialNode node = new PolynomialNode(coef, exp);
                            PolynomialNode temp = head;
                            head = node;
                            head.next = temp;
                        }
                    }

                }
            }

            gn = gn.next;
        }
        // last element
        coef = gn.coef;
        exp= gn.exp;
        if (head ==null){
            head = gn;
            max =exp;
        }
        else {
            if (coef != 0) {
                PolynomialNode current = head;
                boolean found = false;
                max = head.exp;
                while (current.next != null) {
                    if (current.exp == exp) {
                        current.coef += coef;
                        found = true;
                        break;

                    } else if (current.exp > exp && current.next.exp < exp) {
                        PolynomialNode n = current.next;
                        current.next = new PolynomialNode(coef, exp);
                        current.next.next = n;
                        found = true;
                        break;
                    }
                    current = current.next;
                }
                if (!found) {
                    if (exp == current.exp){
                        current.coef += coef;
                    }
                    else if (exp < max)

                        current.next = new PolynomialNode(coef, exp);

                    else if (exp > max) {
                        PolynomialNode node = new PolynomialNode(coef, exp);
                        PolynomialNode temp = head;
                        head = node;
                        head.next = temp;
                    }
                }

            }
        }



    };

    public int evaluate(int x) {
        //...
        if (x == 0) return 0;
        else {
            PolynomialNode current = head;
            int sum = 0;
            while (current.next != null) {
                sum += current.coef * (x * Math.pow(x, current.exp));
                current = current.next;
            }
            sum+= current.coef * (x * Math.pow(x, current.exp));
            return sum;
        }
    }

    public Polynomial derivate(){
        //...
        PolynomialNode current =this.head;
        PolynomialNode pre = null;
        while (current.next != null) {
            if (current.exp !=0){
                current.coef=(current.coef*current.exp);
                current.exp= current.exp-1;
            }
            pre=current;
            current= current.next;
        }
        if (current.exp ==0) { // element not executed in the loop
            pre.next = null;
        }
        else {
            current.coef = (current.coef * current.exp);
            current.exp = current.exp - 1;
        }
        return this;
    };

    public static void main(String[] args) {
        Polynomial polynomial = new Polynomial();
        polynomial.insert(3,1);
        polynomial.insert(1,3);
        polynomial.insert(2,2);
        polynomial.insert(9,4);
        polynomial.insert(6,4);

        Polynomial dif = new Polynomial();
        dif.insert(2,1);
        dif.insert(3,12);
        dif.insert(1,3);
        dif.insert(1,33);


        System.out.println( polynomial.toString());
        System.out.println( dif.toString());
        System.out.println(polynomial.evaluate(1));
        System.out.println( polynomial.derivate().toString());
        System.out.println(polynomial.evaluate(1));
        System.out.println( polynomial.derivate().toString());
        System.out.println(polynomial.evaluate(1));
        System.out.println( polynomial.derivate().toString());
        polynomial.remove();
        System.out.println( polynomial.toString());
        System.out.println( dif.toString());
        dif.add(polynomial);
        System.out.println(dif.toString());


    }
}