import java.util.LinkedList;
import java.util.Queue;

public class Printsemaphore  {
	
	static boolean a=true;
	static Queue<Process> printblocked ;
		
	public  Printsemaphore() {
	
		printblocked = new LinkedList<>(); 
		
	}	
		
	@SuppressWarnings("deprecation")

	public static void semPrintWait(Process c){
		
		if(a==true){
			
			
			a=false;
			
			
		}
		else{
			
				printblocked.add(c);
				Process.setProcessState(c,ProcessState.Waiting);
				
				//(OperatingSystem.q).remove(c);
				
				c.suspend();
			
		}
		
	}
	
	public static void semPrintPost() {
	
		
		if(printblocked.isEmpty()==true){
			
			a=true;
		}
		
	else{
			
				Process p = printblocked.peek();
				printblocked.remove();
				
				Process.setProcessState(p,ProcessState.Ready);
				
				//(OperatingSystem.q).add(p);
				p.resume();

			}

		
		
		
		
		
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
