package com.example.registerformvalidation.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @NotEmpty
//    @Size(min=5 , max= 45, message = "thấp nhất 5 kí tự, tối đa 45 kí tự,và không đc trống")
    private String fistName;
//    @NotEmpty
//    @Size(min=5 , max= 45, message = "thấp nhất 5 kí tự, tối đa 45 kí tự,và không đc trống")
    private String lastName;
//    @NotEmpty
//    @Pattern(regexp = "^0[0-9]{9}$",message = "Số điện thoại bắt đầu từ số 0 giới hạn 10 số,và không đc trống")
    private String phoneNumber;
//    @Min(value = 18,message = "Số tuổi phải lớn hơn hoặc bằng 18, và không đc trống")
    private Integer age;
//    @NotEmpty
//    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$")
    private String email;
}
