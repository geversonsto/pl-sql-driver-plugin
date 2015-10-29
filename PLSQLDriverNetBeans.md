# Netbeans PL/SQL Driver #
The Netbeans Oracle PL/SQL Driver is a Netbeans _plugin_  that integrates with the Netbeans **SQL** components and provides the following functionality:

  * Call interface for executing **PL/SQL** code
    * Do not need to change **DELIMITER**
  * Support for _DBMS\_OUTPUT_
    * Displays in SQL _execution_ window
  * Parameter _substitution_
    * Set _parameter_ literal as well as _value_
    * Use special _${url}_ parameter to load **URL** contents into _value_
## To Use ##
  * Setup an Oracle JDBC connection in Netbeans _Database_
    * The PL/SQL Driver plugin looks for a configured Oracle connection on start
  * Download from Netbeans plugin site:
  * Install from Netbeans _Plugin_ window
  * Setup a PL/SQL Driver connection in Netbeans _Database_
    * Look for _PLSQL Wrapping Driver_
    * Use the _JDBC connection URL_ as per the previously setup Oracle connection
    * Use a different name for the connection
      * Netbeans stores connection persistence info under the name, using the same name will confuse Netbeans
    * Use the PL/SQL Driver connection as per any other JDBC connection
      * With the added value that you can directly input PL/SQL _blocks_
      * Or open a _.sql_ (or .pls) file containing PL/SQL and execute it.
      * Clicking the PL/SQL button on a SQL Editor toolbar will bring up the parameters dialog and you can add substitution parameters
  * Requires a 1.7 JVM
  * Works with Netbeans 7.2, 7.3, 7.4, 8.0
## Legal and Trademarks ##

  * Oracle is a registered trademark of Oracle Corporation.
  * PL/SQL is a trademark of Oracle Corporation.
  * Java is a trademark of Oracle Corporation.
  * ANTLR is a registered trademark of Terence Parr.
  * PLSQL grammar author is Patrick Higgins - GNU Lesser General Public License, version 2.1.