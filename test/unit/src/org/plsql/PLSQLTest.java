/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.plsql;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author doug
 */
public class PLSQLTest {
    
    public PLSQLTest() {
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

    @Test
    public void compilePLSQL() {
        PLSQLParser parser = null;
        CommonTree tree = null;
        try {
            //lexer splits input into tokens
            ANTLRStringStream input = new ANTLRStringStream(
                           "declare foo integer; Begin dbms_output.print_line('Hello World'); end;\n");
//            ANTLRStringStream input = new ANTLRStringStream(
//                            "select * from foobar where x=y and a='bbbb';");
            TokenStream tokens = new CommonTokenStream(new PLSQLLexer(input));

            parser = new PLSQLParser(tokens);
            PLSQLParser.plsql_block_return rtn = parser.plsql_block();
//            PLSQLParser.sql_statement_return rtn = parser.sql_statement();
            
            tree = (CommonTree) rtn.tree;
            
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
