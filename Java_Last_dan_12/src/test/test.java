package test;
import java.util.Scanner;

import linprintpack.lineprint;
import test.calculator;

public class test {
        public static void main(String[] args) {
                lineprint class_line = new lineprint();
                calculator class_calculator = new calculator();
                
                class_line.print_line();
                for(int i=0;i<3;i++){
                    System.out.print((i+1)+"번 이름 입력하시오 : ");
                    class_calculator.name[i] = new Scanner(System.in).next();
                    System.out.print((i+1)+"번 국어점수를 입력하시오 : ");
                    class_calculator.kor[i] = new Scanner(System.in).nextInt();
                    System.out.print((i+1)+"번 영어점수를 입력하시오 : ");
                    class_calculator.eng[i] = new Scanner(System.in).nextInt();
                    System.out.print((i+1)+"번 수학점수를 입력하시오 : ");
                    class_calculator.mat[i] = new Scanner(System.in).nextInt();    
                    class_calculator.num[i]=i+1;
                }
                class_line.print_line();
                              
                class_calculator.sum_func();
                class_calculator.avg_func();
                class_calculator.rank();
                
                class_calculator.align();
                
                class_line.print_line(40);
                System.out.println("번호  이름    국어  영어  수학  총점  평균    등수");
                class_line.print_line(40);
                
                    String[] avg= new String[3];
                    String[] name= new String[3];
                for(int i=0;i<3;i++){
                    avg[i] = String.format("%.2f",class_calculator.avg[i]);
                    name[i] = String.format("%-5s",class_calculator.name[i]);
                    System.out.println(" "+ class_calculator.num[i]+"   "+name[i]+"    "+class_calculator.kor[i]+"  "+class_calculator.eng[i]+"  "+class_calculator.mat[i]+"  "+class_calculator.sum[i]+"  "+avg[i]+"  "+class_calculator.r[i]);
                }
                class_line.print_line(40);
        }

        
}