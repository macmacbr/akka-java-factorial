package akka.sample.messages.akka;

import sun.plugin2.message.Serializer;

import java.io.Serializable;
import java.math.BigInteger;

public class Result implements Serializable {

    private BigInteger bigInt;

    public Result(BigInteger bigInt) {
        this.bigInt = bigInt;
    }

    public BigInteger getFactorial() {
        return this.bigInt;
    }
}
