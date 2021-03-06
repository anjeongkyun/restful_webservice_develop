package com.example.restfulwebservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


//@JsonFilter("UserInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue
    private Integer userId;

    @Size(min=2, message = "Name은 2글자 이상 입력해주세요.")
    private String userName;
    @Past
    private Date joinDate;
    private String userPassword;
    private String userSsn;

    @OneToMany(mappedBy = "users")
    private List<Post> posts;

    public Users(Integer userId, String userName, Date joinDate, String userPassword, String userSsn) {
        this.userId = userId;
        this.userName = userName;
        this.joinDate = joinDate;
        this.userPassword = userPassword;
        this.userSsn = userSsn;
    }
}
