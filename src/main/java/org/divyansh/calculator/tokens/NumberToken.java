package org.divyansh.calculator.tokens;

import material.utils.Log;
import org.divyansh.calculator.BigDecimalMath;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Objects;

public class NumberToken implements Token {
    public static final Token PI = new NumberToken(BigDecimalMath.PI.toString());
    private final BigDecimal bigInteger;

    public NumberToken(String val) {
        bigInteger = new BigDecimal(val);
    }

    public double getDoubleValue() {
        return bigInteger.doubleValue();
    }
    public BigDecimal getBigIntegerValue() {
        return bigInteger;
    }

    @Override
    public String getValue() {
        return bigInteger.toString();
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.NUMBER;
    }

    @Override
    public String toString() {
        return bigInteger.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberToken that)) return false;
        return Objects.equals(bigInteger, that.bigInteger);
    }
}
