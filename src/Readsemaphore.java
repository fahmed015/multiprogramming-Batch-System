import java.util.LinkedList;
import java.util.Queue;

public class Readsemaphore  {
	
	static boolean a=true;
	static Queue<Process> readblocked ;
		
	public  Readsemaphore() {
	
		readblocked = new LinkedList<>(); 
		
	}	
		
	@SuppressWarnings("deprecation")

	public static void semReadWait(Process c){
		
if(a==true){
			
			
			a=false;
			
			
		}
		else{
			
		
				readblocked.add(c);
				Process.setProcessState(c,ProcessState.Waiting);
				
				//(OperatingSystem.q).remove(c);
				
				c.suspend();
			
		}
		
	}
	
	public static void semReadPost() {
	
if(readblocked.isEmpty()==true){
			
			a=true;
		}
		
	else{
		
			
				Process p = readblocked.peek();
				readblocked.remove();
				
				Process.setProcessState(p,ProcessState.Ready);
				
				//(OperatingSystem.q).add(p);
				p.resume();

			}

		
		
		
		
		
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
