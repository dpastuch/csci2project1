package Processors;

import java.lang.reflect.Array;
import java.util.ArrayList;
import Util.SymbolTable;

import java.util.Arrays;

/**
 * Node that calculates an absolute value.
 *
 * @author dmp6637 (David Pastuch)
 */
public class EquationProcessor {

    ArrayList<String> equations;
    MerpProcessor processor;
    SymbolTable symbolTable;
    /**
     * Create a new equation processor.
     * @param equations ArrayList of equations
     * @param processor Merp processor to use
     */
    public EquationProcessor(ArrayList<String> equations,
                             MerpProcessor processor) {
        this.equations = equations;
        this.processor = processor;
        this.symbolTable = new SymbolTable();
    }

    public void processEquations() {
        for(String e : equations) {
            processEquation(e);
        }
    }

    private void processEquation(String eq) {
        String[] tokens = eq.split(" ");
        ArrayList<String> tokenList = new ArrayList(Arrays.asList(tokens));
        if(tokenList.get(1) == "=") {
            assignVar(tokenList.get(0), evaluate(tokenList));
        }
    }

    private void assignVar(String var, int val) {
        symbolTable.put(var, val);
    }

    private void printVars() {
        symbolTable.dump();
    }

    private void print(ArrayList<String> tokenList) {
        System.out.println(evaluate(tokenList));
    }

    private void ifStatement() {

    }

    private void whileLoop(String tokens) {
        String[] tokenList = tokens.split(";");
        ArrayList<String> tokenList2 = new ArrayList(Arrays.asList(tokens));
        String[] tokens2 = tokenList2.get(0).split(" ");
        ArrayList<String> tokenList3 = new ArrayList(Arrays.asList(tokens2));
        while(evaluate(tokenList3) == 1) {
            for(String t : tokenList3) {

            }
        }
    }

    private int evaluate(ArrayList<String> tokenList) {
        processor.constructTree(tokenList);
        return processor.evaluateTree(symbolTable);
    }
}
