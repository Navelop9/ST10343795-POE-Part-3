
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @ST10343795 Navelo Princess Shivuri
 */
import javax.swing.JOptionPane;
public class Task {
    int taskNumber=0;
    int total=0;       
  
     public boolean checkTaskDescription(String taskDescription){
        
        if(taskDescription.length()>50){
            return false;
        }
        
        
        return true;
    }
    public String createTaskID(String taskName, String devName){
         String taskID=taskName.substring(0,2)+" : "+taskNumber+" : "+devName.substring(devName.length()-3);
        
        return taskID.toUpperCase();
    }
     public String printTaskDetails(String taskStatus, String devName, String devSurname, String taskName, String taskDescription, String taskID, int taskDuration){
       
        return  "Task Status \t "+taskStatus+" \n Developer Details \t" +devName+" \t "+devSurname+"\n Duration \t"+taskDuration+"\nTask ID "+taskID+"\nTask Description "+taskDescription;
        
    }
     public int returnTotalHours(){
         
        return total;
    }
    
}
