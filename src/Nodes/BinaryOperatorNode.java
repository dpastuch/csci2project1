package Nodes;

import Util.SymbolTable;

/**
 * Created by David on 3/5/2017.
 */
public class BinaryOperatorNode implements MerpNode {

    private int value;

    /**
     * Create a new constant node.
     * @param leftChild Left child node
     * @param rightChild Right child node
     * @param precedence Precedence
     * @param operator Arithmetic operator
     */
    public BinaryOperatorNode(MerpNode leftChild, MerpNode rightChild,
                              Precedence precedence,
                              java.lang.String operator) {
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
}
