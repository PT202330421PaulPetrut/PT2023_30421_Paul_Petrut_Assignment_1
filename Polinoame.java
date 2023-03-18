import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Polinome {

    private HashMap<Integer, Float> polynomial= new HashMap<Integer, Float>();

    public DivisionResult division (@NotNull HashMap<Integer, Float> poly1,@NotNull HashMap<Integer, Float> poly2){
        DivisionResult res = new DivisionResult();
        HashMap<Integer, Float> quotient= new HashMap<Integer, Float>();
        HashMap<Integer, Float> remainder= poly1;

        if(isZeroPolynomial(poly2)){
            res.setDivZero(true);
            return res;
        }
        else res.setDivZero(false);

        int degreeRest=getDegree(remainder);
        int degreePoly2=getDegree(poly2);
        while(!isZeroPolynomial(remainder) && degreeRest>=degreePoly2){
            int degreeDiff = degreeRest - degreePoly2;
            float coefficient = remainder.get(degreeRest) / poly2.get(degreePoly2);
            quotient.put(degreeDiff,coefficient);
            HashMap<Integer, Float> aux= new HashMap<Integer, Float>();
            aux.put(degreeDiff,coefficient);
            aux =  multiplyPolynomials(poly2,aux);
            remainder= subPolynomials(remainder, aux);
            degreeRest= getDegree(remainder);

        }
        res.setRest(remainder);
        res.setCat(quotient);
        return res;
    }

    public int getDegree(HashMap<Integer, Float> poly1){
        int maxPower=0;
        for (Map.Entry<Integer, Float> entry : poly1.entrySet()) {
            Integer power = entry.getKey();
            Float coefficent = entry.getValue();
            if (maxPower < power && coefficent != 0.0f) {
                maxPower = power;
            }
        }
        return maxPower;
    }

    public @NotNull HashMap<Integer, Float> derivate(@NotNull HashMap<Integer, Float> poly1){
        HashMap<Integer, Float> result =  new HashMap<Integer, Float>();
        if(isZeroPolynomial(poly1))
        {
            return poly1;
        }
        poly1.forEach((degree,coefficient)-> {
            if(coefficient!=0&& degree!=0){   // if degree==0 the it is not .put in result
                    result.put(degree-1,coefficient*(degree));
            }
        });

        return result;
    }

    public @NotNull HashMap<Integer, Float> integrate(@NotNull HashMap<Integer, Float> poly1){
        HashMap<Integer, Float> result =  new HashMap<Integer, Float>();
        if(isZeroPolynomial(poly1)){
            result.put(1,1.0f);
            return result;
        }
        poly1.forEach((degree,coefficient)-> {
            if(coefficient!=0){
                result.put(degree+1,coefficient/(degree+1));
            }
        });
        return result;
    }

    public @NotNull HashMap<Integer, Float> multiplyPolynomials( HashMap<Integer, Float> poly1,  HashMap<Integer, Float> poly2){
        HashMap<Integer, Float> result = new HashMap<Integer, Float>();

        for (Map.Entry<Integer, Float> term1 : poly1.entrySet()){
            for (Map.Entry<Integer, Float> term2 : poly2.entrySet()) {
                int degree = term2.getKey()+term1.getKey();
                float coefficient = term1.getValue()*term2.getValue();
                    if (result.containsKey(degree)) {
                    coefficient += result.get(degree);
                    }
                result.put(degree, coefficient);
            }
        }
        return result;
    }

    public @NotNull HashMap<Integer, Float> addPolynomials( HashMap<Integer, Float> poly1,  HashMap<Integer, Float> poly2) {
        HashMap<Integer, Float> result = poly1;
        // Iterate over the second polynomial and add its terms to the result
        for (Map.Entry<Integer, Float> term2 : poly2.entrySet()) {
            int degree = term2.getKey();
            float coefficient = (float) 0.0;
                coefficient+= term2.getValue();
            if (result.containsKey(degree)) {
                coefficient += result.get(degree);
            }
                result.put(degree, coefficient);
        }
        return result;
    }

    public @NotNull HashMap<Integer, Float> subPolynomials(HashMap<Integer, Float> poly1, HashMap<Integer, Float> poly2) {
        HashMap<Integer, Float> result = poly1;

        for (Map.Entry<Integer, Float> term2 : poly2.entrySet()) {
            int degree = term2.getKey();
            float coefficient = -term2.getValue();

            if (result.containsKey(degree)) {
                coefficient += result.get(degree);
            }
            result.put(degree, coefficient);
        }
        return result;
    }

    public boolean isZeroPolynomial(HashMap<Integer, Float> polynomial) {
        if (polynomial == null) {
            return true;
        }

        for (float coefficient : polynomial.values()) {
            if (coefficient != 0) {
                return false;
            }
        }

        return true;
    }

    public void reset(){
        polynomial.clear();
        this.polynomial= new HashMap<Integer, Float>();
    }

    public void setPolinome(HashMap polinome) {
        this.polynomial = polinome;
    }

    public HashMap getPolinome() {
        return polynomial;
    }

}
