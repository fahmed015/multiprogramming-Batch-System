import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.Semaphore;


public class OperatingSystem {
	
	public static ArrayList<Thread> ProcessTable;; 
	  static Queue<Process> q ;
	
//	public static int activeProcess= 0;
	//system calls:
	// 1- Read from File
	@SuppressWarnings("unused")
	public static String readFile(String name) {
		String Data="";
		File file = new File(name);
	 try {
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine())
		{
			Data+= scan.nextLine()+"\n";
		}
		scan.close();
	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	}
		return Data;
	}
	
	// 2- Write into file
	@SuppressWarnings("unused")
	public static void writefile(String name, String data) {
		try
		{
			BufferedWriter BW = new BufferedWriter(new FileWriter(name));
			BW.write(data);
			BW.close();
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}

	}
	//3- print to console
	@SuppressWarnings("unused")
	public static void printText(String text) {
		
		

		System.out.println(text);
		
		
	}
	
	//4- take input
	
	@SuppressWarnings("unused")
	public static String TakeInput() {
	
		Scanner in= new Scanner(System.in);
		String data = in.nextLine();
		
		
		
		return data;
		
		
	}
	
	private static void createProcess(int processID){
		Process p = new Process(processID);
		ProcessTable.add(p);
		Process.setProcessState(p,ProcessState.Ready);
        q.add(p);
        
      
  //  p.start();
        
        
        
     //////////// First come First Serve
        
       while(!q.isEmpty()){
        	
        	
        	
        	Process a = q.peek();        	
        	if(a.status==ProcessState.Ready){
        		
        	a.start();
        	Process.setProcessState(p,ProcessState.Running);
        	
        	}
       	
        	
        	
        	if(a.status==ProcessState.Terminated){
        		
        		
        	q.remove();
        	}
        	
        	
        	
        }
      
       			
        			
        			
        			
        		
       

       
       
       
		
	}
	
	public static void main(String[] args) {
   		ProcessTable = new ArrayList<Thread>();
   		q = new LinkedList<>(); 
   		Printsemaphore s1 = new Printsemaphore();
   		Textsemaphore s2 = new Textsemaphore();
   		Writesemaphore s3 = new Writesemaphore();
   		Readsemaphore s4 = new Readsemaphore();
   		
   		
   		
   		
		createProcess(1);
		
		createProcess(2);
   		
		createProcess(3);
		
   		
		createProcess(4);
		
		
		
		createProcess(5);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}



