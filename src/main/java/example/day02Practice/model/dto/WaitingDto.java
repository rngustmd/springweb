package example.day02Practice.model.dto;

public class WaitingDto {

    // DTO: 데이터 이동객체??, 자바는 저장소가 아니다. 즉] 데이터베이스(저장소)가 저장소 
    // 1. 데이터베이스 표에서 (CRUD) 사용할 자료들을 private 멤버변수로 구성
    private int no;
    private String phone;
    private int count;
    // 2. 기본생성자, 전체매개변수생성자
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return "WaitingDto [no=" + no + ", phone=" + phone + ", count=" + count + "]";
    }
    
} // CLASS END 

