package chapter15.set;

public class Member {
    public String name;
    public int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // name 과 age 값이 같으면 true 를 리턴
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member){
            Member member = (Member) obj;
            return member.name.equals(name) && (member.age == age);
        } else {
            return false;
        }
    }

    // name 과 age 값이 같으면 동일한 hashCode 를 리턴
    @Override
    public int hashCode() {
        return name.hashCode() + age;   // String 의 해시코드를 이용
    }
}
