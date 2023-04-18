/**
 * Instructions:
 * 1) Please fill in your details in this documentation section
 * 2) Remember to comment your codes
 * 3) Name your java file as myshell_student_id.java (for example myshell_12345678.java)
 * 4) Give a short description of each command that you have implemented in the description section
 * 5) NO marks will be awarded if you fail to follow the instructions
 * Details:
 * 1) Author Name: Skeleton (to be replaced by your name)
 * 2) Student ID: 12345678 (to be replaced by your student id)
 * Description (Functionalities):
 * 1) exit: 
 * 2) hist:
 * 3) (please complete this section with respect to the commands that you have implemented)
 */

import java.io.*;
import java.util.ArrayList;

public class myshell_14085468 {
	

    
	public static void main(String[] args) throws IOException {

        //Use commandLine to store the command and the argument(s).
        String commandLine;

        //Read and buffered the command and the argument(s).
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        //Just a banner
        System.out.println("My Shell Version 0.01");
        
    	//Array to store user inputs
        ArrayList commandHistory = new ArrayList();
        
        ArrayList commandInvalid = new ArrayList();
       
        commandInvalid.add("about");
        commandInvalid.add("hist");
        commandInvalid.add("notepad");

        //Continue to loop until "exit" is entered.
        //Although it is uncommon for a normal application, it is normal for a shell.
        while (true) {
            //Print the console line.
            //Remember to replace "student_id" with your student number.
            System.out.print("14085468> ");

            //Read the input from user.
            commandLine = console.readLine();
  
            //Split the input into command and parameters.
            //commandParams is a list that is pre-created to store all the parameters.
            //commandSplit is a string array that is used to store the command and the parameters after spliting them.
            ArrayList commandParams = new ArrayList();

            String[] commandSplit = commandLine.split(" ");

            //Check to see if there is any parameter.
            //If size of commandSplit is larger than one that means the user has included some parameters in the input.
             if (commandSplit.length > 1) {
                //Add the parameters into commandParams
                for (int i = 1; i < commandSplit.length; i++) {
                    commandParams.add(commandSplit[i]);
                }
            }


            //Reprint the console line if user just pressed "enter" without any command.
            if (commandSplit[0].equals("")) {
                continue;
            }

            //Exit the console when "exit" is entered.
            if (commandSplit[0].equals("exit")) {
                System.exit(0);
            }
            
            //Print about details
            if (commandSplit[0].equals("about")) {
                System.out.println(
                		"Author: Aye Chan Zay Hta\n"
                		+ "Version: 0.01");
                commandHistory.add(commandLine);
                
                continue;
            }
            
            //Open notepad
            if (commandSplit[0].equals("notepad")) {
                System.out.println(
                		"Starting notepad");
                ProcessBuilder pb = new ProcessBuilder("notepad.exe");
                pb.start();
                
                commandHistory.add(commandLine);
                continue;
            }
            
          //Example of a built-in function that can be used to trace the command history. 
            if (commandSplit[0].equals("hist")) {
                if (commandParams.size() < 1) {
                    System.out.println("Error : Not enough input argument(s). Please enter hist -h for help.");
                } else {
                    //Process based on the number of parameters attached to the command.
                    
                	//Help
                	if (commandParams.get(0).equals("-h")) {
                        System.out.println("hist -l [int] : Retrieve the last [int] commands entered by the user.");
                        System.out.println("hist -c : Clear the command history.");
                        
                        if(commandParams.size()>1){
                        	for(int i=1;i<commandParams.size();i++){
                        		
                        		//Help
                        		if (commandParams.get(i).equals("-h")) {
                                    System.out.println("hist -l [int] : Retrieve the last [int] commands entered by the user.");
                                    System.out.println("hist -c : Clear the command history.");
                        		}
                        		
                        		//List command history
                        		else if (commandParams.get(i).equals("-l")){
                        			i++;
                        	    	try{
                                        int x = Integer.parseInt(commandParams.get(i).toString());
                                        
                                        
                                        if(x>commandHistory.size()){
                                        	System.out.println("No command history at this index");
                                        }
                                        
                                        else{
                                        	System.out.println(commandHistory.get(x));
                                        }
                                        
                                      
                                    	}catch (Exception ex){
                                    		System.out.println("Invalid Number");
                                    		i--;
                                    	}
                        		}
                        		
                        		//Clear command history
                        		else if (commandParams.get(i).equals("-c")){
                        			commandHistory.clear();
                        			System.out.println("Command history has been deleted.");
                        		}
                        	}
                        	//To not count hist -c in command history after clearing
                        	   if (commandParams.contains("-c")){
                                   continue;
                        	   }
                        }
                    }
                    
                    //Clear command history
                    if (commandParams.get(0).equals("-c")) {
                    	commandHistory.clear();
                        System.out.println("Command history has been deleted.");
                        if(commandParams.size()>1){
                        	for(int i=1;i<commandParams.size();i++){
                        		
                        		//Help
                        		if (commandParams.get(i).equals("-h")) {
                                    System.out.println("hist -l [int] : Retrieve the last [int] commands entered by the user.");
                                    System.out.println("hist -c : Clear the command history.");
                        		}
                        		
                        		//List command history
                        		else if(commandParams.get(i).equals("-l")){
                        			i++;
                        			try{
                        				int x= Integer.parseInt(commandParams.get(i).toString());
                        				
                        				if(x>commandHistory.size()){
                        					System.out.println("No command history at this index");
                        				}
                        				else{
                        					System.out.println(commandHistory.get(x));
                        				}
                        				
                        			}catch (Exception ex){
                        				System.out.println("Invalid Number");
                        				i--;
                        			}
                        		}
                        		
                        		//Clear command history 
                        		else if(commandParams.get(i).equals("-c")){
                        			commandHistory.clear();
                        			System.out.println("Command history has been deleted.");
                        		} 
                        	}
                        	
                        	
                        }
                      //To not count hist -c in command history after clearing
                        if (commandParams.contains("-c")){
                            continue;
                 	   }
                        
                    }
                    
                    //List command history
                    if (commandParams.get(0).equals("-l")) {
                    		for(int i=0;i<commandParams.size();i++){
                    			
                    			//Help
                    			if(commandParams.get(i).equals("-h")){
                    				System.out.println("hist -l [int] : Retrieve the last [int] commands entered by the user.");
                                    System.out.println("hist -c : Clear the command history.");
                    			}
                    			
                    			else if(commandParams.get(i).equals("-l")){
                    				try{
                    				i++;
                    				int x= Integer.parseInt(commandParams.get(i).toString());
                    				
                    				if(x>commandHistory.size()){
                    					System.out.println("No command history at this index");
                    				}
                    				else{
                    					System.out.println(commandHistory.get(x));
                    				}
                    				}catch(Exception ex){
                    					System.out.println("Invalid Number");
                    					i--;
                    				}
                    			}	
                    		}
                    		//To not count hist -c in command history after clearing
                    		if (commandParams.contains("-c")){
                                continue;
                     	   }
                    	
                    }
                }
            }
            
            //If command is invalid
            if(!commandInvalid.contains(commandSplit[0]) ){
            	System.out.println("Invalid Command!");
            }
            
            //Store input into commandHistory arraylist
            commandHistory.add(commandLine);
            
            
        }
        
        
    }
}
