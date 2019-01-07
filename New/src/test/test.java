package test;
import java.util.Scanner;

class func10{
	func10()
	{
		
	}

	private void func10(int nowno) // 생성자
	{
		func10 f = new func10();
		
		if(name[nowno].toString().equals("0")){
			name[nowno]="홍길동";
		}
		
		if(kor[nowno]==0){
			kor[nowno]=30;
		}
		
		if(eng[nowno]==0){
			eng[nowno]=30;
		}
		
		if(mat[nowno]==0){
			mat[nowno]=30;
		}
	}
	
        public final int MAX=10;
        public static int motmp=0;
        
		int[] num = new int[MAX+1],kor = new int[MAX+1],eng = new int[MAX+1],mat = new int[MAX+1],sum= new int[MAX+1];
        double[] avg = new double[MAX+1];
        String[] name = new String[MAX+1];
        int[] r = new int[MAX+1];   
        
        void sum_func(){
                for(int i=0;i<MAX;i++)
                        sum[i] = kor[i] + eng[i] + mat[i];
        }
        void avg_func(){
                for(int i=0;i<MAX;i++)
                        avg[i] = sum[i] / 3.0;
        }
        void print_line(){
                System.out.println("---------------------------------");
        }
        
        void print_line(int n){
                for(int i=0;i<n;i++){
                        System.out.print("-");
                }
                System.out.println("");
        }
        
        void rank(){
                for(int i=0;i<motmp+1;i++){
                	int k=0;
                        for(int j=0;j<motmp+1;j++){
                                if(sum[i] < sum[j])
                                        ++k;
                        }
                        ++k;
                        r[i]=k;
                }
        }
        
        void align(){
        	int tmp=0;
        	double tmpf=0.0f;
        	String tmps;
        	
    		for(int i=0;i<motmp+1;i++)
    		{
    			for(int j=i;j<motmp+1;j++)
    			{
    				if(sum[i]<sum[j])
    				{
    					tmp=num[j];
    					num[j]=num[i];
    					num[i]=tmp;
    					
    					tmp=kor[j];
    					kor[j]=kor[i];
    					kor[i]=tmp;
    					
    					tmp=eng[j];
    					eng[j]=eng[i];
    					eng[i]=tmp;
    					
    					tmp=mat[j];
    					mat[j]=mat[i];
    					mat[i]=tmp;
    					
    					tmp=sum[j];
    					sum[j]=sum[i];
    					sum[i]=tmp;
    					
    					tmp=r[j];
    					r[j]=r[i];
    					r[i]=tmp;
    					
    					tmpf=avg[j];
    					avg[j]=avg[i];
    					avg[i]=tmpf;
    					
    					tmps=name[j];
    					name[j]=name[i];
    					name[i]=tmps;
    				}
    			}
    		}
        }
        
        void printf_start(){
        	print_line();
        	System.out.println("<<원하시는 번호를 선택하세요>>");
        	print_line();
        	System.out.println("1.학생정보입력");
        	System.out.println("2.학생정보출력");
        	System.out.println("3.종료");
        	System.out.print("선택번호 : ");
		}
        
        void scan_start(){
        	if(motmp<MAX){
	        	Scanner sc = new Scanner(System.in);

	        	print_line();
	            System.out.print((motmp+1)+"번 이름 입력하시오 : ");
	            name[motmp] = sc.next();
	            System.out.print((motmp+1)+"번 국어점수를 입력하시오 : ");
	            kor[motmp] = sc.nextInt();
	            System.out.print((motmp+1)+"번 영어점수를 입력하시오 : ");
	            eng[motmp] = sc.nextInt();
	            System.out.print((motmp+1)+"번 수학점수를 입력하시오 : ");
	            mat[motmp] = sc.nextInt();    
	            num[motmp]=motmp+1;

	            func10(motmp);
	            
                sum_func();
                avg_func();
                rank();
                align();
                
                motmp=motmp+1;
        	}
        	else{
        		System.out.println("--현재 10명을 모두 입력했습니다. 더 이상 입력할 수 없습니다.");
        	}
        }



		void printf_result(){
            String[] avg2= new String[MAX+1];
            String[] name2= new String[MAX+1];
        	
            print_line(52);
            System.out.println("번호  이름    국어  영어  수학  총점  평균    등수");
            print_line(52);
            for(int i=0;i<motmp;i++){
                    avg2[i] = String.format("%.2f",avg[i]);
                    name2[i] = String.format("%-5s",name[i]);
                    System.out.println(" "+ num[i]+"   "+name2[i]+"    "+kor[i]+"  "+eng[i]+"  "+mat[i]+"  "+sum[i]+"  "+avg2[i]+"  "+r[i]);
            }
            print_line(52);
		}
        

}

public class test {
	public final int MAX=10;
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                func10 f = new func10();
                
                while(true)
                {
	                f.printf_start();
	                int tmp_num = sc.nextInt();
	                switch(tmp_num)
	                {
		                case 1:
		                	f.scan_start();
		                	break;
		                case 2:
		                	f.printf_result();
		                	break;
		                case 3:
		                	System.exit(0);
		                	break;
		                default:
		                	System.out.println("--잘못된 값입니다. 다시 입력해주세요.");
		                	break;
	                }
                }
        }
}