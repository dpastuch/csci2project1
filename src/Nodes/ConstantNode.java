package Nodes;

import Util.SymbolTable;

/**
 * A node with a constant value.
 *
 * @author dmp6637 (David Pastuch)
 */
public class ConstantNode implements MerpNode {

    private int value;

    /**
     * Create a new constant node.
     * @param value Value of node
     */
    public ConstantNode(int value) {
        this.value = value;
    }

    /**
     * Determine if this node is an operation node.
     * @return True if this is an operation node, otherwise false
     */
    @Override
    public boolean isOperation() {
        return false;
    }

    /**
     * Evaulate this node.
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        return this.value;
    }

    /**
     * Get the precedence of this node.
     * @return The precedence of CONSTANT
     */
    @Override
    public int getPrecedence() {
        return Precedence.CONSTANT.getPrecedence();
    }

    /**
     * Get this node's type.
     * @return Type of node
     */
    @Override
    public NodeType getNodeType() {
        return NodeType.Constant;
    }

    /**
     * Convert this node to an infix string.
     * @return node in string format
     */
    @Override
    public String toInfixString() {
        return Integer.toString(this.value);
    }

    /**
     * Convert this node to a postfix string.
     * @return node in string format
     */
    @Override
    public String toPostfixString() {
        return Integer.toString(this.value);
    }

    /**
     * Convert this node to an prefix string.
     * @return node in string format
     */
    @Override
    public String toPrefixString() {
        return Integer.toString(this.value);
    }

    /**
     * Testing statements
     * @param args none
     */
    public static void main(String[] args) {
        ConstantNode c1 = new ConstantNode(1);
        System.out.println("evaluate check: " + (c1.evaluate(new SymbolTable())
                == 1 ? "PASS" : "FAIL - supposed to be false"));
        System.out.println("getNodeType check: " + (c1.getNodeType() ==
                NodeType.Constant ? "PASS" : "FAIL - supposed to be false"));
        System.out.println("getPrecedence check: " + (c1.getPrecedence() == 3
                ? "PASS" : "FAIL - supposed to be false"));
        System.out.println("isOperation check: " + (c1.isOperation() == false ?
                "PASS" : "FAIL - supposed to be false"));
        System.out.println("toString checks: check manually. Should all be \"1\"");
        System.out.println(c1.toInfixString());
        System.out.println(c1.toPrefixString());
        System.out.println(c1.toPostfixString());
    }
}
