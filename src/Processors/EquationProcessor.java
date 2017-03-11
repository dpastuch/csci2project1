package Processors;

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
        ArrayList<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
        if(tokenList.get(0).equals("while(")) {
            whileLoop(eq.substring(6));
        }
        else if(tokenList.get(0).equals("if(")) {
            ifStatement(eq.substring(3));
        }
        else {
            evalStatement(eq);
        }

    }

    private void assignVar(String var, int val) {
        symbolTable.put(var, val);
    }

    private void printVars() {
        symbolTable.dump();
    }

    private void print(String tokenString) {
        String tokens = tokenString.trim();
        String[] tokenList = tokens.split(" ");
        ArrayList<String> tokenList2 = new ArrayList<>(Arrays.asList(tokenList));
        System.out.println(evaluate(tokenList2));
    }

    private void ifStatement(String tokenString) {
        String tokens = tokenString.trim();
        String[] tokenList = tokens.split(",");
        ArrayList<String> tokenList2 = new ArrayList<>(Arrays.asList(tokenList));
        if(evalStatement(tokenList2.get(0)) == 1) {
            evalStatement(tokenList2.get(1));
        }
        else {
            evalStatement(tokenList2.get(2));
        }
    }

    private void whileLoop(String tokenString) {
        String tokens = tokenString.trim();
        String[] tokenList = tokens.split(";");
        ArrayList<String> tokenList2 = new ArrayList<>(Arrays.asList(tokenList));
        while(evalStatement(tokenString) == 1) {
            for(String t : tokenList2) {
                evalStatement(t);
            }
        }
    }

    private int evaluate(String tokens) {
        String[] tokenArray = tokens.split(" ");
        ArrayList<String> tokenList = new ArrayList<>(Arrays.asList(tokenArray));
        processor.constructTree(tokenList);
        return processor.evaluateTree(symbolTable);
    }

    private int evaluate(ArrayList<String> tokenList) {
        processor.constructTree(tokenList);
        return processor.evaluateTree(symbolTable);
    }

    private int evalStatement(String tokens) {
        String[] tokenArray = tokens.split(" ");
        ArrayList<String> tokenList = new ArrayList<>(Arrays.asList(tokenArray));
            if (tokenList.get(0).equals("print(")) {
                print(tokens.substring(6));
            }
            else if (tokenList.get(0).equals("printVars()")) {
                printVars();
            }
            else if(tokenList.size() > 2) {
                if (tokenList.get(1).equals("=")) {
                    assignVar(tokenList.get(0), evaluate(tokenList.get(2)));
                }
            }
            else {
                return evaluate(tokenList);
            }
            return 0;
    }
}
