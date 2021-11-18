package com.codegym.casestudy.dto;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.customer.CustomerType;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDto implements Validator {

    private Integer customerId;

    @Pattern(regexp = "^(KH)-[0-9]{4}$",
            message = "Mã Khách hàng có định dạng là KH-XXXX (X là số từ 0-9)")
    private String customerCode;

    @NotBlank
    private String customerName;

    private String customerBirthday;

    private int customerGender;

    @NotBlank
    @Pattern(regexp = "[0-9]{9}|[0-9]{12}",
            message = "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String customerIdCard;

    @NotBlank
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$",
            message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String customerPhone;

    @NotBlank
    @Email(message = "Địa chỉ email phải đúng định dạng email")
    private String customerEmail;

    @NotBlank
    private String customerAddress;

    private CustomerType customerType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        if (customerDto.getCustomerBirthday().equals("")) {
            errors.rejectValue("customerBirthday", "", "Vui lòng không để trống");
        } else {
            int age = Period.between(LocalDate.parse(customerDto.getCustomerBirthday()), LocalDate.now()).getYears();
            if (age < 18) {
                errors.rejectValue("customerBirthday", "", "Tuổi của bạn phải >= 18");
            }
        }
    }

}

