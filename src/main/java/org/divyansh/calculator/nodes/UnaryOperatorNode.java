package org.divyansh.calculator.nodes;

import org.divyansh.calculator.BigDecimalMath2;
import org.divyansh.calculator.tokens.OperatorToken;

import java.math.BigDecimal;

public class UnaryOperatorNode extends Node {
    private final Node node;
    private final OperatorToken op;
    public UnaryOperatorNode(OperatorToken op, Node node) {
        this.node = node;
        this.op = op;
    }

    @Override
    public BigDecimal evaluateValue() {
        BigDecimal operand = node.evaluateValue();
        if(operand== null)
            throw new NullPointerException("OPERAND IS NULL FOR UNARY OPERATOR: " + op);
        switch (op.getOperatorType()){
            case FACTORIAL -> {
                return BigDecimalMath2.getFactorial(operand);
            }
            case MINUS -> {
                return operand.negate();
            }
            case PLUS -> {
                return operand;
            }
            default -> throw  new UnsupportedOperationException("UNSUPPORTED OPERATOR: " + op);
        }
    }



    @Override
    public String toString() {
        node.level = this.level + 1;
        return REPEATER.repeat(level) +CONNECTOR + op.getOperatorType() + "["+op.getValue()+"]\n"+ node;
    }
}
