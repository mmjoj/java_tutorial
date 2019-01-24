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
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class test {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String[] weeks = new String[100];

        int stat = 1;
        int tmpi = 0;
        int max = 0;

        // 읽기
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input_data.txt"), "UTF-8"));
            String str = null;
            while ((str = reader.readLine()) != null) {
                if (stat == 1) {
                    //  str = str.substring(1, str.length());
                    stat = 0;
                }
                // System.out.println(str);
                weeks[tmpi] = str;
                tmpi++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        max = tmpi;

        String[][] arra = new String[100][100];

        for (int i = 0; i < max; i++) {
            arra[i] = weeks[i].split(" ");
        }

        int MMAAXX = 10;

        String[] name = null; // 이름                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
        int[] num = null; // 번호
        int[] kor = null; // 국어 점수
        int[] eng = null; // 영어 점수
        int[] mat = null; // 수학 점수
        int[] sum = null; // 총점
        double[] avg = null; // 평균
        int[] r = null; // 랭크
        int motmp = 0; // 현재 몇번째 학생까지 있는가

        num = new int[MMAAXX];
        kor = new int[MMAAXX];
        eng = new int[MMAAXX];
        mat = new int[MMAAXX];
        sum = new int[MMAAXX + 1];
        avg = new double[MMAAXX];
        name = new String[MMAAXX];
        r = new int[MMAAXX + 1];

        String phoneNo = null;

        for (int i = 0; i < max; i++) {
            if (i == 0) {
                num[i] = Integer.parseInt(arra[i][0].substring(1));
            } else {
                num[i] = Integer.parseInt(arra[i][0]);
            }
            phoneNo = arra[i][0];

            name[i] = arra[i][1];
            kor[i] = Integer.parseInt(arra[i][2]);
            eng[i] = Integer.parseInt(arra[i][3]);
            mat[i] = Integer.parseInt(arra[i][4]);
            sum[i] = kor[i] + eng[i] + mat[i];
            avg[i] = sum[i] / 3.0;

            // 랭크
            for (int ii = 0; ii < max + 1; ii++) {
                int k = 0;
                for (int j = 0; j < max + 1; j++) {
                    if (sum[ii] < sum[j]) {
                        ++k;
                    }
                }
                ++k;
                r[ii] = k;
            }
        }

        int tmp = 0;
        double tmpf = 0.0f;
        String tmps;

        for (int i = 0; i < max + 1; i++) {
            for (int j = i; j < max + 1; j++) {
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

        // 쓰기
        String[] avg2 = new String[MMAAXX];
        String[] name2 = new String[MMAAXX];

        PrintWriter pw2 = new PrintWriter(new FileWriter("output_data.txt", false));
        pw2.write("");
        pw2.println("----------------------------------------------------");
        pw2.println("번호  이름    국어  영어  수학  총점  평균    등수");
        pw2.println("----------------------------------------------------");
        for (int i = 0; i < max; i++) {
            avg2[i] = String.format("%.2f", avg[i]);
            name2[i] = String.format("%-5s", name[i]);
            pw2.println(" " + num[i] + "   " + name2[i] + "    "
                    + kor[i] + "  " + eng[i] + "  " + mat[i] + "  " + sum[i]
                    + "  " + avg2[i] + "  " + r[i]);
        }
        pw2.println("----------------------------------------------------");
        pw2.close();

        // 읽기
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("output_data.txt"), "UTF-8"));
            String str = null;
            while ((str = reader.readLine()) != null) {
                if (stat == 1) {
                    //  str = str.substring(1, str.length());
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
        max = tmpi;
    }
}
