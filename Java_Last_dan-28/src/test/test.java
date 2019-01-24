package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

// 어레이
class Student implements Comparable<Student> {

    Scanner sc = new Scanner(System.in);
    int MAX = 10; // 최대 10명
    int NOW = 0; // 현재 몇번째 학생까지 있는가
    int NOW2 = 0; // 현재 몇번째 학생까지 있는가
    String string_fail = "--잘못된 값입니다. 다시 입력해주세요.";
    String string_fail_name = "입력한 이름의 데이터가 없습니다.";
    String string_menu = "번호  이름    국어  영어  수학  총점  평균    등수";
    String name;
    public int kor, eng, mat, num, sum, rank;
    double avg;

    public Student() {

    }

    public Student(String name, int kor, int eng, int mat, int num) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
        this.num = num;
        this.sum = kor + eng + mat;

        double temp = sum / 3.0;
        DecimalFormat format = new DecimalFormat(".##");
        String str = format.format(temp);
        this.avg = Double.parseDouble(str);
        this.rank = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return num;
    }

    public void setNumber(int number) {
        this.num = num;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int number) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int number) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int number) {
        this.mat = mat;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int number) {
        this.sum = this.kor + this.eng + this.mat;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double number) {
        double temp = this.sum / 3.0;
        DecimalFormat format = new DecimalFormat(".##");
        String str = format.format(temp);
        this.avg = Double.parseDouble(str);
    }

    public void Dash() {
        System.out.println("---------------------------------");
    }

    void Dash_line(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    protected void printf_start() {
        Dash();
        System.out.println("<<원하시는 번호를 선택하세요>>");
        Dash();
        System.out.println("1.학생정보입력");
        System.out.println("2.학생정보출력");
        System.out.println("3.학생정보검색");
        System.out.println("4.학생정보수정");
        System.out.println("5.학생정보삭제");
        System.out.println("6.종료");
        System.out.print("선택번호 : ");
    }

    // 정렬
    @Override
    public int compareTo(Student t) {
        return rank - t.rank;
    }

    public Student(int rank) {
        this.rank = rank;
    }

    // 1.학생정보입력
    protected void input_go(ArrayList<Student> student_all) throws IOException {
        if (NOW >= MAX) {
            System.out.println("현재 " + MAX + "명을 모두 입력했습니다. 더 이상 입력할 수 없습니다.");
        } else {
            Dash();

            boolean tmp_status = false;
            String tmp_gap = null;

            while (tmp_status == false) {
                System.out.print((NOW + 1) + "번 이름 입력하시오 : ");
                tmp_gap = sc.next();
                tmp_status = true;
                for (int i = 0; i < NOW; i++) {

                    if (tmp_gap.equals(student_all.get(i).getName())) {
                        System.out.println("--중복입니다. 다른 이름을 입력해주세요.");
                        tmp_status = false;
                    }
                }
            }
            name = tmp_gap;
            tmp_status = false;

            while (tmp_status == false) {
                System.out.print((NOW + 1) + "번 국어점수를 입력하시오 : ");
                tmp_gap = sc.next();
                if (isStringInt(tmp_gap)) {
                    if (Integer.parseInt(tmp_gap) <= 100 && Integer.parseInt(tmp_gap) >= 0) {
                        tmp_status = true;
                    } else {
                        System.out.println(string_fail + "");
                    }
                } else {
                    System.out.println(string_fail);
                }
            }
            kor = Integer.parseInt(tmp_gap);
            tmp_status = false;

            while (tmp_status == false) {
                System.out.print((NOW + 1) + "번 영어점수를 입력하시오 : ");
                tmp_gap = sc.next();
                if (isStringInt(tmp_gap)) {
                    if (Integer.parseInt(tmp_gap) <= 100 && Integer.parseInt(tmp_gap) >= 0) {
                        tmp_status = true;
                    } else {
                        System.out.println(string_fail + "");
                    }
                } else {
                    System.out.println(string_fail);
                }
            }
            eng = Integer.parseInt(tmp_gap);
            tmp_status = false;

            while (tmp_status == false) {
                System.out.print((NOW + 1) + "번 수학점수를 입력하시오 : ");
                tmp_gap = sc.next();
                if (isStringInt(tmp_gap)) {
                    if (Integer.parseInt(tmp_gap) <= 100 && Integer.parseInt(tmp_gap) >= 0) {
                        tmp_status = true;
                    } else {
                        System.out.println(string_fail + "");
                    }
                } else {
                    System.out.println(string_fail);
                }
            }
            mat = Integer.parseInt(tmp_gap);

            student_all.add(new Student(name, kor, eng, mat, NOW + 1));

            for (int i = 0; i < NOW + 1; i++) {
                int tempintgap = 0;
                for (int j = 0; j < NOW + 1; j++) {
                    if (student_all.get(i).sum < student_all.get(j).sum) {
                        tempintgap = tempintgap + 1;
                    }
                }
                tempintgap = tempintgap + 1;
                student_all.get(i).rank = tempintgap;
            }

            NOW = NOW + 1;
            //  align();    
printf_result(student_all, 0);
        }
    }

    // 2.학생정보출력
    protected void printf_result(ArrayList<Student> student_all, int stat2) throws IOException {
        String[] avg2 = new String[MAX];
        String[] name2 = new String[MAX];

        //  Dash_line(52);
        //  System.out.println(string_menu);
        //  Dash_line(52);
        PrintWriter pw2 = new PrintWriter(new FileWriter("output_data.txt", false));

        pw2.write("");

        pw2.println("----------------------------------------------------");
        pw2.println(string_menu);
        pw2.println("----------------------------------------------------");

        for (int i = 0; i < NOW; i++) {
            //   printf_start_deep(i, student_all);
            Collections.sort(student_all);
            avg2[i] = String.format("%.2f", student_all.get(i).avg);
            name2[i] = String.format("%-5s", student_all.get(i).name);

            pw2.println(" " + student_all.get(i).num + "   " + name2[i] + "    "
                    + student_all.get(i).kor + "  " + student_all.get(i).eng + "  " + student_all.get(i).mat + "  " + student_all.get(i).sum
                    + "  " + avg2[i] + "  " + student_all.get(i).rank);
        }

        // Dash_line(52);
        pw2.println("----------------------------------------------------");
        pw2.close();

        if (stat2 == 1) {
            // 읽기
            int stat = 1;

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("output_data.txt"), "UTF-8"));
                String str = null;
                while ((str = reader.readLine()) != null) {
                    if (stat == 1) {
                        //  str = str.substring(1, str.length());
                        stat = 0;
                    }
                    System.out.println(str);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    protected void printf_start_deep(int i, ArrayList<Student> student_all) throws IOException {
        Collections.sort(student_all);

        String[] avg2 = new String[MAX];
        String[] name2 = new String[MAX];
        avg2[i] = String.format("%.2f", student_all.get(i).avg);
        name2[i] = String.format("%-5s", student_all.get(i).name);
        System.out.println(" " + student_all.get(i).num + "   " + name2[i] + "    "
                + student_all.get(i).kor + "  " + student_all.get(i).eng + "  " + student_all.get(i).mat + "  " + student_all.get(i).sum
                + "  " + avg2[i] + "  " + student_all.get(i).rank);
    }

    protected void printf_start_deep2(int i, ArrayList<Student> student_all) {
        String[] avg2 = new String[MAX];
        String[] name2 = new String[MAX];
        avg2[i] = String.format("%.2f", student_all.get(i).avg);
        name2[i] = String.format("%-5s", student_all.get(i).name);
        System.out.println(" " + student_all.get(i).num + "   " + name2[i] + "    "
                + student_all.get(i).kor + "  " + student_all.get(i).eng + "  " + student_all.get(i).mat + "  " + student_all.get(i).sum
                + "  " + avg2[i] + "  " + student_all.get(i).rank);
    }

// 3.학생정보검색
    protected void search(ArrayList<Student> student_all) throws IOException {
        Dash();
        System.out.print("이름 입력하시오 : ");
        String tmp = sc.next();
        Dash_line(52);
        boolean local_status = false;
        for (int i = 0; i < NOW; i++) {
            if (tmp.equals(student_all.get(i).name)) {
                System.out.println(string_menu);
                Dash_line(52);
                printf_start_deep(i, student_all);
                
                local_status = true;
            }
        }
        if (local_status == false) {
            System.out.println(string_fail_name);
        }
        Dash_line(52);
    }

    // 4. 학생정보수정
    protected void Change(ArrayList<Student> student_all) throws IOException {
        String[] avg2 = new String[MAX];
        String[] name2 = new String[MAX];
        String tmp = null; // 임시 문자열 지역변수
        Dash();
        System.out.print("이름 입력하시오 : ");
        tmp = sc.next();
        Dash_line(52);

        int local_status = 0;

        for (int i = 0; i < NOW; i++) {
            if (tmp.equals(student_all.get(i).name)) {
                System.out.println("번호(수정불가) : " + student_all.get(i).num);
                System.out.println("이름(수정불가) : " + student_all.get(i).name);

                String tmpgap = null;
                int tempstatus = 0;

                while (tempstatus == 0) {
                    System.out.print("국어(현재 " + student_all.get(i).kor + "점)수정점수 : ");
                    tmpgap = sc.next();
                    if (isStringInt(tmpgap)) {
                        if (Integer.parseInt(tmpgap) <= 100 && Integer.parseInt(tmpgap) >= 0) {
                            tempstatus = 1;
                        } else {
                            System.out.println(string_fail);
                        }
                    } else {
                        System.out.println(string_fail);
                    }
                }
                student_all.get(i).kor = Integer.parseInt(tmpgap);

                while (tempstatus == 1) {
                    System.out.print("영어(현재 " + student_all.get(i).eng + "점)수정점수 : ");
                    tmpgap = sc.next();
                    if (isStringInt(tmpgap)) {
                        if (Integer.parseInt(tmpgap) <= 100 && Integer.parseInt(tmpgap) >= 0) {
                            tempstatus = 2;
                        } else {
                            System.out.println(string_fail);
                        }
                    } else {
                        System.out.println(string_fail);
                    }
                }
                student_all.get(i).eng = Integer.parseInt(tmpgap);

                while (tempstatus == 2) {
                    System.out.print("수학(현재 " + student_all.get(i).mat + "점)수정점수 : ");
                    tmpgap = sc.next();
                    if (isStringInt(tmpgap)) {
                        if (Integer.parseInt(tmpgap) <= 100 && Integer.parseInt(tmpgap) >= 0) {
                            tempstatus = 3;
                        } else {
                            System.out.println(string_fail);
                        }
                    } else {
                        System.out.println(string_fail);
                    }
                }
                student_all.get(i).mat = Integer.parseInt(tmpgap);

                // new func10(i);
                Dash();
                System.out.println("수정후 점수");
                Dash_line(52);
                System.out.println(string_menu);
                Dash_line(52);

                student_all.get(i).sum = student_all.get(i).kor + student_all.get(i).eng + student_all.get(i).mat;

                double temp = student_all.get(i).sum / 3.0;
                DecimalFormat format = new DecimalFormat(".##");
                String str = format.format(temp);
                double temp2 = Double.parseDouble(str);

                student_all.get(i).avg = temp2;

                for (int i3 = 0; i3 < NOW; i3++) {
                    int tempintgap = 0;
                    for (int j = 0; j < NOW; j++) {
                        if (student_all.get(i3).sum < student_all.get(j).sum) {
                            tempintgap = tempintgap + 1;
                        }
                    }
                    tempintgap = tempintgap + 1;
                    student_all.get(i3).rank = tempintgap;
                }

                printf_start_deep2(i, student_all);
                local_status = 1;

                i = NOW;
            }
        }
        if (local_status == 0) {
            System.out.println(string_fail_name);
        }
        else{
            printf_result(student_all, 0);
        }
        Dash_line(52);
    }

    // 5. 학생정보삭제
    protected void delete(ArrayList<Student> student_all) throws IOException {
        String namewhy = null;
        int aaa = 15;
        Dash();
        System.out.print("이름 입력하시오 : ");
        namewhy = sc.next();
        for (int i = 0; i < NOW; i++) {
            if (namewhy.equals(student_all.get(i).name)) {
                aaa = i;
            }
        }
        if (aaa == 15) {
            Dash_line(52);
            System.out.println("입력한 이름의 데이터가 없습니다.");
            Dash_line(52);
        } else {
            for (int i = 0; i < NOW; i++) {
                if (student_all.get(i).num == 1) {

                }
                if (student_all.get(i).num > student_all.get(aaa).num) {
                    student_all.get(i).num = student_all.get(i).num - 1;
                }
            }
            student_all.remove(aaa);
            NOW = NOW - 1;
            for (int i = 0; i < NOW; i++) {
                int tempintgap = 0;
                for (int j = 0; j < NOW; j++) {
                    if (student_all.get(i).sum < student_all.get(j).sum) {
                        tempintgap = tempintgap + 1;
                    }
                }
                tempintgap = tempintgap + 1;
                student_all.get(i).rank = tempintgap;
            }
            Dash_line(52);
            System.out.println(string_menu);
            Dash_line(52);
            if (NOW == 0) {

            } else {
                for (int i = 0; i < NOW; i++) {
                    printf_start_deep(i, student_all);
                }
            }
            Dash_line(52);
            printf_result(student_all, 0);
        }
    }

    // 숫자 판별
    protected boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    String[] weeks = new String[100];
    String string_dash = "----------------------------------------------------";

    int real_max = 10;

    protected void read(ArrayList<Student> student_all) throws UnsupportedEncodingException, IOException {
        int stat = 1;
        int tmpi = 0;

        // 읽기
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("output_data.txt"), "UTF-8"));
            String str = null;
            while ((str = reader.readLine()) != null) {
                if (stat == 1) {
                    stat = 0;
                }
                System.out.println(str);
                weeks[tmpi] = str;
                tmpi++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        NOW2 = tmpi;
    }

    protected void splitgo(ArrayList<Student> student_all) {
        String[][] arra = new String[100][100];
        for (int i = 3; i < NOW2; i++) {
            weeks[i] = weeks[i].trim().replaceAll(" +", " ");
            arra[i - 3] = weeks[i].split(" ");

        }

        for (int i2 = 0; i2 < NOW2 - 3; i2++) {
            /*
            System.out.println("i2==========" + i2);
            System.out.println("arra[i][0]=====" + arra[i2][0]);
            System.out.println("arra[i][0]=====" + arra[i2][1]);
            System.out.println("arra[i][0]=====" + arra[i2][2]);
            System.out.println("arra[i][0]=====" + arra[i2][3]);*/

            student_all.add(new Student(arra[i2][1], Integer.parseInt(arra[i2][2]), Integer.parseInt(arra[i2][3]), Integer.parseInt(arra[i2][4]), NOW + 1));

            student_all.get(i2).sum = student_all.get(i2).kor + student_all.get(i2).eng + student_all.get(i2).mat;
            double temp = student_all.get(i2).sum / 3.0;
            DecimalFormat format = new DecimalFormat(".##");
            String str = format.format(temp);
            student_all.get(i2).avg = Double.parseDouble(str);
            student_all.get(i2).rank = 1;

            NOW = NOW + 1;
        }

        for (int i = 0; i < NOW2 - 3; i++) {
            int tempintgap = 0;

            for (int j = 0; j < NOW2 - 3; j++) {
              //  System.out.println("student_all.get(i).sum==========" + student_all.get(i).sum);
              //  System.out.println("student_all.get(i).sum==========" + student_all.get(j).sum);
                if (student_all.get(i).sum < student_all.get(j).sum) {
                    tempintgap = tempintgap + 1;
                }
            }
            tempintgap = tempintgap + 1;
            student_all.get(i).rank = tempintgap;
        }

        Collections.sort(student_all);

    }
}

public class test {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<Student> student_all = new ArrayList<Student>();
        Student g = new Student(); // 자식 실행부

        g.read(student_all);
        if (g.NOW2 > 4) {
            g.NOW2 = g.NOW2 - 1;
            g.splitgo(student_all);
        }

        while (true) {
            g.printf_start();
            String tempgap = g.sc.next();
            int tmepint = 0;
            try {
                tmepint = Integer.parseInt(tempgap);
            } catch (Exception e) {
            }
            switch (tmepint) {
                case 1: // 1.학생정보입력
                    g.input_go(student_all);
                    break;
                case 2: // 2.학생정보출력
                    g.printf_result(student_all, 1);
                    break;
                case 3: // 3.학생정보검색
                    g.search(student_all);
                    break;
                case 4: // 4.학생정보수정
                    g.Change(student_all);
                    break;
                case 5: // 5.학생정보삭제
                    g.delete(student_all);
                    break;
                case 6: // 6.종료
                    System.exit(0);
                    break;
                default:
                    System.out.println(g.string_fail);
                    break;
            }
        }
    }
}
