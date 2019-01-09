package test;
import java.util.Scanner;

class func10{
        int[] num = new int[3],kor = new int[3],eng = new int[3],mat = new int[3],sum= new int[3];
        double[] avg = new double[3];
        String[] name = new String[3];
        int[] r = {1,1,1};
        
        void sum_func(){
                for(int i=0;i<3;i++)
                        sum[i] = kor[i] + eng[i] + mat[i];
        }
        void avg_func(){
                for(int i=0;i<3;i++)
                        avg[i] = sum[i] / 3.0;
        }
        void print_line(){
                System.out.println("-----------------------------");
        }
        
        void print_line(int n){
                for(int i=0;i<n;i++){
                        System.out.print("-");
                }
                System.out.println("");
        }
        
        void rank(){
        		int i, k = 0;
                for(i=0;i<3;i++){
                        for(k=0;k<3;k++){
                                if(sum[i] > sum[k])
                                        r[k]++;
                        }
                }
        }
        
        void align(){
        	int tmp=0;
        	double tmpf=0.0f;
        	String tmps;
        	
    		for(int i=0;i<3;i++)
    		{
    			for(int j=i;j<3;j++)
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
}
public class test {
        public static void main(String[] args) {
                Scanner stdin = new Scanner(System.in);
                String[] avg= new String[3];
                String[] name= new String[3];
                func10 f = new func10();
                
                f.print_line();
                for(int i=0;i<3;i++){
                        System.out.print((i+1)+"번 이름 입력하시오 : ");
                        f.name[i] = stdin.next();
                        System.out.print((i+1)+"번 국어점수를 입력하시오 : ");
                        f.kor[i] = stdin.nextInt();
                        System.out.print((i+1)+"번 영어점수를 입력하시오 : ");
                        f.eng[i] = stdin.nextInt();
                        System.out.print((i+1)+"번 수학점수를 입력하시오 : ");
                        f.mat[i] = stdin.nextInt();    
                        f.num[i]=i+1;
                }
                f.print_line();
                
                f.sum_func();
                f.avg_func();
                f.rank();
                
                f.align();
                
                f.print_line(40);
                System.out.println("번호  이름    국어  영어  수학  총점  평균    등수");
                f.print_line(40);
                for(int i=0;i<3;i++){
                        avg[i] = String.format("%.2f",f.avg[i]);
                        name[i] = String.format("%-5s",f.name[i]);
                        System.out.println(" "+ f.num[i]+"   "+name[i]+"    "+f.kor[i]+"  "+f.eng[i]+"  "+f.mat[i]+"  "+f.sum[i]+"  "+avg[i]+"  "+f.r[i]);
                }
                
                f.print_line(40);
        }

        
}