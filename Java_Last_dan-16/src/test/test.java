package test;

import java.util.Scanner;

class func10 {

    Scanner sc = new Scanner(System.in);

    final int MAX = 10;
    final String string_fail = "--잘못된 값입니다. 다시 입력해주세요.";
    static String[] name = null;
    static int[] num = null;
    static int[] kor = null;
    static int[] eng = null;
    static int[] mat = null;
    static int[] sum = null;
    static double[] avg = null;
    static int[] r = null;
    static int motmp = 0;

    public func10() {
        num = new int[MAX + 1];
        kor = new int[MAX + 1];
        eng = new int[MAX + 1];
        mat = new int[MAX + 1];
        sum = new int[MAX + 1];
        avg = new double[MAX + 1];
        name = new String[MAX + 1];
        r = new int[MAX + 1];
    }

    public func10(int nowno) // 생성자
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
}

class Shotgun extends func10 {

    void sum_func() {
        for (int i = 0; i < MAX; i++) {
            sum[i] = kor[i] + eng[i] + mat[i];
        }
    }

    void avg_func() {
        for (int i = 0; i < MAX; i++) {
            avg[i] = sum[i] / 3.0;
        }
    }

    void print_line() {
        System.out.println("---------------------------------");
    }

    void print_line(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    void rank() {
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

    void align() {
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

    void printf_start() {
        print_line();
        System.out.println("<<원하시는 번호를 선택하세요>>");
        print_line();
        System.out.println("1.학생정보입력");
        System.out.println("2.학생정보출력");
        System.out.println("3.학생정보검색");
        System.out.println("4.종료");
        System.out.print("선택번호 : ");
    }

    // 1.학생정보입력
    void scan_start() {
        String tempgap = null;
        int tempstatus = 0;

        if (motmp < MAX) {

            print_line();
            System.out.print((motmp + 1) + "번 이름 입력하시오 : ");
            name[motmp] = sc.next();

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
        } else {
            System.out.println("--현재 10명을 모두 입력했습니다. 더 이상 입력할 수 없습니다.");
        }
    }

    // 2.학생정보출력
    void printf_result() {
        String[] avg2 = new String[MAX + 1];
        String[] name2 = new String[MAX + 1];

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
    void search() {
        String[] avg2 = new String[MAX + 1];
        String[] name2 = new String[MAX + 1];
        String tmp = null; // 임시 문자열 지역변수
        print_line(52);
        System.out.print("이름 입력하시오 : ");
        tmp = sc.next();
        print_line(52);

        int local_status = 0;

        for (int i = 0; i < motmp; i++) {
            if (tmp.equals(name[i].toString())) {

                System.out.println("번호  이름    국어  영어  수학  총점  평균    등수");
                print_line(52);

                avg2[i] = String.format("%.2f", avg[i]);
                name2[i] = String.format("%-5s", name[i]);
                System.out.println(" " + num[i] + "   " + name2[i] + "    "
                        + kor[i] + "  " + eng[i] + "  " + mat[i] + "  " + sum[i]
                        + "  " + avg2[i] + "  " + r[i]);
                local_status = 1;
            }

        }
        if (local_status == 0) {
            System.out.println("--입력하신 이름은 없는 값입니다.");
        }
        print_line(52);
    }

    // 숫자 판별
    public static boolean isStringInt(String s) {
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
        Scanner sc = new Scanner(System.in);
        func10 f = new func10(); // 엄마 선언부
        Shotgun g = new Shotgun(); // 자식 실행부

        while (true) {
            g.printf_start();
            int tmp_num = sc.nextInt();
            switch (tmp_num) {
                case 1: // 1.학생정보입력
                    g.scan_start();
                    break;
                case 2: // 2.학생정보출력
                    g.printf_result();
                    break;
                case 3: // 3.학생정보검색
                    g.search();
                    break;
                case 4: // 4.종료
                    System.exit(0);
                    break;
                default:
                    System.out.println(f.string_fail);
                    break;
            }
        }
    }
}
