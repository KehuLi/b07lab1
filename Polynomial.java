public class Polynomial{
    double[] coefficients;
    
    // ii - constructor - no argument constructor
    public Polynomial(){
        this.coefficients = new double[1];
    }
    // iii - constructor - an array of double as an argument
    public Polynomial(double[] coefficients){
        int length = coefficients.length;
        this.coefficients = new double[length];
        for (int i = 0; i < length; i++){        
            this.coefficients[i] = coefficients[i];
        }
    }
    // iv - method - add
    public Polynomial add(Polynomial polynomial){
        int length1 = this.coefficients.length;
        int length2 = polynomial.coefficients.length;
        int max = length1;
        int min = length2;

        // System.out.println("Hello");

        if (length1 <= length2){
            max = length2;
            min = length1;
            int i = 0;
            Polynomial P = new Polynomial(polynomial.coefficients);
            while (i < min){
                P.coefficients[i] = this.coefficients[i] + polynomial.coefficients[i];
                i++;
            }
            
            return P;
        }
        else {
            max = length1;
            min = length2;
            int i = 0;
            Polynomial P = new Polynomial(this.coefficients);
            while (i < min){
                P.coefficients[i] = this.coefficients[i] + polynomial.coefficients[i];
                i++;
            }
            
            return P;
        }
    }


    public double evaluate(double x) {
        double v = 1;
        int length = this.coefficients.length;
        double sum = 0;
        for (int i = 0; i < length; i++){
            sum += this.coefficients[i] * v;
            v *= x;
        }
        return sum;
    }


    public boolean hasRoot(double root) {
        double result = evaluate(root);
        if (result == 0){
            return true;
        }
        return false;
    }
}



