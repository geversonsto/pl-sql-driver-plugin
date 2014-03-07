/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porcelli.parser.plsql;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

/**
 *
 * @author doug
 */
public class SimpleCompileTest {
    
    public SimpleCompileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void compilePLSQL() {
        try {
            //lexer splits input into tokens
            ANTLRStringStream input = new ANTLRStringStream(
                            "BEGIN dbms_output.print_line('Hello Workd');");
            TokenStream tokens = new CommonTokenStream(new PLSQLLexer(input));

            PLSQLParser parser = new PLSQLParser(tokens);
            
            PLSQLParser_PLSQL_DMLParser.expression_return rtn = parser.expression();
            
            CommonTree tree = (CommonTree) rtn.tree;
            
            printTree(tree);
            
        } catch (RecognitionException ex) {
            fail(ex.getLocalizedMessage());

        }
    }
    
	private void printTree(CommonTree ast) {
        print(ast, 0);
    }

    private void print(CommonTree tree, int level) {
        for (int i = 0; i < level; i++)
            System.out.print("--");

        //print node description: type code followed by token text
        System.out.println(" " + tree.getType() + " " + tree.getText());

        //print all children
        if (tree.getChildren() != null)
            for (Object ie : tree.getChildren()) {
                print((CommonTree) ie, level + 1);
            }
    }

}

