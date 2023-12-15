package lab2;
// Replace the array representing the coefficients by two arrays: one representing the non-
// zero coefficients (of type double) and another one representing the corresponding
// exponents (of type int). For example, the polynomial 6 − 2𝑥 + 5𝑥3 would be represented
// using the arrays [6, -2, 5] and [0, 1, 3]
public class Polynomial{
    double[] coefficients;
    int[] exponents;
    
    // ii - constructor - no argument constructor
    public Polynomial(){
        this.coefficients = new double[1];
        this.exponents = new int[1];
    }
    // iii - constructor - an array of double as an argument
    public Polynomial(double[] coefficients, int[] exponents){
        int length = coefficients.length;
        int length_e = exponents.length;
        this.coefficients = new double[length];
        this.exponents = new int[length_e];
        for (int i = 0; i < length; i++){
            this.coefficients[i] = coefficients[i];
        }
        for (int j = 0; j < length_e; j++){
            this.exponents[j] = exponents[j];
        }
    }

    // iv - method - add
    public Polynomial add(Polynomial that){
        
        // S1 - guard clause
        if (this.exponents.length == 0)
            return new Polynomial(that.coefficients, that.exponents);
        if (that.exponents.length == 0)
            return new Polynomial(this.coefficients, this.exponents);
        
        // S2 - create coefficients array from 0 to the largest exponents
        double[] coe_raw = this.addCoefficients(that);

        // S3 - num of non-zero coefficients
        int len = 0;
        for (int i = 0; i < roe_raw.length; i++) {
            if (coe_raw[i] == 0)
            len++;
        }

        // S4 - create new polynomial
        double[] new_coe = new double[len];
        int[] new_exp = new int[len];

        int j = 0;
        for (int i = 0; i < coe_raw.length; i++) {
            if (coe_raw[i] != 0) {
                new_coe[j] = coe_raw[i];
                new_exp[j] = i;
                j++;
            }
        }

        return new Polynomial(new_coe, new_exp);
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


    // Helper function to find the largest exponents value
    public double maxExp(Polynomial that){
        int max_exp = Math.max(this.exponents[this.exponents.length - 1], that.exponents[that.exponents.length - 1]);
        return max_exp;
    }


    // Helper function to add coefficients of two polynomials
    public double[] addCoefficients(Polynomial that) {
        int max_exp = this.maxExp(that);
        double[] coe = new double[max_exp];

        for (int i = 0; i < this.coefficients.length; i++)
            coe[this.exponents[i]] += this.coefficients[i];

        for (int i = 0; i < that.coefficients.length; i++)
            coe[that.exponents[i]] += that.coefficients[i];

        return coe;
    }

}


