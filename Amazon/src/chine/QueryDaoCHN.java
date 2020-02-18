package chine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




	public class QueryDaoCHN {
	
		
	
	private static String csvFile = "Amazon_CHINE.csv";
    private static String line = "";
    private static String cvsSplitBy = ";";
    private static String[][] tabPaySlip = new String[250][250];
    public static int sizeTab = 0;
		
	
		public QueryDaoCHN() {
			RecupTab();
		}
			
		
		public void ajouter (PaySlipCHN payslip, String separator ,String fileName) {
			
			    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))){
			        
			    	//We write and we put the separator		
			    	
			    	writer.append(payslip.getId());
			    	writer.append(separator);
			                
			    	writer.append(payslip.getName());
			    	writer.append(separator);
			                
			    	writer.append(payslip.getFirstname());
			    	writer.append(separator);
			                
			    	writer.append(payslip.getAge());
			    	writer.append(separator);
			                
			    	writer.append(payslip.getSalary());
			    	writer.append(separator);
			                
			    	writer.append(payslip.getVacation());
			    	writer.append(separator);
			                
			    	writer.append(payslip.getBonus());
			    	writer.append(separator);
			                        
			    	writer.close();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			
		}
	
	
	public void CSVReader() {
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
	
	            while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
	            	//On stocke dans notre tableau nos diff�rents �l�ments gra�e � notre s�parateur
	                String[]payslip = line.split(cvsSplitBy);
	                
	                System.out.println("payslip[id= " + payslip[0]+ " , name=" + payslip[1]+ "]");
	
	            }
	
	        } catch (IOException e) {
	            e.printStackTrace();
	    }
	}
	
	public void recupCSV() {
		
	    String payslip2[][] = new String [250][250];
	    sizeTab = 0;
	  
	    
	    try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
		   	 try {
				reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}/*On lit la premi�re ligne car c'est les infos des colonnes*/
		        
				
				while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
		           //On stocke dans notre tableau nos diff�rents �l�ments grace � notre s�parateur
		            String[]payslip = line.split(cvsSplitBy);
		            int j=0;
		            
		            while(j != 7) {
		            	payslip2[sizeTab][j]=payslip[j];
		            	j++;
		            }
		            sizeTab++;
				}
				
				System.out.println(payslip2[4][1]);
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String[][] RecupTab() {
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
		   	 try {
				reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}/*On lit la premi�re ligne car c'est les infos des colonnes*/
		        
				
				while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
		           //On stocke dans notre tableau nos diff�rents �l�ments gra�e � notre s�parateur
		            String[]payslip = line.split(cvsSplitBy);
		            int j=0;
		            
		            while(j != 7) {
		            	tabPaySlip[sizeTab][j]=payslip[j];
		            	j++;
		            }
		            sizeTab++;
				}
		
		
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		return tabPaySlip;
		
}
	/*Requete 1*/
	public void highterSalarya() {/*On r�cup�re le plus haut salaire*/
		int max = 0;
	    String firstname = null;
	    int cpt = 0;
	    int indice =0;
	    int [] hightersalary = new int [250];
	    String[]name = new String [250];
	    int[]salary = new int [250];
	    
		int debut=0;
	    String col[] = { "Salaires" , "prenom"};
		String cont[][] = new String[10][2];
	
	    
	            for(int i = 0; i<sizeTab; i++) {
	            name[indice]=tabPaySlip[i][2];
	            salary[indice]=Integer.parseInt(tabPaySlip[i][4]);
	            
	            indice++;
	            
	            //On recherche le plus gros salaire
		             max = Integer.parseInt(tabPaySlip[i][4]); //converse Sting tab in Int tab 
		             hightersalary [cpt] = max;//
		             Arrays.sort(hightersalary);// sort tab 
		            
	                        
	
			}
	   
	        for(int i = hightersalary.length-1; i>hightersalary.length-10; i--) {//on read the ten highter salarys 
	       	 for(int j=0; j < salary.length; j++) {
	       		 if(hightersalary[i]==salary[j]) {
	       			 firstname = name[j];	 
	       		 } 
	       	}
	       
			cont[debut][0] = hightersalary[i] + "";
	        cont[debut][1] = firstname;
	        debut++;
	        System.out.println("Highter salary : "+ hightersalary[i] + ", Firstname : " + firstname );
	        }	
	    
	   
		
	}
	
	public String[][] query1() {/*On r�cup�re le plus haut salaire*/

	    int max = 0;
	    String firstname = null;
	    int cpt = 0;
	    int indice =0;
	    int [] hightersalary = new int [250];
	    String[]name = new String [250];
	    int[]salary = new int [250];
	    
		int debut=0;
	    String col[] = { "Salaires" , "prenom"};
		String cont[][] = new String[10][2];
	
	    
	            for(int i = 0; i<sizeTab; i++) {
	            name[indice]=tabPaySlip[i][2];
	            salary[indice]=Integer.parseInt(tabPaySlip[i][4]);
	            
	            indice++;
	            
	            //On recherche le plus gros salaire
		             max = Integer.parseInt(tabPaySlip[i][4]); //converse Sting tab in Int tab 
		             hightersalary [cpt] = max;//
		             Arrays.sort(hightersalary);// sort tab 
		            
	                        
	
			}
	   
	        for(int i = hightersalary.length-1; i>=hightersalary.length-10; i--) {//on read the ten highter salarys 
	       	 for(int j=0; j < salary.length; j++) {
	       		 if(hightersalary[i]==salary[j]) {
	       			 firstname = name[j];	 
	       		 } 
	       	}
	       
			cont[debut][0] = hightersalary[i] + "";
	        cont[debut][1] = firstname;
	        debut++;
	        //System.out.println("Highter salary : "+ hightersalary[i] + ", Firstname : " + firstname );
	        }	
	    
	   
		return cont;
	}
	public static int query2() {
		int paidLeave=0;
	    int sumPaidLeave=0;
	    for(int i=0; i<sizeTab; i++) {
	    	paidLeave = Integer.parseInt(tabPaySlip[i][6]);
	    	sumPaidLeave += paidLeave;
	    }
		
	
		return sumPaidLeave;
	}
	public void selectPayslip() {
		String csvFile = "Amazon_CHINE.csv";
	    String line = "";
	    String cvsSplitBy = ";";
	    int max = 0;
	    int cpt = 0;
	    int [] hightersalary = new int [250];
	    int []salary = new int [100];
	    int debut=0;
	   
	    String col[] = { "Salaires" , "prenom"};
		String cont[][] = new String[10][3];
	
	
	    try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
	   	 reader.readLine();/*On lit la premi�re ligne car c'est les infos des colonnes*/
	        while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
	           //On stocke dans notre tableau nos diff�rents �l�ments gra�e � notre s�parateur
	            String[]payslip = line.split(cvsSplitBy);
	
	            //On recherche le plus gros salaire
	          if(payslip[4]!=" salaire") {
		             max = Integer.parseInt(payslip[4]); //converse Sting tab in Int tab 
		             hightersalary [cpt] = max;//
		             Arrays.sort(hightersalary);// sort tab 
		            
	            }              
	
	        }
	        for(int tmp = hightersalary.length-1; tmp>=hightersalary.length-10; tmp--) {//on read the ten highter salarys 
	        //System.out.println(tmp);
	        	
	        	//salary[debut] = hightersalary[tmp];
	        	//debut++;
	        System.out.println("Highter salaryss : " +hightersalary[tmp] );
	        cont[debut][0] = hightersalary[tmp] + "";
	        cont[debut][1] = "prenom";
	        debut++;
	        }
	        
	        
	 //       int i = 0;
		 //     while (i<=10) {
		        //int id = result.getInt("salary");
		//        //String prenom = result.getString("firstname");
		  //      cont[i][0] = salary[i] + "";
		   //     cont[i][1] = "prenom";
		 //       i++;
		  //    }
	        
	         
	          DefaultTableModel model = new DefaultTableModel(cont,col);
		      JTable table = new JTable(model);
		      table.setShowGrid(true);
		      table.setShowVerticalLines(true);
		      JFrame frame = new JFrame("Affichage JTable");
		      JPanel panel = new JPanel();
		      JScrollPane pane = new JScrollPane(table);
		      panel.add(pane);
		      frame.add(panel);
		      frame.setSize(500, 250);
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      frame.setVisible(true);
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    
	
	}
		
		
	}
	/*Requ�te 2*/
	public void sumPaidLeave() {
		
	    int paidLeave=0;
	    int sumPaidLeave=0;
	    for(int i=0; i<sizeTab; i++) {
	    	paidLeave = Integer.parseInt(tabPaySlip[i][6]);
	    	sumPaidLeave += paidLeave;
	    }
		
	}
	/*Requ�te 3*/
	public static String[][] query3() {
		  	int paidLeave = 0, paidLeaveMax = 0;
		    int salary = 0, salaryMax = 0;
		    int tmp = 0;
		    int[] tabPaidLeave = new int[250];
		    int[] id = new int[250];
		    String[][] querytab3 = new String[5][3];
		    HashMap<Integer,Integer> mapPaidLeave = new HashMap<Integer,Integer>();
		    for(int k=0; k<sizeTab; k++) {/*we shearch the smallest paidleave*/
		    	paidLeave = Integer.parseInt(tabPaySlip[k][6]);
		    	if(paidLeave > paidLeaveMax) {
		    		paidLeaveMax = paidLeave;
		    	}
		    }
		    for(int j=0; j<sizeTab; j++) {/*we shearch the smallest paidleave*/
				salary = Integer.parseInt(tabPaySlip[j][4]);
				paidLeave = Integer.parseInt(tabPaySlip[j][6]);
				if(paidLeave == paidLeaveMax) {
					if(salary > salaryMax) {
						id[tmp] = j;
						tabPaidLeave[tmp] = salary;
						salaryMax = salary;
						tmp++;
					}
				}
			}           
			for(int i=tmp; i>tmp-6; i--) {
				 querytab3[i][0] = tabPaySlip[id[i]][2];//pr�nom
		    	 querytab3[i][1] = tabPaySlip[id[i]][4];//salaire
		    	 querytab3[i][2] = tabPaySlip[id[i]][6];//paidLeave	    		 
		    	 i++;
				/*we post the 5 biggest salary with max paid leave */
				System.out.println("salarywithpaidLeave");
				System.out.println("id : " + tabPaySlip[id[i]][0] + " salaire :" + tabPaySlip[id[i]][4]);
			}
			System.out.println("--------------------------------------------");
		
		return querytab3;
		
	}
	public void salarywithpaidLeave() {
	    
	    
	    int paidLeave = 0, paidLeaveMax = 0;
	    int salary = 0, salaryMax = 0;
	    int tmp = 0;
	    int[] tabPaidLeave = new int[250];
	    int[] id = new int[250];
	    HashMap<Integer,Integer> mapPaidLeave = new HashMap<Integer,Integer>();
	    for(int k=0; k<sizeTab; k++) {/*we shearch the smallest paidleave*/
	    	paidLeave = Integer.parseInt(tabPaySlip[k][6]);
	    	if(paidLeave > paidLeaveMax) {
	    		paidLeaveMax = paidLeave;
	    	}
	    }
	    for(int j=0; j<sizeTab; j++) {/*we shearch the smallest paidleave*/
			salary = Integer.parseInt(tabPaySlip[j][4]);
			paidLeave = Integer.parseInt(tabPaySlip[j][6]);
			if(paidLeave == paidLeaveMax) {
				if(salary > salaryMax) {
					id[tmp] = j;
					tabPaidLeave[tmp] = salary;
					salaryMax = salary;
					tmp++;
				}
			}
		}           
		for(int i=tmp; i>tmp-6; i--) {
			/*we post the 5 biggest salary with max paid leave */
			System.out.println("salarywithpaidLeave");
			System.out.println("id : " + tabPaySlip[id[i]][0] + " salaire :" + tabPaySlip[id[i]][4]);
		}
		System.out.println("--------------------------------------------");
	}
	/*Requ�te 4 */
	public static String[][] query4() {
		
		 	int salary = 0, salaryBonus = 0;
		    int bonus = 0;
		    int[] id = new int[250];
		    String[] tabSalaryBonus = new String[250];
		    int i = 0, salaryMax = 0;
		    String[][] querytab3 = new String[100][3];
		    HashMap<Integer,Integer> mapSalaryBonus= new HashMap<Integer,Integer>(); 
		    
				for(int k=0; k<sizeTab; k++) {/*we shearch the smallest paidleave*/
					salary = Integer.parseInt(tabPaySlip[k][4]);
					bonus = Integer.parseInt(tabPaySlip[k][5]);
					salaryBonus = salary +(salary * bonus)/100;/*We add bonus in percent*/
					mapSalaryBonus.put(k, salaryBonus);
				}
				for (Map.Entry mapentry : mapSalaryBonus.entrySet()) {
					salary = (int) mapentry.getValue();
					if(salary>salaryMax) {/*We put best salary with bonus in tab and the id correspondding*/
						id[i] = (int) mapentry.getKey();
						tabSalaryBonus[i] = (String) mapentry.getValue();
						salaryMax = (int) mapentry.getValue();
						i++;
					}
				}		
				for(int j=i-1; j>i-4; j--) {
					querytab3[j][0] = tabPaySlip[id[j]][1];
			   	 	querytab3[j][1] = tabSalaryBonus[j];
			   	 	querytab3[j][2] = tabPaySlip[id[j]][5];
					/*We post the 3 best salary with bonus include */
					System.out.println("salaryBonus");
					System.out.println("Nom : " + tabPaySlip[id[j]][1] + " : salaire avec bonus: "+tabSalaryBonus[j]);
				}
				System.out.println("--------------------------------------------");
   	 	return querytab3;
	}
	public void salaryBonus() {	    
	    int salary = 0, salaryBonus = 0;
	    int bonus = 0;
	    int[] id = new int[250];
	    int[] tabSalaryBonus = new int[250];
	    int i = 0, salaryMax = 0;
	    HashMap<Integer,Integer> mapSalaryBonus= new HashMap<Integer,Integer>(); 
	    
			for(int k=0; k<sizeTab; k++) {/*we shearch the smallest paidleave*/
				salary = Integer.parseInt(tabPaySlip[k][4]);
				bonus = Integer.parseInt(tabPaySlip[k][5]);
				salaryBonus = salary +(salary * bonus)/100;/*We add bonus in percent*/
				mapSalaryBonus.put(k, salaryBonus);
			}
			for (Map.Entry mapentry : mapSalaryBonus.entrySet()) {
				salary = (int) mapentry.getValue();
				if(salary>salaryMax) {/*We put best salary with bonus in tab and the id correspondding*/
					id[i] = (int) mapentry.getKey();
					tabSalaryBonus[i] = (int) mapentry.getValue();
					salaryMax = (int) mapentry.getValue();
					i++;
				}
			}		
			for(int j=i; j>i-4; j--) {
				/*We post the 3 best salary with bonus include */
				System.out.println("salaryBonus");
				System.out.println("Nom : " + tabPaySlip[id[j]][1] + " : salaire avec bonus: "+tabSalaryBonus[j]);
			}
			System.out.println("--------------------------------------------");
	}
	/*Requ�te 5*/
	public void meduimSalary() {
	    int cmp = 0;
	    int sommeSalary=0, salary = 0;
	    int meduimSalary=0;
	    
		for(int k=0; k<sizeTab; k++) {/*we shearch the smallest paidleave*/
			salary = Integer.parseInt(tabPaySlip[k][4]);
			sommeSalary = sommeSalary + salary;
			cmp ++;
		}
	          
	       meduimSalary = sommeSalary/(cmp);
	       System.out.println("salaire moyen : " + meduimSalary);
	       System.out.println("-------------------------------------------");
	
	}
	/*Requ�te 9*/
	public void bestEmployees() {
	    int paidleaveMin=30, paidleave = 0;
		int	bonusMax = 0, bonus = 0;
		int salaryMax = 0, salary = 0;
		int tmp = 0;
		
	    
				for(int k=0; k<sizeTab; k++) {/*we shearch the smallest paidleave*/
					paidleave = Integer.parseInt(tabPaySlip[k][6]);
					if (paidleave < paidleaveMin) {
						paidleaveMin = paidleave;
					}
				}
				
				for(int m=0; m<sizeTab; m++) {/*we shearch the biggest bonus among the smallest paidleave*/
					bonus = Integer.parseInt(tabPaySlip[m][5]);
					if(Integer.parseInt(tabPaySlip[m][6])==paidleaveMin) {
						if(bonus > bonusMax) {
							bonusMax = bonus;
						}
					}
				}
				
				for(int l=0; l<sizeTab; l++) {/*we shearch the biggest salary among the biggest bonus and the smallest paidleave*/
					if((Integer.parseInt(tabPaySlip[l][5])==bonusMax) &&(Integer.parseInt(tabPaySlip[l][6])==paidleaveMin)) {
						salary = Integer.parseInt(tabPaySlip[l][4]);
						if(salary > salaryMax) {
							salaryMax = salary;
							tmp = l;
						}
					}
				}
				System.out.println("bestEmployees");
				System.out.println("The best employees : " +tabPaySlip[tmp][2]);
				System.out.println("--------------------------------------------");
	    
}
	public void minAgeSalary() {
	int minAge = 50, age = 0;
	int maxSalary = 0, salary = 0;
	int tmp = 0;
	
		for(int i=0; i<sizeTab; i++) {/*we shearch the smallest age*/
			age = Integer.parseInt(tabPaySlip[i][3]);
			if (age < minAge) {
				minAge = age;
			}
		}
		for(int j=0; j<sizeTab; j++) {/*we shearch the biggest salary*/
			salary = Integer.parseInt(tabPaySlip[j][4]);
			if(Integer.parseInt(tabPaySlip[j][3])==minAge) {
			if (salary > maxSalary) {
				maxSalary = salary;
				tmp = j;
			}
		}
	}
		System.out.println("minAgeSalary");
		System.out.println("Nom : " +tabPaySlip[tmp][1] + "Prenom : " +tabPaySlip[tmp][2]);
		System.out.println("--------------------------------------------");
}
	//requ�te 10
	public void bestAge() {
	int salary = 0;
	int age = 0;
	int sommeAge = 0, moyAge = 0;
	ArrayList<Salarier> ar = new ArrayList<Salarier>();
		for(int i=0; i<sizeTab; i++) {/*we shearch the smallest age*/
			salary = Integer.parseInt(tabPaySlip[i][4]);
			ar.add(new Salarier(i,salary));
		}
		//Trie tableau
	
		Collections.sort(ar, new Sortbyroll());//Trie l'arrayList en fonction du salaire et ajuste l'id correspondant
		for (int i=ar.size()-1; i>ar.size()-40; i--) { 
           System.out.println("id : " + ar.get(i).getId() + "salaire : " + ar.get(i).getSalary()); 
            age =Integer.parseInt(tabPaySlip[ar.get(i).getId()][3]);
            sommeAge += age;
            //System.out.println(sommeAge);
            moyAge = sommeAge/40;
            
    } 
		System.out.println("age moyen : " + moyAge);
	
	}
	public void ajouter(PaySlipCHN payslip) {
		// TODO Auto-generated method stub
		
	}
	}
