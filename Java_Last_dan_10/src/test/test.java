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
        
}
public class test {
        public static void main(String[] args) {
                Scanner stdin = new Scanner(System.in);
                String[] avg_n= new String[3];
                String[] name_n= new String[3];
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
                }
                f.print_line();
                
                f.sum_func();
                f.avg_func();
                f.rank();
                
                f.print_line(40);
                System.out.println("번호  이름    국어  영어  수학  총점  평균    등수");
                f.print_line(40);
                for(int i=0;i<3;i++){
                        avg_n[i] = String.format("%.2f",f.avg[i]);
                        name_n[i] = String.format("%-5s",f.name[i]);
                        System.out.println(" "+ (i+1)+"   "+name_n[i]+"    "+f.kor[i]+"  "+f.eng[i]+"  "+f.mat[i]+"  "+f.sum[i]+"  "+avg_n[i]+"  "+f.r[i]);
                }
                
                f.print_line(40);
        }

        
}