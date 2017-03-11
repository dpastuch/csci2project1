package Nodes;

import Util.SymbolTable;

/**
 * Node representing a binary operator.
 *
 * @author dmp6637 (David Pastuch)
 */
public abstract class BinaryOperatorNode implements MerpNode {

    protected MerpNode leftChild;
    protected String operator;
    protected Precedence precedence;
    protected MerpNode rightChild;

    /**
     * Create a new binary operator node.
     * @param leftChild Left child node
     * @param rightChild Right child node
     * @param precedence Precedence
     * @param operator Arithmetic operator
     */
    public BinaryOperatorNode(MerpNode leftChild, MerpNode rightChild,
                              Precedence precedence,
                              java.lang.String operator) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.precedence = precedence;
        this.operator = operator;
    }

    /**
     * Determine if this node is an operation node.
     * @return True if this is an operation node, otherwise false
     */
    @Override
    public boolean isOperation() {
        return true;
    }

    /**
     * Get this node's type.
     * @return Type of node
     */
    @Override
    public NodeType getNodeType() {
        return NodeType.BinaryOperation;
    }

    /**
     * Get the precendence of this node.
     * @return precedence
     */
    @Override
    public int getPrecedence() {
        return this.precedence.getPrecedence();
    }

    /**
     * Convert this node to an infix string.
     * @return node in string format
     */
    @Override
    public String toInfixString() {
        return ("(" + leftChild.toInfixString() + " " + operator + " " +
                rightChild.toInfixString() + ")");
    }

    /**
     * Convert this node to a postfix string.
     * @return node in string format
     */
    @Override
    public String toPostfixString() {
        return (leftChild.toPostfixString() + " " + rightChild.toPostfixString() + " " +
                 operator);
    }

    /**
     * Convert this node to an prefix string.
     * @return node in string format
     */
    @Override
    public String toPrefixString() {
        return (operator + " " + leftChild.toPrefixString() + " " +
                rightChild.toPrefixString());
    }

    /**
     * Sets the left child.
     * @param leftChild New left child
     */
    public void setLeftChild(MerpNode leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Sets the right child.
     * @param rightChild New right child
     */
    public void setRightChild(MerpNode rightChild) {
        this.rightChild = rightChild;
    }
}
