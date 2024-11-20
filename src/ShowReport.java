/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @ST10343795 Navelo Princess Shivuri
 */
public class ShowReport {
     public static int[] duration;
   
    
     public static String[] taskID;
    public static String[]  taskName;
    public static String[] taskStatus;
    public static String[] devName;
    
    public static void delete(String tName){
        String[] newTaskName=new String[taskName.length-1];
        int[] newDuration=new int[duration.length-1];
        String[] newTaskID=new String[taskID.length-1];
        String[] newTaskStatus=new String[taskStatus.length-1];
        String[] newDevName=new String[devName.length-1];
        
        
        int p=0;
        int pos=0;
        for(int i=0;i<taskName.length;i++){
            if(taskName[i].equals(tName)){
                
                 pos=i;
            }
            else{
               newTaskName[p]=taskName[i];
                p++;
            }
            
        }
        int j=0;
        for(int t=0;t<duration.length;t++){
            if(t!=pos){
                newDuration[j]=duration[t];
                newTaskID[j]=taskID[t];
                newTaskStatus[j]=taskStatus[t];
                newDevName[j]=devName[t];
                
                
                j++;
            }
            
        }
        
        duration=newDuration;
        taskID=newTaskID;
        taskStatus=newTaskStatus;
        devName=newDevName;
        taskName=newTaskName;
        
        
    }
    public static String statusOfDone(){
        String fullDetails="";
        for(int i=0;i<taskStatus.length;i++){
            if(taskStatus[i].equalsIgnoreCase("Done")){
                fullDetails+=devName[i]+"  "+taskName[i]+"  "+duration[i]+"\n";
            }
            
        }
        return fullDetails;
    }
    
    public static String longestDuration(){
        int max=duration[0];
        int position=0;
        for(int i=0;i<duration.length;i++){
            if(max<duration[i]){
                max=duration[i];
                position=i;
            }
            
        
        }
        return devName[position]+"  "+max;
    
    }
    
    public static String searchTaskName(String tName){
        String details="";
        for(int i=0;i<taskName.length;i++){
            if(tName.equalsIgnoreCase(taskName[i])){
                details+=taskName[i]+"   "+devName[i]+"   "+taskStatus[i]+"\n";
            }
        }
        return details;
    
    }
    
    public static String searchDeveloper(String developerName){
         String details="";
        for(int i=0;i<devName.length;i++){
            if(developerName.equalsIgnoreCase(devName[i])){
                details+=devName[i]+"   "+taskName[i]+"   "+taskStatus[i]+"\n";
            }
        }
        return details;
        
    }
    
    
    public static String fullReport(){
          String details="";
        for(int i=0;i<devName.length;i++){
           
                 details+="Task Name "+taskName[i]+"\n"+"Developer Name "+devName[i]+"\n"+"Task ID "+taskID[i]+"\n"+"Task Duration "+duration[i]+"\n"+"Task Status "+taskStatus[i]+"\n";
            
        }
        return details;
        
    }
    
    
}
