package jpabook.start;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MEMBER")
public class Member {

    @Id
    @Column(name = "ID")
    private String id;  //아이디

    @Column(name = "NAME")
    private String username; //이름

    //매핑 정보가 없는 필드
    private Integer age;    //나이

    //Getter, setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() { return username;}
    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() { return age;}
    public void setAge(Integer age) {this.age = age;}
}