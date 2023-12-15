package lab2;

public class Driver {
    public static void main(String[] args){
        double []  c1 = {6,2,3};
        int []     e1 = {0,2,4};
        Polynomial p1 = new Polynomial(c1, e1);

        double []  c2 = {2,-2,7};
        int []     e2 = {0, 2, 3};
        Polynomial p2 = new Polynomial(c2, e2);

        System.out.println("testing add");
        Polynomial test1 = p1.add(p2);
        for (int i = 0; i < test1.coefficients.length; i++){
            System.out.print(test1.coefficients[i] + " ");
        System.out.println();
        }
        for (int i = 0; i < test1.exponents.length; i++){
            System.out.print(test1.exponents[i] + " ");
        System.out.println();
        }

    }
}