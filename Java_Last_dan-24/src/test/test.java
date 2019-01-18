package test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 어레이
class Student implements Comparable<Student> {

    Scanner sc = new Scanner(System.in);
    int MAX = 10; // 최대 10명
    int NOW = 0; // 현재 몇번째 학생까지 있는가
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

    @Override
    public int compareTo(Student t) {
        return rank - t.rank;
    }

    public Student(int rank) {
        this.rank = rank;
    }

    // 1.학생정보입력
    protected void input_go(ArrayList<Student> student_all) {
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
                    if (tmp_gap.equals(student_all.get(i).name)) {
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

        }
    }

    // 2.학생정보출력
    protected void printf_result(ArrayList<Student> student_all) {

        //    align();
        Dash_line(52);
        System.out.println(string_menu);
        Dash_line(52);
        for (int i = 0; i < NOW; i++) {
            printf_start_deep(i, student_all);
        }
        Dash_line(52);
    }

    protected void printf_start_deep(int i, ArrayList<Student> student_all) {
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
    protected void search(ArrayList<Student> student_all) {
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
    protected void Change(ArrayList<Student> student_all) {
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
        Dash_line(52);
    }

    // 5. 학생정보삭제
    protected void delete(ArrayList<Student> student_all) {
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

}

public class test {

    public static void main(String[] args) {
        ArrayList<Student> student_all = new ArrayList<Student>();
        Student g = new Student(); // 자식 실행부
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
                    g.printf_result(student_all);
                    break;
                case 3: // 3.학생정보검색
                    g.search(student_all);
                    break;
                case 4: // 4.학생정보수정
                    g.Change(student_all);
                    break;
                case 5: // 4.학생정보삭제
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
