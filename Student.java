public class Student {
    String name;
    int myTotal, myMajor, myDesign, myLiberal, myFaith;
    int englishLevel;

    public Student(String name, int total, int major, int design, int liberal, int faith, int engLevel) {
        this.name = name;
        this.myTotal = total;
        this.myMajor = major;
        this.myDesign = design;
        this.myLiberal = liberal;
        this.myFaith = faith;
        this.englishLevel = engLevel;
    }

    public void checkGraduation(Department dept) {
        System.out.println("\n========================================");
        System.out.println(" [" + this.name + "] 학생의 졸업 심사 결과");
        System.out.println("========================================");
        boolean isPass = true;

        if (this.myTotal < dept.reqTotal) {
            System.out.println("❌ 총 이수 학점: " + (dept.reqTotal - this.myTotal) + "학점 부족");
            isPass = false;
        }
        if (this.myMajor < dept.reqMajor) {
            System.out.println("❌ 전공 학점: " + (dept.reqMajor - this.myMajor) + "학점 부족");
            isPass = false;
        }
        if (this.myDesign < dept.reqDesign) {
            System.out.println("❌ 설계 학점: " + (dept.reqDesign - this.myDesign) + "학점 부족");
            isPass = false;
        }
        if (this.myLiberal < dept.reqLiberal) {
            System.out.println("❌ 교양 학점: " + (dept.reqLiberal - this.myLiberal) + "학점 부족");
            isPass = false;
        }
        if (this.myFaith < dept.reqFaith) {
            System.out.println("❌ 신앙 학점: " + (dept.reqFaith - this.myFaith) + "학점 부족");
            isPass = false;
        }
        
        //영어 레벨
        String[] engNames = {"미이수", "EF", "EC", "ERC", "EAP"};
        if (this.englishLevel < 4) {
            System.out.println("❌ 영어 요건 미달: 현재 [" + engNames[this.englishLevel] + "] 단계");
            System.out.println("   (졸업을 위해 EAP까지 총 " + (4 - this.englishLevel) + "단계를 더 이수해야 합니다.)");
            isPass = false;
        }

        if (isPass) {
            System.out.println("\n🎉 축하합니다! 모든 요건을 충족했습니다. 🎉");
        } else {
            int totalShort = Math.max(0, dept.reqTotal - this.myTotal); 
            int semestersNeeded = (int) Math.ceil((double) totalShort / 18.0);
            if (this.englishLevel < 4) {
                if (semestersNeeded == 0) {
                    semestersNeeded = 1; 
                }
            }

            System.out.println("----------------------------------------");
            System.out.println("[잔여 학기 안내]");
            System.out.println("부족한 학점과 영어 단계를 고려할 때,");
            System.out.println("앞으로 최소 >> " + semestersNeeded + "학기 << 가 더 필요할 수 있습니다.");
        }
        System.out.println("========================================\n");
    }
}