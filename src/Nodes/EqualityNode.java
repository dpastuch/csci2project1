package Nodes;

import Util.SymbolTable;

/**
 * Node that checks for equality of its children.
 *
 * @author dmp6637 (David Pastuch)
 */
public class EqualityNode extends BooleanOperatorNode {

    /**
     * Create a new equality node.
     * @param left Left node
     * @param right right node
     */
    public EqualityNode(MerpNode left, MerpNode right) {
        super(left, right, "==");
    }

    /**
     * Evaulate this node.
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        if(leftChild.evaluate(symbolTable) ==
                rightChild.evaluate(symbolTable)) {
            return 1;
        }
        return 0;
    }
}