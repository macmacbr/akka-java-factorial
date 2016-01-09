package akka.sample.messages.hash;

import java.math.BigInteger;

public class CalculateFactorial {

    public BigInteger calculate() {
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 1; i <= 739; i++) {
           //lets calculate factorial of 739 in a busy way.
            throw new RuntimeException("Needs implementation");
        }
        return fact;
    }
}
