public class Department {
    String deptName;      // 학과명
    int reqTotal;         // 총 필요 학점
    int reqMajor;         // 필요 전공 학점
    int reqDesign;        // 필요 설계 학점
    int reqLiberal;       // 필요 교양 학점
    int reqFaith;         // 필요 신앙 학점

    //데이터세팅
    public Department(String name, int total, int major, int design, int liberal, int faith) {
        this.deptName = name;
        this.reqTotal = total;
        this.reqMajor = major;
        this.reqDesign = design;
        this.reqLiberal = liberal;
        this.reqFaith = faith;
    } 
    public void printRequirements() {
        System.out.println("\n💡 [" + this.deptName + "] 졸업 요건 안내 ");
        System.out.println("- 총 졸업 학점: " + this.reqTotal + "학점 이상");
        System.out.println("- 전공 학점: " + this.reqMajor + "학점 이상 (설계 " + this.reqDesign + "학점 포함)");
        System.out.println("- 교양 학점: " + this.reqLiberal + "학점 이상 (신앙 " + this.reqFaith + "학점 포함)");
        System.out.println("----------------------------------------");
    }
}