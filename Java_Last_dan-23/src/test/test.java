package test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class test {

    static final int MAX = 10;
    static int NOW = 0;

    static ArrayList<String> namelist = new ArrayList<String>();

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in); // 입력
            int why = 0;
            dash();
            System.out.println("<<원하시는 번호를 선택하세요>>");
            dash();
            System.out.println("1.과일이름입력");
            System.out.println("2.과일이름출력");
            System.out.println("3.과일이름검색");
            System.out.println("4.과일이름수정");
            System.out.println("5.과일이름삭제");
            System.out.println("6.과일이름정렬");
            System.out.println("7.종료");
            System.out.print("선택번호 : ");
            try {
                why = scanner.nextInt();
            } catch (Exception e) {
                why = 9;
            }
            switch (why) {
                case 1:
                    input();
                    break;
                case 2:
                    output();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    modified();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    align1();
                    /*
				align1();
                                align2();
                                align3();*/
                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("올바른 값을 적어주세요.");
            }
        }
    }

    static int search(int NOW, ArrayList<String> arraygap, String name) {
        int returngap = 0;
        for (int i = 0; i < NOW; i++) {
            if (name.equals(arraygap.get(i).toString())) {
                returngap = i;
                return returngap;
            }
        }
        return 15;
    }

    static void dash() {
        System.out.printf("----------------------------------\n");
    }

    static void dash(int a) {
        for (int i = 0; i < a; i++) {
            System.out.printf("-");
        }
        System.out.printf("\n");
    }

    static void delete() {
        Scanner scanner = new Scanner(System.in); // 입력

        String namewhy = null;
        int aaa = 15;

        dash();
        System.out.print("이름 입력하시오 : ");
        namewhy = scanner.next();

        for (int i = 0; i < NOW; i++) {
            if (namewhy.equals(namelist.get(i).toString())) {
                aaa = i;
            }
        }

        if (aaa == 15) {
            dash(45);
            System.out.println("입력한 이름의 데이터가 없습니다.");
            dash(45);
        } else {
            for (int i = 0; i < NOW; i++) {

            }

            namelist.remove(aaa);
            NOW = NOW - 1;

            dash(45);
            if (NOW == 0) {

            } else {
                for (int i = 0; i < NOW; i++) {
                    System.out.println(namelist.get(i));
                }
            }
            dash(45);
        }
    }

    static void input() {
        Scanner scanner = new Scanner(System.in); // 입력		

        if (NOW >= MAX) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("현재 " + MAX + "개를 모두 입력했습니다. 더 이상 입력할 수 없습니다.");
            }
        } else {
            dash();
            String namewhy = null;
            int aaa = 15;

            while (aaa == 15) {
                System.out.printf("과일 이름 입력 : ");
                namewhy = scanner.next();

                aaa = search(NOW, namelist, namewhy);

                if (namewhy.contains("Hong")) {
                    aaa = 999;
                }

                if (aaa == 15) {
                    namelist.add(namewhy);
                    aaa = -1;
                } else {
                    if (aaa == 999) {
                        System.out.printf("Hong가 들어간 이름은 사용할 수 없습니다. 다른 이름을 입력해주세요.\n");
                    } else {
                        System.out.printf("이미 있는 이름입니다. 다른 이름을 입력해주세요.\n");
                    }

                    aaa = 15;
                }
            }

            NOW = NOW + 1;
        }
    }

    static void align1() {
        Scanner scanner = new Scanner(System.in); // 입력	
        boolean status_tmp = true;

        while (status_tmp == true) {
            System.out.printf("오름차순=='1', 내림차순=='2' 입력 : ");
            String tmp123 = scanner.next();

            if (tmp123.equals("1")) {
                // 오름차순
                Collections.sort(namelist, new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        return obj1.compareToIgnoreCase(obj2);
                    }
                });
                status_tmp = false;
            } else if (tmp123.equals("2")) {
                // 오름차순
                Collections.sort(namelist, new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        return obj1.compareToIgnoreCase(obj2);
                    }
                });
                Collections.reverse(namelist);
                status_tmp = false;
            } else {
                status_tmp = true;
            }
        }
    }

    static void output() {
        dash(45);
        /*
		align1(numlist);
		align1(korlist);
		align1(englist);
		align1(matlist);
		align1(ranklist);
		align2(namelist);
		align3(avglist);
		align1(sumlist);*/

        if (NOW == 0) {

        } else {
            for (int i = 0; i < NOW; i++) {
                System.out.println(namelist.get(i));
            }
        }
        dash(45);
    }

    static void modified() {
        Scanner scanner = new Scanner(System.in); // 입력

        String namewhy = null;
        int aaa = 15;

        dash();
        System.out.print("과일 이름 입력하시오 : ");
        namewhy = scanner.next();

        aaa = search(NOW, namelist, namewhy);
        /*
		for(int i=0;i<NOW;i++){
			if(namewhy.equals(namelist.get(i).toString())){
				aaa=i;
			}
		}*/

        if (aaa == 15) {
            dash(45);
            System.out.println("입력한 과일 이름의 데이터가 없습니다.");
            dash(45);
        } else {
            dash(45);
            System.out.print("과일이름(현재 " + namelist.get(aaa) + ")점 수정점수 : ");
            namelist.set(aaa, scanner.next());

            dash(45);
            System.out.println(namelist.get(aaa));
            dash(45);
            /*
			align1(numlist);
			align1(korlist);
			align1(englist);
			align1(matlist);
			align1(ranklist);
			align2(namelist);
			align3(avglist);
			align1(sumlist);*/
        }
    }

    static void search() {

        Scanner scanner = new Scanner(System.in); // 입력

        String namewhy = null;
        int aaa = 15;

        dash();
        System.out.print("과일 이름 입력하시오 : ");
        namewhy = scanner.next();

        aaa = search(NOW, namelist, namewhy);
        /*
		for(int i=0;i<NOW;i++){
			if(namewhy.equals(namelist.get(i).toString())){
				aaa=i;
			}
		}*/

        if (aaa == 15) {
            dash(45);
            System.out.println("입력한 과일 이름의 데이터가 없습니다.");
            dash(45);
        } else {
            dash(45);
            System.out.println(namelist.get(aaa));
            dash(45);
        }
    }
}
