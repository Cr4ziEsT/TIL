package my.examples.studentmanagement;

public class Student {
    private String name;
    private int korNum;
    private int engNum;
    private int mathNum;

    public Student(String name, int korNum, int engNum, int mathNum) {
        this.name = name;
        this.korNum = korNum;
        this.engNum = engNum;
        this.mathNum = mathNum;
    }

    public String getName() {
        return name;
    }

    public int getKorNum() {
        return korNum;
    }

    public int getEngNum() {
        return engNum;
    }

    public int getMathNum() {
        return mathNum;
    }
}
