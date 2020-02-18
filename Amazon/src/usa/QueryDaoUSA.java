package usa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import france.JdbcConnectionFR;
import gui.Display;

public class QueryDaoUSA{
	private static String cont[][] = new String[10][2];
	private static String col[] = { "Prenom", "Salaires" };
	
	public QueryDaoUSA() {
		
		
		
		
		//guiQuery();
		//selectPayslip();
		
	}
	
	
	
	public void selectPayslip() {
		try {
			String selectQuery = "SELECT firstname, salary FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY salary DESC LIMIT 10;";                
			String[] tab = new String[10];
	
			Connection dbConnection = JdbcConnectionUSA.getConnection();
			Statement state = dbConnection.createStatement();
		
			
			ResultSet result = state.executeQuery(selectQuery);
			ResultSetMetaData resultMeta = result.getMetaData();

			 
			System.out.println("\n*************************************************************************************************");
			for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
		    	 System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
			}    	 
			System.out.println("\n*************************************************************************************************");
		         
		    while(result.next()){         
		    	 for(int i = 1; i <= resultMeta.getColumnCount(); i++) {		    		 
		    		 System.out.print("\t" + result.getObject(i).toString() + "\t |");
		    	 } 
		    	 System.out.println("\n---------------------------------------------------------------------------------");

		    }

		    result.close();
		    state.close();
		         
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	
	}
	
	public String[][] query1() {
		try {
			String selectQuery = "SELECT firstname, salary FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY salary DESC LIMIT 10;";                
			
			Connection dbConnection = JdbcConnectionUSA.getConnection();
			Statement state = dbConnection.createStatement();
					
			ResultSet result = state.executeQuery(selectQuery);
			
			 int i = 0;
		      while (result.next()) {		    	
		        int id = result.getInt("salary");
		        String prenom = result.getString("firstname");
		        cont[i][0] = Integer.toString(id);
		        cont[i][1] = prenom;
		        
		        i++;      
		      }
		 	      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		
		return cont;
	}
	
	public static int query2() {	
		int sum = 0;
		try {
			String selectQuery = "SELECT SUM(paid_leave) FROM payslip;";                
		
			Connection dbConnection = JdbcConnectionUSA.getConnection();
			Statement state = dbConnection.createStatement();
			
			ResultSet result = state.executeQuery(selectQuery);
			ResultSetMetaData resultMeta = result.getMetaData();

			System.out.println("\n*************************************************************************************************");
			for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
		    	 System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
			}    	 
			System.out.println("\n*************************************************************************************************");
		         
		    while(result.next()){         
		    	 for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
		    		 sum = Integer.parseInt(result.getObject(i).toString());		    				 
		    		 System.out.print("\t" + sum + "\t |");
		    	 } 
		    	 System.out.println("\n---------------------------------------------------------------------------------");
		    }

		    result.close();
		    state.close();
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return sum;
	}

	
	// Requ�te 3 : Affichage croissant des 5 salaires les plus gros en fonction des plus gros cong�s.
	public static String[][] query3() {
		String[][] querytab3 = new String[5][3];
		try {
			String selectQuery = "SELECT firstname, salary, paid_leave FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY paid_leave DESC, salary DESC LIMIT 5;";                

			Connection dbConnection = JdbcConnectionUSA.getConnection();
			Statement state = dbConnection.createStatement();
			ResultSet result = state.executeQuery(selectQuery);
			
			int i=0;
		    while(result.next()){ 
		    	 int salaire = result.getInt("salary");
		    	 int paidLeave = result.getInt("paid_leave");
		    	 String prenom = result.getString("firstname");
		    	 querytab3[i][0] = prenom;
		    	 querytab3[i][1] = Integer.toString(salaire);
		    	 querytab3[i][2] = Integer.toString(paidLeave);	    		 
		    	 i++;
		   	    }
		    
		    result.close();
		    state.close();
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return querytab3;
	}
	
	// Affichage croissant des plus gros salaires avec les bonus compris
		public static String[][] query4() {
			String[][] querytab3 = new String[100][3];
			try {
				String selectQuery = "SELECT firstname, salary, bonus FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY salary DESC;";                
			
				Connection dbConnection = JdbcConnectionUSA.getConnection();
				Statement state = dbConnection.createStatement();
				ResultSet result = state.executeQuery(selectQuery);
				
				int i=0;
			    while(result.next()){ 
			    	 int salaire = result.getInt("salary");
			    	 int bonus = result.getInt("bonus");
			    	 String prenom = result.getString("firstname");
			    	 salaire =salaire + (salaire * bonus)/100;
			    	 querytab3[i][0] = prenom;
			    	 querytab3[i][1] = Integer.toString(salaire);
			    	 querytab3[i][2] = Integer.toString(bonus);	    		 
			    	 i++;
			   	    }
			    
			    result.close();
			    state.close();
			      
			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return querytab3;
		}
	
		
	// LA YA UN AFFICHAGE CROISSANT EN FONCTION DES CONGES
	public static String[][] query5() {
		String[][] querytab3 = new String[100][3];
		try {
			String selectQuery = "SELECT firstname, bonus, paid_leave FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY paid_leave ASC;";                

			Connection dbConnection = JdbcConnectionUSA.getConnection();
			Statement state = dbConnection.createStatement();
			ResultSet result = state.executeQuery(selectQuery);
			
			int i=0;
		    while(result.next()){ 
		    	 int bonus = result.getInt("bonus");
		    	 int paidLeave = result.getInt("paid_leave");
		    	 String prenom = result.getString("firstname");
		    	 querytab3[i][0] = prenom;
		    	 querytab3[i][1] = Integer.toString(bonus);
		    	 querytab3[i][2] = Integer.toString(paidLeave);	    		 
		    	 i++;
		   	    }
		    
		    result.close();
		    state.close();
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return querytab3;
	}
	
	
	public static int query6() {
		int averageSalary = 0;
		int allSalary = 0;
		try {
			String selectQuery = "SELECT salary FROM payslip;";                

			Connection dbConnection = JdbcConnectionUSA.getConnection();
			Statement state = dbConnection.createStatement();
			ResultSet result = state.executeQuery(selectQuery);
			
			int i=0;
		    while(result.next()){ 
		    	 int salary = result.getInt("salary");
		    	 allSalary += salary;
		    	 i++;
		    	 averageSalary = allSalary/i;
		    }
		    	
		    System.out.println(averageSalary);

		    result.close();
		    state.close();
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return averageSalary;
	}

	

	public static String[] getCol() {
		return col;
	}

	public static void setCol(String[] col) {
		QueryDaoUSA.col = col;
	}

	
	
}
