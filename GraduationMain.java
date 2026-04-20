import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class GraduationMain {
    
    //프로그램 어디서든 접근할 수 있도록 밖으로 꺼낸 변수들
    static Department[] deptList = new Department[50];
    static int deptCount = 0;

    public static void main(String[] args) {
        Scanner inputScan = new Scanner(System.in);

        while (true) {
            loadCSV(); 

            System.out.println("\n=====================================");
            System.out.println(" 한동대학교 졸업 요건 자가 진단 프로그램 ");
            System.out.println("=====================================");
            System.out.println("[메뉴] 1. 내 졸업 요건 검사하기");
            System.out.println("       2. 새 학과 기준 추가하기 (관리자 모드)");
            System.out.println("       3. 프로그램 종료");
            System.out.print("선택: ");
            
            int menu = inputScan.nextInt();

            if (menu == 3) {
                System.out.println("\n프로그램을 안전하게 종료합니다.");
                break;
            } else if (menu == 2) {
                System.out.print("🔒 관리자 비밀번호를 입력하세요: ");
                String pwd = inputScan.next();
                if (pwd.equals("1234")) {
                    System.out.println("🔓 인증 성공! 관리자 모드에 접속합니다.");
                    addNewDepartment(inputScan);
                } else {
                    System.out.println("❌ 비밀번호가 틀렸습니다. 메인 메뉴로 돌아갑니다.");
                }
                
            } else if (menu == 1) {
                checkMyGraduation(inputScan);
                
            } else {
                System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            }
        }
        inputScan.close();
    }

    //CSV 파일 읽기 
    public static void loadCSV() {
        deptCount = 0; 
        try {
            File file = new File("graduation_rules.csv");
            Scanner fileScan = new Scanner(file);
            if (fileScan.hasNextLine()) fileScan.nextLine(); 

            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] data = line.split(",");
                deptList[deptCount] = new Department(
                    data[0], Integer.parseInt(data[1].trim()), Integer.parseInt(data[2].trim()),
                    Integer.parseInt(data[3].trim()), Integer.parseInt(data[4].trim()), Integer.parseInt(data[5].trim())
                );
                deptCount++;
            }
            fileScan.close();
        } catch (FileNotFoundException e) {
            System.out.println("[시스템] graduation_rules.csv 파일을 찾을 수 없습니다.");
        }
    }

    // CSV 파일에 데이터 쓰기 (관리자 전용)
    public static void addNewDepartment(Scanner scan) {
        System.out.println("\n--- [관리자 모드] 새 학과 기준 추가 ---");
        System.out.print("1. 학과명: ");
        String name = scan.next();
        System.out.print("2. 총 졸업학점: ");
        int total = scan.nextInt();
        System.out.print("3. 전공학점: ");
        int major = scan.nextInt();
        System.out.print("4. 설계학점: ");
        int design = scan.nextInt();
        System.out.print("5. 교양합계학점: ");
        int liberal = scan.nextInt();
        System.out.print("6. 신앙및세계관학점: ");
        int faith = scan.nextInt();

        try {
            FileWriter fw = new FileWriter("graduation_rules.csv", true);
            PrintWriter pw = new PrintWriter(fw);
            
            String newData = name + "," + total + "," + major + "," + design + "," + liberal + "," + faith;
            pw.println(newData);
            pw.close();

            System.out.println("✅ 성공적으로 CSV 파일에 [" + name + "] 데이터가 추가되었습니다!");
        } catch (Exception e) {
            System.out.println("❌ 파일 저장 중 오류가 발생했습니다.");
        }
    }

    //학생 정보 심사
    public static void checkMyGraduation(Scanner scan) {
        System.out.print("\n학생 이름: ");
        String stuName = scan.next();
        
        System.out.println("\n[현재 등록된 학과 목록]");
        for (int i = 0; i < deptCount; i++) {
            System.out.println((i + 1) + ". " + deptList[i].deptName);
        }
        System.out.print("본인의 학과 번호를 선택하세요: ");
        int deptChoice = scan.nextInt();

        if (deptChoice < 1) {
            System.out.println("없는 학과 번호입니다. 메인 메뉴로 돌아갑니다.");
            return;
        }
 
        if (deptChoice > deptCount) {
            System.out.println("없는 학과 번호입니다. 메인 메뉴로 돌아갑니다.");
            return;
        }

        Department selectedDept = deptList[deptChoice - 1];
        selectedDept.printRequirements(); 
        
        System.out.println("\n--- [영어 이수 단계 선택] ---");
        System.out.println("0.미이수  1.EF  2.EC  3.ERC  4.EAP");
        System.out.print("현재 완료한 가장 높은 단계를 입력하세요(0~4): ");
        int engLevel = scan.nextInt();

        System.out.println("\n--- [" + stuName + "] 학생의 현재 이수 학점을 입력하세요 ---");
        System.out.print("총 이수 학점: ");
        int total = scan.nextInt();
        System.out.print("전공 이수 학점: ");
        int major = scan.nextInt();
        System.out.print("설계 이수 학점: ");
        int design = scan.nextInt();
        System.out.print("교양 이수 학점: ");
        int liberal = scan.nextInt();
        System.out.print("신앙 이수 학점: ");
        int faith = scan.nextInt();

        //입력 오류
        if (total < (major + liberal)) {
            System.out.println("\n[입력 오류] 전공(" + major + ")과 교양(" + liberal + ")의 합이 총 이수 학점(" + total + ")을 초과할 수 없습니다!");
            return; 
        }
        if (major < design) {
            System.out.println("\n[입력 오류] 설계 학점이 전체 전공 학점보다 클 수 없습니다!");
            return;
        }
        if (liberal < faith) {
            System.out.println("\n[입력 오류] 신앙 학점이 전체 교양 학점보다 클 수 없습니다!");
            return;
        }

        Student student = new Student(stuName, total, major, design, liberal, faith, engLevel);
        student.checkGraduation(selectedDept);
    }
}