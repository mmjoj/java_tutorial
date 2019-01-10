package test;

import java.util.Scanner;

class func10 {

    protected final int MAX = 10; // 최대 10명
    protected final String string_fail = "--잘못된 값입니다. 다시 입력해주세요.";
    protected final String string_fail_name = "--입력하신 이름은 없는 값입니다.";
    protected static Scanner sc = new Scanner(System.in); // 입력 가능하게
    protected static String[] name = null; // 이름
    protected static int[] num = null; // 번호
    protected static int[] kor = null; // 국어 점수
    protected static int[] eng = null; // 영어 점수
    protected static int[] mat = null; // 수학 점수
    protected static int[] sum = null; // 총점
    protected static double[] avg = null; // 평균
    protected static int[] r = null; // 랭크
    protected static int motmp = 0; // 현재 몇번째 학생까지 있는가
    
    func10() {
        this(5, 5);
    }

    func10(int c, int y) {
        num = new int[MAX];
        kor = new int[MAX];
        eng = new int[MAX];
        mat = new int[MAX];
        sum = new int[MAX+1];
        avg = new double[MAX];
        name = new String[MAX];
        r = new int[MAX+1];
        for(int i=0;i<MAX;i++){
            name[i] = "name"+(i+1);
            kor[i] = 100;
            eng[i] = 100;
            mat[i] = 100;
            num[i] = i + 1;
        }
        motmp=MAX;
    }
    
    protected func10(int nowno) // 생성자
    {
        if (name[nowno].toString().equals("0")) {
            name[nowno] = "홍길동";
        }

        if (kor[nowno] == 0) {
            kor[nowno] = 30;
        }

        if (eng[nowno] == 0) {
            eng[nowno] = 30;
        }

        if (mat[nowno] == 0) {
            mat[nowno] = 30;
        }
    }

    protected boolean search(Shotgun g, int i) {
        String[] avg2 = new String[MAX];
        String[] name2 = new String[MAX];

        System.out.println("번호  이름    국어  영어  수학  총점  평균    등수");
        g.print_line(52);

        avg2[i] = String.format("%.2f", avg[i]);
        name2[i] = String.format("%-5s", name[i]);
        System.out.println(" " + num[i] + "   " + name2[i] + "    "
                + kor[i] + "  " + eng[i] + "  " + mat[i] + "  " + sum[i]
                + "  " + avg2[i] + "  " + r[i]);
        return true;
    }
}

class Shotgun extends func10 {

    public Shotgun() {
        super();
    }

    protected void sum_func() {
        for (int i = 0; i < MAX; i++) {
            sum[i] = kor[i] + eng[i] + mat[i];
        }
    }

    protected void avg_func() {
        for (int i = 0; i < MAX; i++) {
            avg[i] = sum[i] / 3.0;
        }
    }

    protected void print_line() {
        System.out.println("---------------------------------");
    }

    protected void print_line(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    protected void rank() {
        for (int i = 0; i < motmp + 1; i++) {
            int k = 0;
            for (int j = 0; j < motmp + 1; j++) {
                if (sum[i] < sum[j]) {
                    ++k;
                }
            }
            ++k;
            r[i] = k;
        }
    }

    protected void align() {
        int tmp = 0;
        double tmpf = 0.0f;
        String tmps;

        for (int i = 0; i < motmp + 1; i++) {
            for (int j = i; j < motmp + 1; j++) {
                if (sum[i] < sum[j]) {
                    tmp = num[j];
                    num[j] = num[i];
                    num[i] = tmp;

                    tmp = kor[j];
                    kor[j] = kor[i];
                    kor[i] = tmp;

                    tmp = eng[j];
                    eng[j] = eng[i];
                    eng[i] = tmp;

                    tmp = mat[j];
                    mat[j] = mat[i];
                    mat[i] = tmp;

                    tmp = sum[j];
                    sum[j] = sum[i];
                    sum[i] = tmp;

                    tmp = r[j];
                    r[j] = r[i];
                    r[i] = tmp;

                    tmpf = avg[j];
                    avg[j] = avg[i];
                    avg[i] = tmpf;

                    tmps = name[j];
                    name[j] = name[i];
                    name[i] = tmps;
                }
            }
        }
    }

    protected void printf_start() {
        print_line();
        System.out.println("<<원하시는 번호를 선택하세요>>");
        print_line();
        System.out.println("1.학생정보입력");
        System.out.println("2.학생정보출력");
        System.out.println("3.학생정보검색");
        System.out.println("4.학생정보수정");
        System.out.println("5.학생정보삭제");
        System.out.println("6.종료");
        System.out.print("선택번호 : ");
    }

    // 1.학생정보입력
    protected void scan_start() {
        String tempgap = null;
        int tempstatus = 0;

        try {
            name[motmp] = null;

            print_line();

            int local_status = 0;

            while (local_status == 0) {
                System.out.print((motmp + 1) + "번 이름 입력하시오 : ");
                name[motmp] = sc.next();
                local_status = 1;
                for (int i = 0; i < motmp; i++) {
                    if (name[motmp].equals(name[i].toString())) {
                        System.out.println("--중복입니다. 다른 이름을 입력해주세요.");
                        local_status = 0;
                    }
                }
            }

            while (tempstatus == 0) {
                System.out.print((motmp + 1) + "번 국어점수를 입력하시오 : ");
                tempgap = sc.next();
                if (isStringInt(tempgap)) {
                    if (Integer.parseInt(tempgap) <= 100 && Integer.parseInt(tempgap) >= 0) {
                        kor[motmp] = Integer.parseInt(tempgap);
                        tempstatus = 1;
                    } else {
                        System.out.println(string_fail);
                    }
                } else {
                    System.out.println(string_fail);
                }
            }

            while (tempstatus == 1) {
                System.out.print((motmp + 1) + "번 영어점수를 입력하시오 : ");
                tempgap = sc.next();
                if (isStringInt(tempgap)) {
                    if (Integer.parseInt(tempgap) <= 100 && Integer.parseInt(tempgap) >= 0) {
                        eng[motmp] = Integer.parseInt(tempgap);
                        tempstatus = 2;
                    } else {
                        System.out.println(string_fail);
                    }
                } else {
                    System.out.println(string_fail);
                }
            }

            while (tempstatus == 2) {
                System.out.print((motmp + 1) + "번 수학점수를 입력하시오 : ");
                tempgap = sc.next();
                if (isStringInt(tempgap)) {
                    if (Integer.parseInt(tempgap) <= 100 && Integer.parseInt(tempgap) >= 0) {
                        mat[motmp] = Integer.parseInt(tempgap);
                        tempstatus = 3;
                    } else {
                        System.out.println(string_fail);
                    }
                } else {
                    System.out.println(string_fail);
                }
            }

            num[motmp] = motmp + 1;

            new func10(motmp);

            sum_func();
            avg_func();
            rank();
            align();

            motmp = motmp + 1;
        } catch (Exception e) {
            System.out.println("--현재 10명을 모두 입력했습니다. 더 이상 입력할 수 없습니다.");
        }
    }

    // 2.학생정보출력
    protected void printf_result() {
        String[] avg2 = new String[MAX];
        String[] name2 = new String[MAX];

        sum_func();
        avg_func();
        rank();
        align();
        
        print_line(52);
        System.out.println("번호  이름    국어  영어  수학  총점  평균    등수");
        print_line(52);
        for (int i = 0; i < motmp; i++) {
            avg2[i] = String.format("%.2f", avg[i]);
            name2[i] = String.format("%-5s", name[i]);
            System.out.println(" " + num[i] + "   " + name2[i] + "    "
                    + kor[i] + "  " + eng[i] + "  " + mat[i] + "  " + sum[i]
                    + "  " + avg2[i] + "  " + r[i]);
        }
        print_line(52);
    }

    // 3.학생정보검색
    protected void search(Shotgun g) {
        print_line();
        System.out.print("이름 입력하시오 : ");
        String tmp = sc.next();

        print_line(52);

        boolean local_status = false;

        for (int i = 0; i < motmp; i++) {
            if (tmp.equals(name[i].toString())) {
                local_status = super.search(g, i);
            }

        }
        if (local_status == false) {
            System.out.println(string_fail_name);
        }
        print_line(52);
    }

    // 4. 학생정보수정
    protected void Change() {
        String[] avg2 = new String[MAX];
        String[] name2 = new String[MAX];
        String tmp = null; // 임시 문자열 지역변수
        print_line();
        System.out.print("이름 입력하시오 : ");
        tmp = sc.next();
        print_line();

        int local_status = 0;

        for (int i = 0; i < motmp; i++) {
            if (tmp.equals(name[i].toString())) {
                System.out.println("번호(수정불가) : " + num[i]);
                System.out.println("이름(수정불가) : " + name[i]);

                String tmpgap = null;
                int tempstatus = 0;

                while (tempstatus == 0) {
                    System.out.print("국어(현재 " + kor[i] + "점)수정점수 : ");
                    tmpgap = sc.next();
                    if (isStringInt(tmpgap)) {
                        if (Integer.parseInt(tmpgap) <= 100 && Integer.parseInt(tmpgap) >= 0) {
                            kor[i] = Integer.parseInt(tmpgap);
                            tempstatus = 1;
                        } else {
                            System.out.println(string_fail);
                        }
                    } else {
                        System.out.println(string_fail);
                    }
                }

                while (tempstatus == 1) {
                    System.out.print("영어(현재 " + eng[i] + "점)수정점수 : ");
                    tmpgap = sc.next();
                    if (isStringInt(tmpgap)) {
                        if (Integer.parseInt(tmpgap) <= 100 && Integer.parseInt(tmpgap) >= 0) {
                            eng[i] = Integer.parseInt(tmpgap);
                            tempstatus = 2;
                        } else {
                            System.out.println(string_fail);
                        }
                    } else {
                        System.out.println(string_fail);
                    }
                }

                while (tempstatus == 2) {
                    System.out.print("수학(현재 " + mat[i] + "점)수정점수 : ");
                    tmpgap = sc.next();
                    if (isStringInt(tmpgap)) {
                        if (Integer.parseInt(tmpgap) <= 100 && Integer.parseInt(tmpgap) >= 0) {
                            mat[i] = Integer.parseInt(tmpgap);
                            tempstatus = 3;
                        } else {
                            System.out.println(string_fail);
                        }
                    } else {
                        System.out.println(string_fail);
                    }
                }

                new func10(i);

                print_line();
                System.out.println("수정후 점수");
                print_line(52);
                System.out.println("번호  이름    국어  영어  수학  총점  평균    등수");
                print_line(52);

                avg2[i] = String.format("%.2f", avg[i]);
                name2[i] = String.format("%-5s", name[i]);
                System.out.println(" " + num[i] + "   " + name2[i] + "    "
                        + kor[i] + "  " + eng[i] + "  " + mat[i] + "  " + sum[i]
                        + "  " + avg2[i] + "  " + r[i]);

                sum_func();
                avg_func();
                rank();
                align();

                local_status = 1;

                i = motmp;
            }
        }
        if (local_status == 0) {
            System.out.println(string_fail_name);
        }
        print_line(52);
    }

    // 5. 학생정보삭제
    protected void delete() {
        String[] avg2 = new String[MAX];
        String[] name2 = new String[MAX];
        String tmp = null; // 임시 문자열 지역변수
        print_line();
        System.out.print("이름 입력하시오 : ");
        tmp = sc.next();
        print_line(52);

        int local_status = 0;

        for (int i = 0; i < motmp; i++) {
            if (tmp.equals(name[i].toString())) {
                if (motmp - 1 != i) {
                    name[i] = name[motmp - 1];
                    num[i] = num[motmp - 1];
                    kor[i] = kor[motmp - 1];
                    eng[i] = eng[motmp - 1];
                    mat[i] = mat[motmp - 1];
                    sum[i] = sum[motmp - 1];
                    avg[i] = avg[motmp - 1];
                    r[i] = r[motmp - 1];
                }
                local_status = 1;
            }
        }
        if (local_status == 0) {
            System.out.println(string_fail_name);
        } else {
            motmp = motmp - 1;
            rank();
            align();
            System.out.println("번호  이름    국어  영어  수학  총점  평균    등수");
            print_line(52);
            for (int i = 0; i < motmp; i++) {
                avg2[i] = String.format("%.2f", avg[i]);
                name2[i] = String.format("%-5s", name[i]);
                System.out.println(" " + num[i] + "   " + name2[i] + "    "
                        + kor[i] + "  " + eng[i] + "  " + mat[i] + "  " + sum[i]
                        + "  " + avg2[i] + "  " + r[i]);
            }
        }
        print_line(52);
    }

    // 숫자 판별
    protected static boolean isStringInt(String s) {
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
        Shotgun g = new Shotgun(); // 자식 실행부
        
        while (true) {
            g.printf_start();
            String tempgap = Shotgun.sc.next();
            int tmepint = 0;

            try {
                tmepint = Integer.parseInt(tempgap);
            } catch (Exception e) {
            }

            switch (tmepint) {
                case 1: // 1.학생정보입력
                    g.scan_start();
                    break;
                case 2: // 2.학생정보출력
                    g.printf_result();
                    break;
                case 3: // 3.학생정보검색
                    g.search(g);
                    break;
                case 4: // 4.학생정보수정
                    g.Change();
                    break;
                case 5: // 4.학생정보삭제
                    g.delete();
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
