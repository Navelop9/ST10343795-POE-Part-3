
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @ST10343795 Navelo Princess Shivuri
 */
public class Login {

    /**
     * @param args the command line arguments
     */
   
    
    public boolean checkUserName(String userName){
        boolean underscore=false;
        for (int i=0;i<userName.length();i++){
            if ('_'==userName.charAt(i)){
                underscore=true;
            }
         }
        if (underscore==true && userName.length()<=5){
            return true;
        }
        else{
            return false;
        }
        
    }
     public boolean checkPassWordComplexity(String password){
         boolean cap=false;
         boolean number=false;
        boolean specialChar=false;
         for (int i=0;i<password.length();i++){
            if ((int)password.charAt(i)>=65 && (int)password.charAt(i)<=90 ){
                cap=true;
            }
            else if ((int)password.charAt(i)>=48 && (int)password.charAt(i)<=57){
                number=true;
            }
          else if(((int)password.charAt(i)>=33 && (int)password.charAt(i)<=47) || ((int)password.charAt(i)>=58 && (int)password.charAt(i)<=64) || ((int)password.charAt(i)>=91 && (int)password.charAt(i)<=96 || ((int)password.charAt(i)>=123 && (int)password.charAt(i)<=126))){
                specialChar=true;
            }
         }
         if (cap==true && number==true && specialChar==true && password.length()>=8){
             return true;
         }
         else{
             return false;
         }
         
     }
     
     public String registerUser(String username, String password){
       
         if(checkUserName( username)==false && checkPassWordComplexity(password)==true){
             return "The username is incorrectly formatted";
         }
         else if (checkPassWordComplexity(password)==false && checkUserName( username)==true ){
             return "The password does not meet the complexity requirements.";
         }
         else{
             return "The two above conditions have been met and the user has been registered successfully.";
         }
     }
     
     public boolean loginUser(String username, String password, String loginUsername, String loginPassword){
         if(username.equals(loginUsername) && password.equals(loginPassword)){
              return true;
         }
         
         
         else{
             return false;
         }
        
     }
     public String returnLoginStatus(String first,String last,String username, String password, String loginUsername, String loginPassword){
         if (loginUser(username,password,loginUsername,loginPassword)==true){
             return "Welcome "+first+" "+last+" it is great to see you again";
         }
         
         else{
             return "Username or password incorrect, please try again";
         }
     
     }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Login status=new Login();
        Task task=new Task();
        
        JOptionPane.showMessageDialog(null,"Registration Feature");
        
       String firstName=JOptionPane.showInputDialog(null,"Please enter your First Name ");
       
         String lastName=JOptionPane.showInputDialog(null,"Please enter your Last Name ");
        
        
        //I am taking the username and password for register
        
         String regUsername=JOptionPane.showInputDialog(null,"Please enter your Userame");
        
        
         String regPassword=JOptionPane.showInputDialog(null,"Please enter your Password ");
        
        
      
     
        

        boolean reg=false;
        while(reg==false){
            if (status.checkUserName( regUsername)==true && status.checkPassWordComplexity(regPassword)==true){
                JOptionPane.showMessageDialog(null,status.registerUser(regUsername, regPassword));
                reg=true;
                JOptionPane.showMessageDialog(null,"The username and password is successfully captured");
               
            }
            else if (status.checkUserName( regUsername)==false && status.checkPassWordComplexity(regPassword)==true){
                JOptionPane.showMessageDialog(null,status.registerUser(regUsername, regPassword));
                 JOptionPane.showMessageDialog(null,"Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
                  regUsername=JOptionPane.showInputDialog(null,"Please enter your Userame");
                
                
            }
            else if(status.checkUserName( regUsername)==true && status.checkPassWordComplexity(regPassword)==false){
                JOptionPane.showMessageDialog(null,status.registerUser(regUsername, regPassword));
                 JOptionPane.showMessageDialog(null,"Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character. ");
                 regPassword=JOptionPane.showInputDialog(null,"Please enter your Password");
            }
            else{
                 JOptionPane.showMessageDialog(null,status.registerUser(regUsername, regPassword));
             
                  regUsername=JOptionPane.showInputDialog(null,"Please enter your Userame");
                 
                 regPassword=JOptionPane.showInputDialog(null,"Please enter your Password");
                  
            }
            
        
        }
       // System.out.println(status.registerUser(regUsername, regPassword));
        JOptionPane.showMessageDialog(null,"Login Feature");
        
       String logUsername= JOptionPane.showInputDialog(null,"Please enter the username to login");
        
        
        String logPassword=JOptionPane.showInputDialog(null,"Please enter the password to login");
        boolean log=false;
        int count=0;
        int choose;
        Scanner sc=new Scanner(System.in);
        while(!log){
        if (regUsername.equals(logUsername) && regPassword.equals(logPassword)){
            JOptionPane.showMessageDialog(null,status.returnLoginStatus(firstName,lastName,regUsername, regPassword,logUsername,logPassword));
            
            log=true;
        }
        else if(!(regUsername.equals(logUsername)) && regPassword.equals(logPassword)){
             JOptionPane.showMessageDialog(null,status.returnLoginStatus(firstName,lastName,regUsername, regPassword,logUsername,logPassword));
            
             logUsername=JOptionPane.showInputDialog(null,"Your username is not matching, please enter your correct username to login");
        }
        else if(!(regPassword.equals(logPassword)) && regUsername.equals(logUsername)){
             JOptionPane.showMessageDialog(null,status.returnLoginStatus(firstName,lastName,regUsername, regPassword,logUsername,logPassword));
            
             logPassword= JOptionPane.showInputDialog(null,"Your password is not matching, please enter your correct password to login");
        }
        else{
              JOptionPane.showMessageDialog(null,status.returnLoginStatus(firstName,lastName,regUsername, regPassword,logUsername,logPassword));
       
         logUsername= JOptionPane.showInputDialog(null,"Your username is not matching, please enter your correct username to login");
        
        logPassword=JOptionPane.showInputDialog(null,"Your password is not matching, please enter your correct password to login");
        }
        count++;
        if(count==3){
            JOptionPane.showMessageDialog(null,"Your account is blocked");
            break;
        }
        }
        
        
 
  
       
            
            
            if (regUsername.equals(logUsername) && regPassword.equals(logPassword)){
            choose=Integer.parseInt(JOptionPane.showInputDialog(null,"Welcome to EasyKanBan \nPlease choose one of the following \n a. Option 1) Add tasks \n b. Option 2) Show-report \n c. Option 3) Quit"));
            while(choose!=3){
            if (choose==1){
                
            
            int taskNumber=Integer.parseInt(JOptionPane.showInputDialog(null,"How many tasks do you want to add"));
            String[] devName=new String[taskNumber];
             String[] devSurname=new String[taskNumber];
            String[] taskName=new String[taskNumber];
            int[] taskDuration=new int[taskNumber];
            String[] taskID=new String[taskNumber];
            int taskCount;
            int status1;
            String[] taskStatus=new String[taskNumber];
            String taskDescription="";
            for(int i=0;i<taskNumber;i++){
               
                
                taskCount=i;
                 taskName[i]=JOptionPane.showInputDialog(null,"Please enter the Task Name:");
                
                taskDescription=JOptionPane.showInputDialog(null,"Please enter the Task Description: ");
             
               
               
               
                 
                
                //I am adding to the arrayList
               
                
                boolean s=task.checkTaskDescription(taskDescription);
                if(!s){
                     JOptionPane.showMessageDialog(null,"Your task description has more than 50 characters");
                }
                
                 devName[i]=JOptionPane.showInputDialog(null,"Please enter the Developer Name:");
                 
                
              devSurname[i]=JOptionPane.showInputDialog(null,"Please enter the Developer Surname:");
                
                taskDuration[i]=Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the Task Duration:"));
                task.total+=taskDuration[i];
                
                
               //Task ID
               taskID[i]=task.createTaskID(taskName[i], devName[i]);
               
                
                status1=Integer.parseInt(JOptionPane.showInputDialog(null,"Please choose the task status: \n a. Option 1) To Do \n b. Option 2) Done \n c. Option 3) Doing"));
                if (status1==1){
                    taskStatus[i]="To Do";
                }
                else if (status1==2){
                    taskStatus[i]="Done";
                }
                else{
                taskStatus[i]="Doing";
                }
              
                JOptionPane.showMessageDialog(null,task.printTaskDetails(taskStatus[i], devName[i],devSurname[i], taskName[i], taskDescription, taskID[i], taskDuration[i]));
            task.taskNumber+=1;
            
            }
            ShowReport.devName=devName;
            ShowReport.duration=taskDuration;
            ShowReport.taskName=taskName;
            ShowReport.taskID=taskID;
            ShowReport.taskStatus=taskStatus;
            
            JOptionPane.showMessageDialog(null,"The total hours \n"+task.returnTotalHours());
            
            }
            else if(choose==2){
                //JOptionPane.showMessageDialog(null,"Coming soon");
                boolean t=true;
                while(t){
                int value=Integer.parseInt(JOptionPane.showInputDialog(null, "a. Option 1) Display the Developer, Task Names and Task Duration for all tasks with the status of done.\n "
                        + "b. Option 2) Display the Developer and Duration of the class with the longest duration. \n"
                        + "c. Option 3) Search for a task with a Task Name and display the Task Name, Developer and Task Status. \n"
                        + "d. Option 4) Search for all tasks assigned to a developer and display the Task Name and Task Status. \n"
                        + "e. Option 5) Delete a task using the Task Name. \n"
                        + "f. Option 6) Display a report that lists the full details of all captured tasks. \n"
                        + "g. Option 7) Exit"));
                    switch (value) {
                        case 1:
                            JOptionPane.showMessageDialog(null,ShowReport.statusOfDone());
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, ShowReport.longestDuration());
                            break;
                        case 3:
                            String name=JOptionPane.showInputDialog(null, "Please enter the name of the task you want to search");
                            JOptionPane.showMessageDialog(null,ShowReport.searchTaskName(name));
                            break;
                        case 4:
                            String developer=JOptionPane.showInputDialog(null, "Please enter the name of the developer you want to search");
                            JOptionPane.showMessageDialog(null,ShowReport.searchDeveloper(developer));
                            break;
                        case 5:
                            name=JOptionPane.showInputDialog(null, "Please enter the name of the task you want to delete");
                            ShowReport.delete(name);
                            break;
                        case 6:
                            JOptionPane.showMessageDialog(null,ShowReport.fullReport());
                            break;
                        default:
                            t=false;
                            break;
                    }
            }
            }
            else{
                JOptionPane.showMessageDialog(null,"Goodbye");
                
                System.exit(0);
            }
            choose=Integer.parseInt(JOptionPane.showInputDialog(null,"Welcome to EasyKanBan \nPlease choose one of the following \n a. Option 1) Add tasks \n b. Option 2) Show-report \n c. Option 3) Quit"));
            }
            
            //status of done
            
            
            //Duration 
            
           
            }
    }
    
}
