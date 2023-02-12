import java.util.LinkedList;
import java.util.Queue;

public class Textsemaphore  {
	
	static boolean a=true;
	static Queue<Process> textblocked ;
		
	public  Textsemaphore() {
	
		textblocked = new LinkedList<>(); 
		
	}	
		
	@SuppressWarnings("deprecation")

	public static void semTextWait(Process c){
		
if(a==true){
			
			
			a=false;
			
			
		}
else{		
				textblocked.add(c);
				Process.setProcessState(c,ProcessState.Waiting);
				
				//(OperatingSystem.q).remove(c);
				
				c.suspend();
			
		}
		
	}
	
	public static void semTextPost() {
if(textblocked.isEmpty()==true){
			
			a=true;
		}
		
	else{
		
				Process p = textblocked.peek();
				textblocked.remove();
				
				Process.setProcessState(p,ProcessState.Ready);
				
				//(OperatingSystem.q).add(p);
				p.resume();

			}

		
		
		
		
		
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
