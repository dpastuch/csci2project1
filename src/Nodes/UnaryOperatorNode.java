package Nodes;

import Util.SymbolTable;

/**
 * Framework for a node that uses only one child node.
 */
public abstract class UnaryOperatorNode implements MerpNode {

    protected MerpNode child;
    protected String operator;
    protected Precedence precendence;
    /**
     * Create a new unary operator node.
     * @param child Child node
     * @param precedence Precedence
     * @param operator Arithmetic operator
     */
    public UnaryOperatorNode(MerpNode child, Precedence precedence,
                             java.lang.String operator) {
        this.child = child;
        this.operator = operator;
        this.precendence = precedence;
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
     * Evaulate this node.
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        return 0;
    }

    /**
     * Get the precedence of this node.
     * @return The precedence of [ this ]
     */
    @Override
    public int getPrecedence() {
        return precendence.getPrecedence();
    }

    /**
     * Get this node's type.
     * @return Type of node
     */
    @Override
    public NodeType getNodeType() {
        return NodeType.UnaryOperation;
    }

    /**
     * Convert this node to an infix string.
     * @return node in string format
     */
    @Override
    public String toInfixString() {
        return "(" + operator + " " + child.toInfixString() + ")";
    }

    /**
     * Convert this node to a postfix string.
     * @return node in string format
     */
    @Override
    public String toPostfixString() {
        return child.toPostfixString() + " " + operator;
    }

    /**
     * Convert this node to an prefix string.
     * @return node in string format
     */
    @Override
    public String toPrefixString() {
        return operator + " " + child.toPrefixString();
    }

    /**
     * Set this node's child.
     * @param child child node
     */
    public void setChild(MerpNode child) {
        this.child = child;
    }
}