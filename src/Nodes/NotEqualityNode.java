package Nodes;

import Util.SymbolTable;

/**
 * Node that checks for inequality of its children.
 *
 * @author dmp6637 (David Pastuch)
 */
public class NotEqualityNode extends BooleanOperatorNode {

    /**
     * Create a new inequality node.
     * @param left Left node
     * @param right right node
     */
    public NotEqualityNode(MerpNode left, MerpNode right) {
        super(left, right, "!=");
    }

    /**
     * Evaulate this node.
     * @param symbolTable the symbol table to use for variable processing
     * @return The integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        if(leftChild.evaluate(symbolTable) !=
                rightChild.evaluate(symbolTable)) {
            return 1;
        }
        return 0;
    }
}