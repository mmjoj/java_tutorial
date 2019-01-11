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
            String namewhy = null;
            int aaa = 15;
            System.out.printf("----------------------------------\n");
            System.out.println("<<원하시는 번호를 선택하세요>>");
            System.out.printf("----------------------------------\n");
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
                case 1: // 1.과일이름입력
                    if (NOW >= MAX) {
                        try {
                            throw new Exception();
                        } catch (Exception e) {
                            System.out.println("현재 " + MAX + "개를 모두 입력했습니다. 더 이상 입력할 수 없습니다.");
                        }
                    } else {
                        System.out.printf("----------------------------------\n");
                        while (aaa == 15) {
                            System.out.printf("과일 이름 입력 : ");
                            namewhy = scanner.next();

                            int returngap = 0;
                            for (int i = 0; i < NOW; i++) {
                                if (namewhy.equals(namelist.get(i).toString())) {
                                    returngap = 998;
                                }
                            }
                            if (returngap == 0) {
                                aaa = 15;
                            } else {
                                aaa = returngap;
                            }

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
                        break;
                    }
                case 2: // 2.과일이름출력
                    System.out.printf("--------------------------------------------\n");
                    if (NOW == 0) {

                    } else {
                        for (int i = 0; i < NOW; i++) {
                            System.out.println(namelist.get(i));
                        }
                    }
                    System.out.printf("--------------------------------------------\n");
                    break;
                case 3: // 3.과일이름검색
                    System.out.printf("----------------------------------\n");
                    System.out.print("과일 이름 입력하시오 : ");
                    namewhy = scanner.next();

                    int returngap = 111;
                    for (int i = 0; i < NOW; i++) {
                        if (namewhy.equals(namelist.get(i).toString())) {
                            System.out.printf("--------------------------------------------\n");
                            System.out.println(namelist.get(i));
                            System.out.printf("--------------------------------------------\n");
                            returngap = 0;
                        }
                    }
                    if (returngap == 111) {
                        System.out.printf("--------------------------------------------\n");
                        System.out.println("입력한 과일 이름의 데이터가 없습니다.");
                        System.out.printf("--------------------------------------------\n");
                        returngap= 0;
                    } 
                    break;
                case 4: // 4.과일이름수정
                    System.out.printf("----------------------------------\n");
                    System.out.print("과일 이름 입력하시오 : ");
                    namewhy = scanner.next();
                    int tmpmp=0;
                    returngap = 0;
                    for (int i = 0; i < NOW; i++) {
                        if (namewhy.equals(namelist.get(i).toString())) {
                            returngap = i;
                            tmpmp=1;
                        }
                    }
                    if (tmpmp == 1) {
                        aaa = returngap;
                    } else {
                        aaa = 15;
                    }
                    if (aaa == 15) {
                        System.out.printf("--------------------------------------------\n");
                        System.out.println("입력한 과일 이름의 데이터가 없습니다.");
                        System.out.printf("--------------------------------------------\n");
                    } else {
                        System.out.printf("--------------------------------------------\n");
                        System.out.print("과일 이름(현재 " + namelist.get(aaa) + ") 수정 : ");
                        namelist.set(aaa, scanner.next());
                        System.out.printf("--------------------------------------------\n");
                        System.out.println(namelist.get(aaa));
                        System.out.printf("--------------------------------------------\n");
                    }
                    break;
                case 5: // 5.과일이름삭제
                    System.out.printf("----------------------------------\n");
                    System.out.print("과일 이름 입력하시오 : ");
                    namewhy = scanner.next();
                    for (int i = 0; i < NOW; i++) {
                        if (namewhy.equals(namelist.get(i).toString())) {
                            aaa = i;
                        }
                    }
                    if (aaa == 15) {
                        System.out.printf("--------------------------------------------\n");
                        System.out.println("입력한 과일 이름의 데이터가 없습니다.");
                        System.out.printf("--------------------------------------------\n");
                    } else {
                        namelist.remove(aaa);
                        NOW = NOW - 1;
                        System.out.printf("--------------------------------------------\n");
                        if (NOW == 0) {

                        } else {
                            for (int i = 0; i < NOW; i++) {
                                System.out.println(namelist.get(i));
                            }
                        }
                        System.out.printf("--------------------------------------------\n");
                    }
                    break;
                case 6: // 6.과일이름정렬
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
                            // 내림차순
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
                    break;
                case 7: // 7.종료
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("올바른 값을 적어주세요.");
            }
        }
    }
}
