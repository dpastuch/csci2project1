package Nodes;

import Util.SymbolTable;

/**
 * A node that represents a variable.
 *
 * @author dmp6637 (David Pastuch)
 */
public class VariableNode implements MerpNode{

    private String name;

    /**
     * Create a new constant node.
     * @param name Variable name
     */
    public VariableNode(String name) {
        this.name = name;
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
     * @return The integer value of this variable
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        return symbolTable.get(name);
    }

    /**
     * Get the precedence of this node.
     * @return The precedence of constant
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
        return NodeType.Variable;
    }

    /**
     * Convert this node to an infix string.
     * @return node in string format
     */
    @Override
    public String toInfixString() {
        return name;
    }

    /**
     * Convert this node to a postfix string.
     * @return node in string format
     */
    @Override
    public String toPostfixString() {
        return name;
    }

    /**
     * Convert this node to an prefix string.
     * @return node in string format
     */
    @Override
    public String toPrefixString() {
        return name;
    }

    /**
     * Testing statements
     * @param args none
     */
    public static void main(String[] args) {
        VariableNode v1 = new VariableNode("x");
        SymbolTable s = new SymbolTable();
        s.put("x", 5);
        System.out.println("evaluate check: " + (v1.evaluate(s)
                == 5 ? "PASS" : "FAIL - supposed to be false"));
        System.out.println("getNodeType check: " + (v1.getNodeType() ==
                NodeType.Variable ? "PASS" : "FAIL - supposed to be false"));
        System.out.println("getPrecedence check: " + (v1.getPrecedence() == 3
                ? "PASS" : "FAIL - supposed to be false"));
        System.out.println("isOperation check: " + (v1.isOperation() == false ?
                "PASS" : "FAIL - supposed to be false"));
        System.out.println("toString checks: check manually. Should all be \"x\"");
        System.out.println(v1.toInfixString());
        System.out.println(v1.toPrefixString());
        System.out.println(v1.toPostfixString());
    }
}