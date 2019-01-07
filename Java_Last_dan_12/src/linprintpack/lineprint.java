package linprintpack;

public class lineprint {
	public void print_line(){
	    System.out.println("-----------------------------");
	}

	public void print_line(int n){
	        for(int i=0;i<n;i++){
	                System.out.print("-");
	        }
	        System.out.println("");
	}
}
